package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.dao.*;
import com.mcl.pojo.Account;
import com.mcl.pojo.ResDeliverStatus;
import com.mcl.pojo.Resume;
import com.mcl.pojo.UserMsg;
import com.mcl.service.IResumeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Service("iResumeService")
public class IResumeServiceImpl implements IResumeService {

    @Autowired
    private ResumeMapper resumeMapper ;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper ;

    @Autowired
    private ResDeliverStatusMapper resDeliverStatusMapper ;

    @Autowired
    private UserMsgMapper userMsgMapper;

    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 创建或修改简历
     * @param resume
     * @return
     */
    @Override
    public ServerResponse saveOrUpdateResume(Resume resume) {
        if(resume!=null&&StringUtils.isNotBlank(resume.getOpenid())){
            //参数不为空
            int rowUser = userBaseInfoMapper.checkUserByOpenid(resume.getOpenid());
            if(rowUser>0){
                //存在用户
                if(resume.getId()!=null){
                    //参数id不为空
                    int rowResume = resumeMapper.checkResumeExist(resume.getId());
                    if(rowResume>0){
                        //存在则修改
                        int rowUpdateResume = resumeMapper.updateByPrimaryKeySelective(resume);
                        if(rowUpdateResume>0){
                            return ServerResponse.createBySuccess("更新成功");
                        }
                        return ServerResponse.createByErrorMessage("更新失败");
                    }
                    //不存在又传个简历id进来就是搞错了
                    return ServerResponse.createByErrorMessage("参数错误");
                }
                //简历id是空的那就创建
                int rowInsertResume = resumeMapper.insert(resume);
                if(rowInsertResume>0){
                    return ServerResponse.createBySuccess("创建成功");
                }
                return ServerResponse.createByErrorMessage("创建失败");
            }
        }
        return ServerResponse.createByErrorMessage("参数错误");
    }

    /**
     * 删除简历
     *
     * @param openid
     * @param id
     * @return
     */
    @Override
    public ServerResponse delResume(String openid, Integer id) {
        if(id!=null){
            //参数不为空
            int rowResume = resumeMapper.checkResumeExist(id);
            if(rowResume>0){
                //存在该简历
                Resume resume = resumeMapper.selectByPrimaryKey(id);
                if(resume.getOpenid().equals(openid)){
                    int rowDel = resumeMapper.deleteByPrimaryKey(id);
                    if(rowDel>0){
                        return ServerResponse.createBySuccess("删除成功");
                    }
                    return ServerResponse.createByErrorMessage("删除失败");
                }
                return ServerResponse.createByErrorMessage("不存在该简历");
            }
            return ServerResponse.createByErrorMessage("不存在该简历");
        }
        return ServerResponse.createByErrorMessage("参数错误");
    }


    /**
     * 查看简历详情
     * @param id
     * @return
     */
    @Override
    public ServerResponse detail(Integer id) {
        if(id!=null){
            int rowResume = resumeMapper.checkResumeExist(id);
            if(rowResume>0){
                Resume resume = resumeMapper.selectByPrimaryKey(id);
                return ServerResponse.createBySuccess(resume);
            }
            return ServerResponse.createByErrorMessage("不存在该简历");
        }
        return ServerResponse.createByErrorMessage("传入参数错误");
    }

    /**
     * 获取我的简历箱
     * @param pageNum
     * @param pageSize
     * @param resume
     * @param account
     * @return
     */
    @Override
    public ServerResponse<PageInfo> getResumeBox(int pageNum, int pageSize, Resume resume, Account account) {

        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("updatetime desc");
        List<Resume> list = resumeMapper.getResumeBox(account.getCompanyid());
        PageInfo pageResult = new PageInfo(list);
        return ServerResponse.createBySuccess(pageResult);
    }

    /**
     * 从简历箱中查看简历
     * @param id
     * @param companyid
     * @return
     */
    @Override
    @Transactional
    public ServerResponse getResumeFromBox(Integer id, String companyid) {
        if(id==null||StringUtils.isBlank(companyid)){
            return ServerResponse.createByErrorMessage("传入参数错误");
        }
        int row = resumeMapper.checkResumeCanGet(id,companyid);//看看有无权限获取该简历
        if(row>0){
            //有权限
            Resume resume = resumeMapper.selectByPrimaryKey(id);  //获取简历信息
            //判断是否需要更改状态为被查看
            ResDeliverStatus rds = resDeliverStatusMapper.selectByResumeId(id);
            if(rds.getViewed()!=1||rds.getStatus()==0){
                int rowView = resDeliverStatusMapper.viewedByResumeId(id);  //更改状态为被查看
                if(rowView>0){
                    //更改成功后，发一条消息到这个用户那里
                    UserMsg userMsg = new UserMsg();
                    userMsg.setOpenid(rds.getOpenid());
                    userMsg.setReadstatus(0);
                    userMsg.setMsgtitle("简历已被查看");
                    userMsg.setMsg("您的简历已被查看");
                    userMsg.setType("系统消息");
                    userMsgMapper.insert(userMsg);
                }
            }
            return ServerResponse.createBySuccess(resume);
        }
        return ServerResponse.createByErrorMessage("没有权限");
    }


    /**
     * 对投递到自己岗位的简历进行邀约面试，通过面试，更改为不合适
     * @param id
     * @param companyid
     * @param status
     * @param msg
     * @return
     */
    @Override
    @Transactional
    public ServerResponse changeResumeStatus(Integer id, String companyid, Integer status, String msg) {
        if(id==null||StringUtils.isBlank(companyid)){
            return ServerResponse.createByErrorMessage("传入参数错误");
        }
        int row = resumeMapper.checkResumeCanGet(id,companyid);//看看有无权限获取该简历
        if(row>0){
            //有权限
            ResDeliverStatus rds = resDeliverStatusMapper.selectByResumeId(id);
            UserMsg userMsg = null ;
            if(status==3&&StringUtils.isNotBlank(msg)){
                //发送邀约面试消息
                userMsg = new UserMsg();
                userMsg.setMsg(msg);
                userMsg.setType("企业消息");
                userMsg.setOpenid(rds.getOpenid());
                userMsg.setReadstatus(0);
                userMsg.setMsgtitle("您有【"+companyMapper.selectByPrimaryKey(companyid).getCompanyname()+"】面试邀约的消息");

            }else if(status==4){
                //发送消息
                userMsg = new UserMsg();
                userMsg.setMsg("您的面试已通过");
                userMsg.setType("企业消息");
                userMsg.setOpenid(rds.getOpenid());
                userMsg.setReadstatus(0);

            }else if(status==5){
                //发送消息
                userMsg = new UserMsg();
                userMsg.setMsg("您的面试不通过");
                userMsg.setType("企业消息");
                userMsg.setOpenid(rds.getOpenid());
                userMsg.setReadstatus(0);
            }else {
                return ServerResponse.createByErrorMessage("参数错误");
            }
            int rowInsert = userMsgMapper.insert(userMsg);
            rds.setStatus(status);
            int rowUpdate = resDeliverStatusMapper.updateByPrimaryKeySelective(rds);
            if(rowInsert>0&&rowUpdate>0){
                return ServerResponse.createBySuccess("更新成功");
            }
            return ServerResponse.createByErrorMessage("修改失败");
        }
        return ServerResponse.createByErrorMessage("没有权限");
    }

}
