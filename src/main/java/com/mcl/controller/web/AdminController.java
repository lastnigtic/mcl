package com.mcl.controller.web;

import com.github.pagehelper.PageInfo;
import com.mcl.common.Const;
import com.mcl.common.ResponseCode;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.*;
import com.mcl.service.IAdminService;
import com.mcl.service.ITagPropertyService;
import com.mcl.service.IUserService;
import com.mcl.util.DateTimeUtil;
import com.mcl.util.PropertiesUtil;
import com.mcl.vo.StatisticsVO;
import com.mcl.vo.TagVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/1/20 0020.
 */
@Controller
@RequestMapping(value = "/admin/")
public class AdminController {


    @Autowired
    private IAdminService iAdminService ;

    @Autowired
    private ITagPropertyService iTagPropertyService ;

    @Autowired
    private IUserService iUserService ;

    /**
     * 公司待审核列表
     * @param model
     * @param pageNum
     * @param pageSize
     * @param company
     * @return
     */
    @RequestMapping(value = "/reviewcomp.html",method = RequestMethod.GET)
    public String reviewcomp(Model model, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,Company company){
        if(company==null)
            company = new Company();

        company.setChecked(0);
        ServerResponse response = iAdminService.getCompanyList(pageNum,pageSize,company);
        if(response.isSuccess()){
            PageInfo<Company> pageInfo = (PageInfo<Company>) response.getData();
            model.addAttribute("pageInfo",pageInfo);
        }
        return "/admin/reviewcomp";
    }


    /**
     * 根据id查询公司详细信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/compinfo")
    public String compinfo(Model model,String id){
        ServerResponse response = iAdminService.getCompInfoById(id);
        if(response.isSuccess()){
            model.addAttribute("comp",response.getData());
        }else {
            model.addAttribute("msg",response.getMsg());
        }
        return "/admin/compinfo";
    }


    /**
     * 岗位待审核列表
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/reviewjob.html",method = RequestMethod.GET)
    public String reviewcomp(Model model, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,JobOffers jobOffers){
        if(jobOffers==null)
            jobOffers = new JobOffers();

        jobOffers.setChecked(0);
        ServerResponse response = iAdminService.getJobList(pageNum,pageSize,jobOffers);
        if(response.isSuccess()){
            model.addAttribute("pageInfo",response.getData());
        }
        return "/admin/reviewjob";
    }

    /**
     * 根据id查询公司详细信息
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/jobinfo")
    public String jobinfo(Model model,Integer id){
        ServerResponse response = iAdminService.getJobById(id);
        if(response.isSuccess()){
            model.addAttribute("job",response.getData());
        }else {
            model.addAttribute("msg",response.getMsg());
        }
        return "/admin/jobinfo";
    }

    /**
     * 公司待审核列表
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/userlist.html",method = RequestMethod.GET)
    public String userlist(Model model, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,UserBaseInfo userBaseInfo){
        ServerResponse response = iAdminService.getUserList(pageNum,pageSize,userBaseInfo);
        if(response.isSuccess()){
            PageInfo<UserBaseInfo> pageInfo = (PageInfo<UserBaseInfo>) response.getData();
            model.addAttribute("pageInfo",pageInfo);
        }
        return "/admin/userlist";
    }


    @RequestMapping(value = "/search")
    public String search(){
        return "/admin/search";
    }

    /**
     * 用户详情页
     * @param model
     * @param openid
     * @return
     */
    @RequestMapping(value = "/userdetail")
    public String userdetail(Model model,String openid){
        ServerResponse response = getUserDetailInfo(openid);
        if(response.isSuccess()){
            model.addAttribute("userinfo",response.getData());
        }else {
            model.addAttribute("msg",response.getMsg());
        }
        return "/admin/userdetail";
    }


    @RequestMapping(value = "/join")
    public String join(){
        return "/admin/join";
    }

    @RequestMapping(value = "/jobdetail")
    public String jobdetail(){
        return "/admin/jobdetail";
    }

    @RequestMapping(value = "/companydetail")
    public String companydetail(){
        return "/admin/companydetail";
    }

    @RequestMapping(value = "/charts")
    public String charts(Model model){
        ServerResponse response = iAdminService.getStatistics();
        if(response.isSuccess()){
            model.addAttribute("data",(StatisticsVO)response.getData());
        }
        return "/admin/charts";
    }

    /**
     * 获取所有公司列表
     * @return
     */
    @RequestMapping(value = "companylist.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getCompanyList(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,Company company){
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_USER);
        Integer role = (Integer)session.getAttribute("Role");
        if(admin == null||role!=1){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iAdminService.getCompanyList(pageNum,pageSize,company);
    }


    /**
     * 获取用户列表
     * @param session
     * @param pageNum
     * @param pageSize
     * @param userBaseInfo
     * @return
     */
    @RequestMapping(value = "userlist.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getUserList(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "10") int pageSize, UserBaseInfo userBaseInfo){
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_USER);
        Integer role = (Integer)session.getAttribute("Role");
        if(admin == null||role!=1){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iAdminService.getUserList(pageNum,pageSize,userBaseInfo);
    }

    /**
     * 获取岗位列表
     * @param session
     * @param pageNum
     * @param pageSize
     * @param jobOffers
     * @return
     */
    @RequestMapping(value = "joblist.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getJobList(HttpSession session, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize",defaultValue = "10") int pageSize, JobOffers jobOffers){
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_USER);
        Integer role = (Integer)session.getAttribute("Role");
        if(admin == null||role!=1){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iAdminService.getJobList(pageNum,pageSize,jobOffers);
    }


    /**
     * 审核公司
     * @param session
     * @param companyid
     * @return
     */
    @RequestMapping(value = "passcompany.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse passCompany(HttpSession session,String companyid,Integer checked){
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_USER);
        Integer role = (Integer)session.getAttribute("Role");
        if(admin == null||role!=1){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iAdminService.passCompany(companyid,checked);
    }

    /**
     * 审核岗位
     * @param session
     * @param id
     * @return
     */
    @RequestMapping(value = "passjob.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse passJob(HttpSession session,Integer id,Integer checked){
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_USER);
        Integer role = (Integer)session.getAttribute("Role");
        if(admin == null||role!=1){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iAdminService.passJob(id,checked);
    }


    /**
     * 获取统计数据
     * @param session
     * @return
     */
    @RequestMapping(value = "getstatistics.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getStatistics(HttpSession session){
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_USER);
        Integer role = (Integer)session.getAttribute("Role");
        if(admin == null||role!=1){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iAdminService.getStatistics();
    }

    /**
     * 意见反馈列表
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "opinionlist.html")
    public String getOpinionList( @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize, Model model){
        List<Opinion> list = iAdminService.getOpinionList(pageNum,pageSize);
        if(list!=null&&list.size()!=0){
            model.addAttribute("oplist",list);
        }
        return "/admin/opinionlist";

    }


    /**
     * 获取不同的type属性
     * @param type
     * @return
     */
    @RequestMapping(value = "gettagepropertiesbytype.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getTagPropertiesByType(String type,@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                 @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){
        return iTagPropertyService.getTagPropertiesByType(pageNum,pageSize,type);
    }

    /**
     * 获取所有的属性type名称
     * @return
     */
    @RequestMapping(value = "getagtype.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getTagType(){
        return iTagPropertyService.getTagType();
    }

    /**
     * 获取所有自定义标签信息
     * @return
     */
    @RequestMapping(value = "getjobtag.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getJobTag(){
        return ServerResponse.createBySuccess(iTagPropertyService.getJobTag());
    }

    /**
     * 获取所有tag信息
     * @return
     */
    @RequestMapping(value = "getalltag.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getAllTag(){
        ServerResponse response = iTagPropertyService.getTagType();
        List<TagVO> tagVOList = new ArrayList<>();
        if(response.isSuccess()){
            List<String> list = (List<String>) response.getData();
            for (String s :list){
                TagVO vo = new TagVO();
                vo.setType(s);
                vo.setList(iTagPropertyService.getTagPropertiesByType(s));
                tagVOList.add(vo);
            }
            return ServerResponse.createBySuccess(tagVOList);
        }
        return ServerResponse.createByErrorMessage("找不到记录");
    }

    /**
     * 微信小程序自定义分类
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "managetag.html")
    public String jobtag( @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize, Model model){
        ServerResponse response = getTagPropertiesByType("jobtag",pageNum,pageSize);
        if(response.isSuccess()){
            model.addAttribute("pageInfo",response.getData());
        }else {
            model.addAttribute("msg",response.getMsg());
        }
        return "/admin/managetag";
    }

    /**
     * 删除标签
     * @param id
     * @return
     */
    @RequestMapping(value = "deltag.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse delTag(Integer id){
        return iTagPropertyService.delTag(id);
    }

    /**
     * 新增标签
     * @param tag
     * @return
     */
    @RequestMapping(value = "addtag.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addTag(TagProperty tag){
        return iTagPropertyService.addTag(tag);
    }

    /**
     * 更改标签
     * @param tag
     * @return
     */
    @RequestMapping(value = "updatetag.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateTag(TagProperty tag){
        return iTagPropertyService.updateTag(tag);
    }


    /**
     *  获取用户详细信息
     * @param openid
     * @return
     */
    @RequestMapping(value = "getuserdetailinfo.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getUserDetailInfo(String openid){
        return iUserService.getUserDetailInfo(openid);
    }


    /**
     * 自定义标签
     * @param files
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "customize.html",method = RequestMethod.POST)
    public String customize(@RequestParam(value = "uploadfile",required = false) MultipartFile[] files, HttpServletRequest request, Model model){
        //存放路径
        String uploadpath = request.getSession().getServletContext().getRealPath(PropertiesUtil.getProperty("ftp.uploadimg.rootpath"))+"/"+ DateTimeUtil.dateToStr(new Date(),"yyyyMMdd");
        //文件原始名
        List<TagProperty> tagPropertyList = new ArrayList<>();
        int i = 1 ;
        for (MultipartFile file:files){
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
            TagProperty tagProperty = new TagProperty();
            tagProperty.setId( Integer.valueOf(request.getParameter("tagid"+i++)));
            tagProperty.setIcon(backpath);
            tagProperty.setIconorder(i);
            tagPropertyList.add(tagProperty);

        }
        iTagPropertyService.updateTagList(tagPropertyList);
        model.addAttribute("backlist",tagPropertyList);
        //然后返回
        ServerResponse response = getTagPropertiesByType("jobtag",1,10);
        if(response.isSuccess()){
            model.addAttribute("pageInfo",response.getData());
        }else {
            model.addAttribute("msg",response.getMsg());
        }
        return "/admin/managetag";
    }

}
