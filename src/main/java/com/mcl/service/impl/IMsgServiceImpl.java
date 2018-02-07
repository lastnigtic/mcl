package com.mcl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.dao.CompanyMsgMapper;
import com.mcl.dao.JobOffersMapper;
import com.mcl.dao.UserBaseInfoMapper;
import com.mcl.dao.UserMsgMapper;
import com.mcl.pojo.CompanyMsg;
import com.mcl.pojo.JobOffers;
import com.mcl.pojo.UserBaseInfo;
import com.mcl.pojo.UserMsg;
import com.mcl.service.IJobOffersServcie;
import com.mcl.service.IMsgService;
import com.mcl.vo.JobOffersVO;
import com.mcl.vo.MsgVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/5 0005.
 */
@Service("iMsgService")
public class IMsgServiceImpl implements IMsgService {

    @Autowired
    private UserMsgMapper userMsgMapper ;

    @Autowired
    private CompanyMsgMapper companyMsgMapper ;

    @Autowired
    private JobOffersMapper jobOffersMapper ;

    @Autowired
    private IJobOffersServcie iJobOffersServcie ;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;

    /**
     * 组装消息VO返回给小程序端
     * @param userMsg
     * @return
     */
    @Override
    public MsgVO getMsgVOFromUserMsg(UserMsg userMsg) {

        if(userMsg==null)
            return null;

        JobOffers job = null ;

        JobOffersVO jobvo = null ;

        MsgVO msgVO = new MsgVO();

        msgVO.setUserMsg(userMsg);

        if(userMsg.getJoid()!=null){

            job = jobOffersMapper.selectByPrimaryKey(userMsg.getJoid());

            jobvo = iJobOffersServcie.getJobOffersVOFromJobOffers(job);

            if(jobvo!=null)
                msgVO.setJob(jobvo);
        }

        return msgVO;
    }

    /**
     * 组装消息VO返回给前端
     * @param companyMsg
     * @return
     */
    @Override
    public MsgVO getMsgVOFromCompMsg(CompanyMsg companyMsg) {
        return null;
    }

    /**
     * 获取消息列表
     *
     * @param pageNum
     * @param pageSize
     *@param companyMsg  @return
     */
    @Override
    public ServerResponse getCompMsgList(int pageNum, int pageSize, CompanyMsg companyMsg) {
        PageHelper.startPage(pageNum,pageSize);

        if(StringUtils.isBlank(companyMsg.getCompanyid()))
            return ServerResponse.createByErrorMessage("参数为空");

        List<CompanyMsg> list = companyMsgMapper.selectList(companyMsg);

        PageInfo pageInfo = new PageInfo(list);

        return ServerResponse.createBySuccess(pageInfo);
    }

    /**
     * 将消息设置为已读
     * @param id
     * @return
     */
    @Override
    public ServerResponse readCompMsg(Integer id) {
        if(id==null)
            return ServerResponse.createByErrorMessage("参数为空");

        int row = companyMsgMapper.readMsg(id);

        if(row>0)
            return ServerResponse.createBySuccess("成功");

        return ServerResponse.createByErrorMessage("错误");
    }
    /**
     * 获取某条信息的详情
     * @param id
     * @return
     */
    @Override
    public ServerResponse getCompMsg(Integer id) {
        if(id==null)
            return ServerResponse.createByErrorMessage("参数为空");

        CompanyMsg companyMsg = companyMsgMapper.selectByPrimaryKey(id);

        if(companyMsg!=null)
            return ServerResponse.createBySuccess(companyMsg);

        return ServerResponse.createByErrorMessage("查询失败");
    }

    /**
     * 将自己的某条消息设置为已读
     * @param openid
     * @param id
     * @return
     */
    @Override
    public ServerResponse readCompMsg(String openid, Integer id) {
        if(StringUtils.isBlank(openid)||id==null)
            return ServerResponse.createByErrorMessage("参数为空");

        int rowUser = userBaseInfoMapper.checkUserByOpenid(openid);

        if(rowUser==0)
            return ServerResponse.createByErrorMessage("不存在用户");

        UserMsg userMsg = userMsgMapper.selectByPrimaryKey(id);

        if(userMsg!=null){
            if(userMsg.getReadstatus()==1)
                return ServerResponse.createBySuccess("已经是已读");
            userMsg.setReadstatus(1);
            userMsgMapper.updateByPrimaryKey(userMsg);
            return ServerResponse.createBySuccess("成功");
        }

        return ServerResponse.createByErrorMessage("找不到记录");
    }

    /**
     * 获取个人消息列表（可以筛选已读未读）
     * @param openid
     * @param pageNum
     * @param pageSize
     * @param readstatus
     * @return
     */
    @Override
    public ServerResponse<PageInfo> myMsg(String openid, int pageNum, int pageSize, Integer readstatus) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("updatetime desc");
        List<UserMsg> list = userMsgMapper.selectList(openid,readstatus);
        List<MsgVO> volist = new ArrayList<>();
        PageInfo pageResult = new PageInfo(list);

        for(UserMsg userMsg : list){
            volist.add(getMsgVOFromUserMsg(userMsg));
        }
        //将封装好的volist放进去
        pageResult.setList(volist);
        return ServerResponse.createBySuccess(pageResult);

    }
    /**
     * 获取个人某条信息
     * @param id
     * @param openid
     * @return
     */
    @Override
    public ServerResponse msg(Integer id, String openid) {
        if(StringUtils.isNotBlank(openid)&&id!=null){
            int rowUser = userBaseInfoMapper.checkUserByOpenid(openid);
            if(rowUser>0){
                //存在
                UserMsg userMsg = userMsgMapper.selectByPrimaryKey(id);
                if(userMsg!=null){
                    if(userMsg.getReadstatus()!=null&&userMsg.getReadstatus()!=1){
                        userMsg.setReadstatus(1);
                        userMsgMapper.updateByPrimaryKey(userMsg);
                    }
                    return ServerResponse.createBySuccess(getMsgVOFromUserMsg(userMsg));
                }
                return ServerResponse.createByErrorMessage("不存在的消息");
            }
            return ServerResponse.createByErrorMessage("找不到用户信息");
        }
        return ServerResponse.createByErrorMessage("传入参数错误");
    }

    /**
     * 删除用户的消息
     * @param id
     * @param openid
     * @return
     */
    @Override
    public ServerResponse delUserMsg(Integer id, String openid) {
        if(StringUtils.isNotBlank(openid)&&id!=null) {
            int rowUser = userBaseInfoMapper.checkUserByOpenid(openid);
            if (rowUser > 0) {
                //存在
                UserMsg userMsg = userMsgMapper.selectByPrimaryKey(id);
                if (userMsg != null&&userMsg.getOpenid().equals(openid)) {
                    int rowDel = userMsgMapper.deleteByPrimaryKey(id);
                    if (rowDel > 0) {
                        return ServerResponse.createBySuccess("删除成功");
                    }
                    return ServerResponse.createByErrorMessage("删除失败");
                }
                return ServerResponse.createByErrorMessage("不存在的消息");
            }
            return ServerResponse.createByErrorMessage("找不到用户信息");
        }
        return ServerResponse.createByErrorMessage("传入参数错误");
    }

    /**
     * 删除某条企业消息
     * @param id
     * @return
     */
    @Override
    public ServerResponse delCompMsg(Integer id) {
        if(id==null)
            return ServerResponse.createByErrorMessage("参数为空");

        int rowDel = companyMsgMapper.deleteByPrimaryKey(id);

        if(rowDel>0)
            return ServerResponse.createBySuccess("删除成功");

        return ServerResponse.createByErrorMessage("删除失败");
    }
}
