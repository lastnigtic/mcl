package com.mcl.controller.wechat;

import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    /**
     * 进入小程序后存储或更新用户基本信息
     * @return
     */
    @RequestMapping(value = "saveorupdateuser.do",method = RequestMethod.POST)
    public ServerResponse saveOrUpdateUser(){
        //判断是否存在openid
        //存在就更新
        //不存在就新增
        return null ;
    }

    /**
     * 查询用户收藏的招聘信息条数
     * @param openid
     * @return
     */
    @RequestMapping(value = "getusercollectjobcount.do" ,method = RequestMethod.GET)
    public ServerResponse getUserCollectJobCount(String openid){
        //判断是否存在openid
        //存在就查询
        //不存在就返回error
        return null ;
    }

    /**
     * 查询用户收藏的招聘信息列表
     * @param openid
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "getusercollectjoblist.do" ,method = RequestMethod.GET)
    public ServerResponse<PageInfo> getUserCollectJobCount(
            @RequestParam(value="openid")String openid,
            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        //判断是否存在openid
        //存在就查询(联表查询)
        //不存在就返回error
        return  null;
    }

    /**
     * 本用户查看该条招聘信息是否已收藏
     * @param openid
     * @param joid
     * @return
     */
    @RequestMapping(value = "checkjobiscollect.do" ,method = RequestMethod.GET)
    public ServerResponse checkJobIsCollect(String openid,int joid){
        //判断是否存在openid,joid
        //都存在就查询(联表查询)
        //不存在就返回error
        return null ;
    }

    /**
     * 本用户查看该条招聘信息是否已投递
     * @param openid
     * @param joid
     * @return
     */
    @RequestMapping(value = "checkjobisdeliver.do" ,method = RequestMethod.GET)
    public ServerResponse<Integer> checkJobIsDeliver(String openid,int joid){
        //判断是否存在openid,joid
        //都存在就查询(联表查询)
        //不存在就返回error
        return null ;
    }

    /**
     * 用户收藏某条招聘信息
     * @param openid
     * @param joid
     * @return
     */
    @RequestMapping(value = "collectjob.do" ,method = RequestMethod.POST)
    public ServerResponse<Integer> collectJob(String openid,int joid){
        //判断是否存在openid,joid
        //都存在就新增一条记录
        //不存在就返回error
        return  null;
    }

    /**
     * 用户取消收藏某条招聘信息
     * @param openid
     * @param joid
     * @return
     */
    @RequestMapping(value = "uncollectjob.do" ,method = RequestMethod.POST)
    public ServerResponse<Integer> uncollectJob(String openid,int joid){
        //判断是否存在openid,joid
        //判断存在这条关联记录
        //都存在就删除这一条记录
        //不存在就返回error
        return null ;
    }

    /**
     * 用户给某条招聘信息投递简历
     * @param openid
     * @param joid
     * @param reid
     * @return
     */
    @RequestMapping(value = "deliverresume.do" ,method = RequestMethod.POST)
    public ServerResponse<Integer> deliverResume(String openid,int joid,int reid){
        //判断并验证openid,joid,reid
        //都通过就新增一条记录,用户消息那里也新增一条记录
        //不然就返回error
        return null;
    }

    /**
     * 用户提交意见反馈
     * @param openid
     * @param description
     * @return
     */
    @RequestMapping(value = "submitopinion.do" ,method = RequestMethod.POST)
    public ServerResponse<Integer> submitOpinion(String openid,String description){
        return null;
    }

    /**
     * 用户查看投递过的招聘信息
     * @param openid
     * @return
     */
    @RequestMapping(value = "getDeliveredJob.do" ,method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> getDeliveredJob(String openid){
        //判断openid是否存在
        //存在就查...
        return null;
    }


    /**
     * 用户给公司评分
     * @param openid
     * @param companyid
     * @param credit
     * @return
     */
    @RequestMapping(value = "ratetocompany.do" ,method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse rateToCompany(String openid,int companyid,double credit){
        //判断openid是否存在
        //判断是否有过面试完成记录
        //如有，则可以评分
        return null;
    }
}
