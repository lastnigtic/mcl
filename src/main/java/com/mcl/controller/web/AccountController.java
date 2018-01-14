package com.mcl.controller.web;

import com.mcl.common.Const;
import com.mcl.common.ResponseCode;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.Account;
import com.mcl.pojo.Company;
import com.mcl.pojo.JobOffers;
import com.mcl.pojo.Resume;
import com.mcl.service.IAccountService;
import com.mcl.service.ICompanyService;
import com.mcl.service.IJobOffersServcie;
import com.mcl.service.IResumeService;
import com.mcl.util.DateTimeUtil;
import com.mcl.util.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/1/13 0013.
 */
@RestController
public class AccountController {


    @Autowired
    private IAccountService iAccountService ;


    @Autowired
    private ICompanyService iCompanyService;

    @Autowired
    private IJobOffersServcie iJobOffersServcie ;


    @Autowired
    private IResumeService iResumeService;
    /**
     * 商家登录接口
     * @param uname
     * @param upass
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ServerResponse login(String uname, String upass, HttpSession session){
        ServerResponse<Account> response = iAccountService.login(uname,upass);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    /**
     * 商家注册接口
     * @param account
     * @return
     */
    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    public ServerResponse<String> register(Account account){
        return iAccountService.register(account);
    }

    /**
     * 创建或者更新公司信息
     * @param company
     * @param session
     * @return
     */
    @RequestMapping(value = "saveorupdatecompany.do",method = RequestMethod.POST)
    public ServerResponse saveOrUpdateCompany(Company company,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iAccountService.saveOrUpdateCompany(account.getId(),company);
    }


    /**
     * 判断是否已经认证
     * @param session
     * @return
     */
    @RequestMapping(value = "ispassverified.do" ,method = RequestMethod.GET)
    public ServerResponse isPassVerified(HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iAccountService.isPassVerified(account.getId());
    }


    /**
     * 发布信息
     * @param jobOffers
     * @param session
     * @return
     */
    @RequestMapping(value = "addjob.do",method = RequestMethod.POST)
    public ServerResponse addJob(JobOffers jobOffers,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        Company company = iAccountService.getCompanyByAccount(account.getId());
        if(company.getChecked()==0){
            return ServerResponse.createByErrorMessage("未通过认证");
        }
        jobOffers.setCompanyid(company.getId());
        return iJobOffersServcie.addJob(jobOffers);

    }

    /**
     * 更新发布的信息
     * @param jobOffers
     * @param session
     * @return
     */
    @RequestMapping(value = "updatejob.do",method = RequestMethod.POST)
    public ServerResponse updateJob(JobOffers jobOffers,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        Company company = iAccountService.getCompanyByAccount(account.getId());
        if(company==null)return ServerResponse.createByErrorMessage("未有公司信息");
        if(company.getChecked()==0){
            return ServerResponse.createByErrorMessage("未通过认证");
        }
        return iJobOffersServcie.updateJob(jobOffers);
    }


    /**
     * 删除发布过的信息
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "deljob.do",method = RequestMethod.POST)
    public ServerResponse delJob(Integer id,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        Company company = iAccountService.getCompanyByAccount(account.getId());
        if(company.getChecked()==0){
            return ServerResponse.createByErrorMessage("未通过认证");
        }
        return iJobOffersServcie.delJob(id,account.getCompanyid());
    }

    /**
     * 获取我发布过的列表
     * @param pageNum
     * @param pageSize
     * @param jobOffers
     * @param session
     * @return
     */
    @RequestMapping(value = "joblist.do",method = RequestMethod.POST)
    public ServerResponse jobList(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                  JobOffers jobOffers,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iJobOffersServcie.list(pageNum,pageSize,account,jobOffers);
    }


    /**
     * 获取招聘信息的详细信息
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "getjob.do",method = RequestMethod.POST)
    public ServerResponse getJob(Integer id,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iJobOffersServcie.getJob(id,account.getCompanyid());
    }


    /**
     * 企业获取投递到自己岗位的简历信息
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "getresume.do",method = RequestMethod.POST)
    public ServerResponse getResume(Integer id,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iResumeService.getResumeFromBox(id,account.getCompanyid());
    }

    /**
     * 对投递到自己岗位的简历进行邀约面试，通过面试，更改为不合适
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "changeresumestatus.do",method = RequestMethod.POST)
    public ServerResponse changeResumeStatus(@RequestParam("id") Integer id,@RequestParam("status") Integer status ,@RequestParam(value = "msg",required = false) String msg,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iResumeService.changeResumeStatus(id,account.getCompanyid(),status,msg);
    }

    /**
     * 获取我的简历箱
     * @param pageNum
     * @param pageSize
     * @param resume
     * @param session
     * @return
     */
    @RequestMapping(value = "myresumebox.do",method = RequestMethod.POST)
    public ServerResponse getResumeBox(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                       Resume resume, HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        Company company = iAccountService.getCompanyByAccount(account.getId());
        if(company==null)return ServerResponse.createByErrorMessage("未有公司信息");
        if(company.getChecked()==0){
            return ServerResponse.createByErrorMessage("未通过认证");
        }
        return iResumeService.getResumeBox(pageNum,pageSize,resume,account);
    }

    /**
     * 提交实名认证资料
     * @param file
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "verified",method = RequestMethod.POST)
    public ServerResponse verified(@RequestParam(value = "uploadfile",required = false) MultipartFile file,HttpSession session, HttpServletRequest request){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        Company company = iAccountService.getCompanyByAccount(account.getId());
        if(company==null){
            return ServerResponse.createByErrorMessage("未找到贵公司的信息");
        }
        //存放路径
        String uploadpath = request.getSession().getServletContext().getRealPath(PropertiesUtil.getProperty("ftp.uploadimg.rootpath"))+"/"+ DateTimeUtil.dateToStr(new Date(),"yyyyMMdd");
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
        company.setCompanylicense(backpath);
        iCompanyService.updateCompany(company);
        //然后返回这个路径
        return ServerResponse.createBySuccess(backpath);
    }

}
