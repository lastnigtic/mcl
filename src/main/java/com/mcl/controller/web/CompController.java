package com.mcl.controller.web;

import com.github.pagehelper.PageInfo;
import com.mcl.common.Const;
import com.mcl.common.ResponseCode;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.Account;
import com.mcl.pojo.Company;
import com.mcl.pojo.JobOffers;
import com.mcl.pojo.Resume;
import com.mcl.service.*;
import com.mcl.util.DateTimeUtil;
import com.mcl.util.PropertiesUtil;
import com.mcl.vo.ResumeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * Created by Administrator on 2018/1/13 0013.
 */
@Controller
@RequestMapping(value = "/comp/")
public class CompController {


    @Autowired
    private IAccountService iAccountService ;


    @Autowired
    private ICompanyService iCompanyService;

    @Autowired
    private IJobOffersServcie iJobOffersServcie ;


    @Autowired
    private IResumeService iResumeService;

    @Autowired
    private ITagPropertyService iTagPropertyService;

    /**
     * 取首页
     * @return
     */
    @RequestMapping(value = "index.html")
    public String compIndex(){
        return "/company/index";
    }

    /**
     * 新增岗位页面
     * @return
     */
    @RequestMapping(value = "addjob.html")
    public String addJob(Model model){

        model.addAttribute("eduproperty",iTagPropertyService.getEduPropertyList());
        model.addAttribute("cityproperty",iTagPropertyService.getCityPropertyList());
        model.addAttribute("jobtagproperty",iTagPropertyService.getJobTageList());
        model.addAttribute("jobtypeproperty",iTagPropertyService.getJobTypeList());

        return "/company/addjob";
    }

    /**
     * 岗位详细信息页面
     * @return
     */
    @RequestMapping(value = "jobinfo.html")
    public String jobInfo(HttpSession session , Integer id ,Model model){

        Account account = (Account)session.getAttribute(Const.CURRENT_USER);

        ServerResponse serverResponse = iJobOffersServcie.getJob(id,account.getCompanyid());

        JobOffers job = (JobOffers) serverResponse.getData();

        if(serverResponse.isSuccess()){
            model.addAttribute("job",job);
        }
        return "/company/jobinfo";
    }


    /**
     * 从收到的简历页进入查看简历的详情
     * @param model
     * @param id  投递表的id
     * @param resumeid  简历表的id
     * @param session
     * @return
     */
    @RequestMapping(value = "resume.html")
    public String resumeFromBox(Model model,Integer id,Integer resumeid,HttpSession session){
        //TODO 鉴权，是否投递到自己岗位的简历
        ServerResponse response = iResumeService.getResumeVOByRdsIdAndResId(id,resumeid);
        ResumeVO r = (ResumeVO)response.getData();
        model.addAttribute("id",id);
        if(response.isSuccess()){
            model.addAttribute("resume",r);
            return "/company/resume";
        }
        return "/company/jobresume";
    }


    /**
     * 我发布的岗位信息页面
     * @return
     */
    @RequestMapping(value = "myjob.html")
    public String myJob(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                        JobOffers jobOffers,HttpSession session,Model model){

        Account account = (Account)session.getAttribute(Const.CURRENT_USER);

        ServerResponse response = iJobOffersServcie.list(pageNum,pageSize,account,jobOffers);

        if(response.isSuccess()){
            PageInfo<JobOffers> pageInfo = (PageInfo<JobOffers>) response.getData();
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("joblist",pageInfo.getList());
        }

        return "/company/myjob";
    }

    /**
     * 我的简历箱页面
     * @return
     */
    @RequestMapping(value = "jobresume.html")
    public String jobresume(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                   Integer id, Model model, HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        ServerResponse response = iResumeService.getResumeByJobId(pageNum, pageSize, id, account.getCompanyid());
        if(response.isSuccess()){
            PageInfo<ResumeVO> pageInfo = (PageInfo<ResumeVO>)response.getData();
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("resumelist",pageInfo.getList());
        }

        return "company/jobresume";
    }


    /**
     * 实名验证页面
     * @return
     */
    @RequestMapping(value = "verified.html")
    public String verified(HttpSession session,Model model) {
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        ServerResponse response = iCompanyService.getCompanyDetail(account.getCompanyid());
        if(response.isSuccess()){
            Company company = (Company) response.getData();
            model.addAttribute("company",company);
            return "/company/verified";
        }
        return "/company/index";
    }

    /**
     * 编辑信息
     * @return
     */
    @RequestMapping(value = "editinfo.html")
    public String editInfo(HttpSession session,Model model){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = iCompanyService.getCompanyDetail(account.getCompanyid());
        model.addAttribute("financings",iTagPropertyService.getFinancingsList());
        model.addAttribute("compsize",iTagPropertyService.getCompSizeList());
        model.addAttribute("industry",iTagPropertyService.getIndustryList());
        model.addAttribute("city",iTagPropertyService.getCityPropertyList());

        if(serverResponse.isSuccess()){
            Company company = (Company)serverResponse.getData();
            model.addAttribute("company",company);
            return "/company/editinfo";
        }

        return "/company/index";
    }


    /**
     * 更新岗位信息页面
     * @param model
     * @param session
     * @param id
     * @return
     */
    @RequestMapping(value = "updatejob.html")
    public String updateJob(Model model,HttpSession session,Integer id){

        Account account = (Account)session.getAttribute(Const.CURRENT_USER);

        Company company = iAccountService.getCompanyByAccount(account.getId());

        if(company==null){
            model.addAttribute("msg","未有公司信息");
            return "/company/editinfo" ;
        }

        if(company.getChecked()==0){
            model.addAttribute("msg","未通过认证");
            return "/company/verified" ;
        }

        ServerResponse response = iJobOffersServcie.getJob(id,account.getCompanyid());

        if(response.isSuccess()){
            JobOffers job = (JobOffers)response.getData();
            model.addAttribute("job",job);
        }
        model.addAttribute("eduproperty",iTagPropertyService.getEduPropertyList());
        model.addAttribute("cityproperty",iTagPropertyService.getCityPropertyList());
        model.addAttribute("jobtagproperty",iTagPropertyService.getJobTageList());
        model.addAttribute("jobtypeproperty",iTagPropertyService.getJobTypeList());

        return "company/updatejob";

    }




    /**
     * 创建或者更新公司信息
     * @param company
     * @param session
     * @return
     */
    @RequestMapping(value = "saveorupdatecompany.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse saveOrUpdateCompany(Company company, HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        return iAccountService.saveOrUpdateCompany(account.getId(),company);
    }


    /**
     * 判断是否已经认证
     * @param session
     * @return
     */
    @RequestMapping(value = "ispassverified.do" ,method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse isPassVerified(HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        return iAccountService.isPassVerified(account.getId());
    }


    /**
     * 发布信息
     * @param jobOffers
     * @param session
     * @return
     */
    @RequestMapping(value = "addjob.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addJob(JobOffers jobOffers, HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
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
    @ResponseBody
    public ServerResponse updateJob(JobOffers jobOffers,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);

        Company company = iAccountService.getCompanyByAccount(account.getId());
        if(company==null)return ServerResponse.createByErrorMessage("未有公司信息");
        return iJobOffersServcie.updateJob(jobOffers);
    }


    /**
     * 删除发布过的信息
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "deljob.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse delJob(Integer id,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
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
    @ResponseBody
    public ServerResponse jobList(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                  JobOffers jobOffers,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        return iJobOffersServcie.list(pageNum,pageSize,account,jobOffers);
    }


    /**
     * 获取招聘信息的详细信息
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "getjob.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getJob(Integer id,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        return iJobOffersServcie.getJob(id,account.getCompanyid());
    }


    /**
     * 企业获取投递到自己岗位的简历信息
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "getresume.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getResume(Integer id,Integer resumeid,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        return iResumeService.getResumeFromBox(id,resumeid,account.getCompanyid());
    }

    /**
     * 对投递到自己岗位的简历进行邀约面试，通过面试，更改为不合适
     * @param id rds的id
     * @param status 要更改的状态
     * @param msg 邀约面试的信息
     * @param joid 岗位id
     * @param session
     * @return
     */
    @RequestMapping(value = "changeresumestatus.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse changeResumeStatus(@RequestParam("id") Integer id,@RequestParam("joid")Integer joid,@RequestParam("status") Integer status ,@RequestParam(value = "msg",required = false) String msg,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        return iResumeService.changeResumeStatus(id,joid,account.getCompanyid(),status,msg);
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
    @ResponseBody
    public ServerResponse getResumeBox(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                       @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                       Resume resume, HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
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
    @RequestMapping(value = "compverified.do",method = RequestMethod.POST)
    public String compverified(@RequestParam(value = "uploadfile",required = false) MultipartFile file,HttpSession session, HttpServletRequest request,Model model){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);

        Company company = iAccountService.getCompanyByAccount(account.getId());

        if(company==null){
            model.addAttribute("msg","未找到贵公司的信息");
            return "/comp/verified";
        }

        ServerResponse response = this.isPassVerified(session);
        if(response.isSuccess()&&response.getData()==1){
            //已认证，直接返回
            model.addAttribute("msg","已认证，无需再认证");
            return "/comp/verified";
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
        iCompanyService.updateCompanyLicense(company.getId(),backpath);
        //然后返回这个路径
        model.addAttribute("path",backpath);
        return "/company/verified";
    }

    /**
     * 提交实名认证资料(ajax接口，备用)
     * @param file
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "verified.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse verified(@RequestParam(value = "uploadfile",required = false) MultipartFile file,HttpSession session, HttpServletRequest request){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
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

    /**
     * 公司向用户评分
     * @param openid
     * @param credit
     * @param session
     * @return
     */
    @RequestMapping(value = "ratetouser.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse rateToUser(String openid,Double credit,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        return iAccountService.rateToUser(openid,account.getCompanyid(),credit);
    }


    /**
     * 判断用户能否对公司评分
     * @param openid
     * @return
     */
    @RequestMapping(value = "canscoreuser.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse isCompanyHaveAuthorityScoreUser(String openid,HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        boolean canscoreuser = iAccountService.isCompanyHaveAuthorityScoreUser(openid,account.getCompanyid());
        if(canscoreuser){
            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }
}
