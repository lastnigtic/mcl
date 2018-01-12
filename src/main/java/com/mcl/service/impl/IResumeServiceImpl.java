package com.mcl.service.impl;

import com.mcl.common.ServerResponse;
import com.mcl.dao.ResumeMapper;
import com.mcl.dao.UserBaseInfoMapper;
import com.mcl.pojo.Resume;
import com.mcl.service.IResumeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Service("iResumeService")
public class IResumeServiceImpl implements IResumeService {

    @Autowired
    private ResumeMapper resumeMapper ;

    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper ;

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
}
