package com.mcl.controller.wechat;

import com.github.pagehelper.PageInfo;
import com.mcl.common.Const;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.*;
import com.mcl.service.IScoreService;
import com.mcl.service.IUserService;
import com.mcl.util.DateTimeUtil;
import com.mcl.util.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private IUserService iUserService ;

    @Autowired
    private IScoreService iScoreService ;

    /**
     * 进入小程序后存储或更新用户基本信息
     * @return
     */
    @RequestMapping(value = "saveorupdateuser.do",method = RequestMethod.POST)
    public ServerResponse saveOrUpdateUser(UserBaseInfo userBaseInfo){
        return iUserService.saveOrUpdateUser(userBaseInfo) ;
    }

    /**
     * 判断是否初次登录
     * @param openid
     * @return
     */
    @RequestMapping(value = "isfirstlogin.do",method = RequestMethod.POST)
    public ServerResponse isUserFirstLogin(String openid){
        return iUserService.isUserFirstLogin(openid);
    }

    /**
     * 查询用户收藏的招聘信息条数
     * @param openid
     * @return
     */
    @RequestMapping(value = "getusercollectjobcount.do" ,method = RequestMethod.POST)
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
    @RequestMapping(value = "getusercollectjoblist.do" ,method = RequestMethod.POST)
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
    @RequestMapping(value = "checkjobiscollect.do" ,method = RequestMethod.POST)
    public ServerResponse checkJobIsCollect(String openid,Integer joid){
        return iUserService.checkJobIsCollect(openid,joid) ;
    }

    /**
     * 本用户查看该条招聘信息是否已投递
     * @param openid
     * @param joid
     * @return
     */
    @RequestMapping(value = "checkjobisdeliver.do" ,method = RequestMethod.POST)
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
     * 获取个人基本信息
     * @param openid
     * @return
     */
    @RequestMapping(value = "info.do",method = RequestMethod.POST)
    public ServerResponse info(String openid){
        return iUserService.info(openid);
    }

    /**
     * 获取个人简历列表
     * @param openid
     * @return
     */
    @RequestMapping(value = "myresumelist.do",method = RequestMethod.POST)
    public ServerResponse myResumeList(String openid){
        return iUserService.myResumeList(openid);
    }

    /**
     * 获取个人消息列表
     * @param pageNum
     * @param pageSize
     * @param openid
     * @param readstatus
     * @return
     */
    @RequestMapping(value = "mymsg.do",method = RequestMethod.POST)
    public ServerResponse myMsg(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                @RequestParam(value = "openid") String openid,@RequestParam(required = false)Integer readstatus){
        return iUserService.myMsg(openid,pageNum,pageSize,readstatus);
    }

    /**
     * 获取个人消息
     * @param id
     * @return
     */
    @RequestMapping(value = "msg.do",method = RequestMethod.POST)
    public ServerResponse msg(Integer id,String openid){
        return iUserService.msg(id,openid);
    }

    /**
     * 删除自己的某条消息
     * @param id
     * @param openid
     * @return
     */
    @RequestMapping(value = "delmsg.do",method = RequestMethod.POST)
    public ServerResponse delMsg(Integer id,String openid){
        return iUserService.delMsg(id,openid);
    }

    /**
     * 用户给公司评分
     * @param companyScore
     * @return
     */
    @RequestMapping(value = "ratetocompany.do" ,method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse rateToCompany(CompanyScore companyScore){
        return iUserService.rateToCompany(companyScore);
    }
    /**
     * 判断用户能否对公司评分
     * @param openid
     * @param companyid
     * @return
     */
    @RequestMapping(value = "canscorecompany.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse isUserHaveAuthorityScoreCompany(String openid,String companyid,Integer joid){
        boolean canscorecompany = iUserService.isUserHaveAuthorityScoreCompany(openid,companyid,joid);
        if(canscorecompany){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }
    /**
     * 上传头像
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "uploadavatar.do",method = RequestMethod.POST)
    public ServerResponse uploadAvatar(@RequestParam(value = "filePath",required = false) MultipartFile file, HttpServletRequest request){
        String openid = request.getParameter("openid");
        if(!iUserService.checkOpenid(openid))
            return ServerResponse.createByErrorMessage("用户不存在");
        //存放路径
        String uploadpath = request.getSession().getServletContext().getRealPath(PropertiesUtil.getProperty("upload.avatar.rootpath"))+"/"+ DateTimeUtil.dateToStr(new Date(),"yyyyMMdd");
        //文件原始名
        String fileName = file.getOriginalFilename();
        //扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        //上传后的文件名
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
        //上传临时路径是否存在，不存在则要创建
        File fileDir = new File(uploadpath);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(uploadpath,uploadFileName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            return null;
        }
        //返回一个路径
        String backpath = DateTimeUtil.dateToStr(new Date(),"yyyyMMdd")+"/"+targetFile.getName();
        //保存或更新到数据库
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        userBaseInfo.setAvatarurl(backpath);
        userBaseInfo.setOpenid(openid);
        iUserService.saveOrUpdateUser(userBaseInfo);
        return ServerResponse.createBySuccess(backpath);
    }


    /**
     * 获取用户的六种能力平均分
     * @param openid
     * @return
     */
    @RequestMapping(value = "getuseravgability.do",method = RequestMethod.POST)
    public ServerResponse getUserAvgAbility(String openid){
        return iScoreService.getUserAvgAbility(openid);
    }

    /**
     * 获取企业的六种能力平均分
     * @param companyid
     * @return
     */
    @RequestMapping(value = "getcompavgrate.do",method = RequestMethod.POST)
    public ServerResponse get(String companyid){
        return iScoreService.getCompAvgAbility(companyid);
    }

    /**
     * 获取评分列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "ratelist.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse rateList(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,UserScore userScore){
        return iScoreService.getUserRateList(pageNum,pageSize,userScore);
    }

}
