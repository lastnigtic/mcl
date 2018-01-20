package com.mcl.controller.web;

import com.mcl.common.Const;
import com.mcl.common.ResponseCode;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.*;
import com.mcl.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/1/20 0020.
 */
@RestController
@RequestMapping(value = "/admin/")
public class AdminController {


    @Autowired
    private IAdminService iAdminService ;


    /**
     * 管理员登录
     * @param id
     * @param pass
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do",method = RequestMethod.POST)
    public ServerResponse login(String id, String pass, HttpSession session){
        ServerResponse<Admin> response = iAdminService.login(id,pass);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
            session.setAttribute("Role",Const.Role.ROLE_ADMIN);
        }
        return response;
    }

    /**
     * 获取所有公司列表
     * @return
     */
    @RequestMapping(value = "companylist.do",method = RequestMethod.POST)
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
    public ServerResponse getStatistics(HttpSession session){
        Admin admin = (Admin)session.getAttribute(Const.CURRENT_USER);
        Integer role = (Integer)session.getAttribute("Role");
        if(admin == null||role!=1){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iAdminService.getStatistics();
    }
}
