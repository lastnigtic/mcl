package com.mcl.controller.wechat;

import com.github.pagehelper.PageInfo;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.Opinion;
import com.mcl.pojo.UserBaseInfo;
import com.mcl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private IUserService iUserService ;

    /**
     * 进入小程序后存储或更新用户基本信息
     * @return
     */
    @RequestMapping(value = "saveorupdateuser.do",method = RequestMethod.POST)
    public ServerResponse saveOrUpdateUser(UserBaseInfo userBaseInfo){
        return iUserService.saveOrUpdateUser(userBaseInfo) ;
    }

    /**
     * 查询用户收藏的招聘信息条数
     * @param openid
     * @return
     */
    @RequestMapping(value = "getusercollectjobcount.do" ,method = RequestMethod.GET)
    public ServerResponse getUserCollectJobCount(String openid){
        return iUserService.getUserCollectJobCount(openid) ;
    }

    /**
     * 查询用户收藏的招聘信息列表
     * @param openid
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "getusercollectjoblist.do" ,method = RequestMethod.GET)
    public ServerResponse<PageInfo> getUserCollectJobList(
            @RequestParam(value="openid")String openid,
            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return  iUserService.getUserCollectJobList(openid,pageNum,pageSize);
    }

    /**
     * 本用户查看该条招聘信息是否已收藏
     * @param openid
     * @param joid
     * @return
     */
    @RequestMapping(value = "checkjobiscollect.do" ,method = RequestMethod.GET)
    public ServerResponse checkJobIsCollect(String openid,Integer joid){
        return iUserService.checkJobIsCollect(openid,joid) ;
    }

    /**
     * 本用户查看该条招聘信息是否已投递
     * @param openid
     * @param joid
     * @return
     */
    @RequestMapping(value = "checkjobisdeliver.do" ,method = RequestMethod.GET)
    public ServerResponse<Integer> checkJobIsDeliver(String openid,Integer joid){
        return iUserService.checkJobIsDeliver(openid,joid) ;
    }

    /**
     * 用户收藏某条招聘信息
     * @param openid
     * @param joid
     * @return
     */
    @RequestMapping(value = "collectjob.do" ,method = RequestMethod.POST)
    public ServerResponse collectJob(String openid,Integer joid){
        return  iUserService.collectJob(openid,joid);
    }

    /**
     * 用户取消收藏某条招聘信息
     * @param openid
     * @param joid
     * @return
     */
    @RequestMapping(value = "uncollectjob.do" ,method = RequestMethod.POST)
    public ServerResponse uncollectJob(String openid,Integer joid){
        return iUserService.uncollectJob(openid,joid);
    }

    /**
     * 用户给某条招聘信息投递简历
     * @param openid
     * @param joid
     * @param reid
     * @return
     */
    @RequestMapping(value = "deliverresume.do" ,method = RequestMethod.POST)
    public ServerResponse deliverResume(String openid,Integer joid,Integer reid){
        return iUserService.deliverResume(openid,joid,reid);
    }

    /**
     * 用户提交意见反馈
     * @return
     */
    @RequestMapping(value = "submitopinion.do" ,method = RequestMethod.POST)
    public ServerResponse submitOpinion(Opinion opinion){
        return iUserService.submitOpinion(opinion);
    }

    /**
     * 用户查看投递过的招聘信息
     * @param openid
     * @return
     */
    @RequestMapping(value = "getuserdeliveredlist.do" ,method = RequestMethod.POST)
    public ServerResponse getUserDeliveredList(@RequestParam(value="openid")String openid,
                                          @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                          @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                          @RequestParam(required = false)Integer status){
        return iUserService.getUserDeliveredList(openid,pageNum,pageSize,status);
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
