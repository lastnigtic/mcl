package com.mcl.controller.web;

import com.mcl.common.Const;
import com.mcl.common.ResponseCode;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.*;
import com.mcl.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/1/20 0020.
 */
@Controller
@RequestMapping(value = "/admin/")
public class AdminController {


    @Autowired
    private IAdminService iAdminService ;

    @RequestMapping(value = "/review")
    public String review(){

        return "/admin/review";
    }

    @RequestMapping(value = "/search")
    public String search(){
        return "/admin/search";
    }

    @RequestMapping(value = "/userdetail")
    public String userdetail(){
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
    public String charts(){
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

    @RequestMapping(value = "opinionlist.html",method = RequestMethod.GET)
    public String getOpinionList( @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "10") int pageSize, Model model){
        List<Opinion> list = iAdminService.getOpinionList(pageNum,pageSize);
        if(list!=null&&list.size()!=0){
            model.addAttribute("oplist",list);
        }
        return "/admin/opinionlist";

    }
}
