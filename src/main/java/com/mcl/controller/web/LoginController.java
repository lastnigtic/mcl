package com.mcl.controller.web;

import com.mcl.common.Const;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.Account;
import com.mcl.pojo.Admin;
import com.mcl.service.IAccountService;
import com.mcl.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/1/27 0027.
 */
@Controller
public class LoginController {

    @Autowired
    private IAccountService iAccountService ;

    @Autowired
    private IAdminService iAdminService;

    /**
     * 取登录页
     * @param session
     * @return
     */
    @RequestMapping(value = "login.html")
    public String loginPage(HttpSession session){
        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account != null){
            return "/company/index";
        }
        return "/login";
    }

    /**
     * 取登录页
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do")
    public String login(String uname, String upass, HttpSession session, Model model){

        Account account = (Account)session.getAttribute(Const.CURRENT_USER);
        if(account != null){
            return "/company/index";
        }

        //执行登录
        ServerResponse<Account> response = iAccountService.login(uname,upass);

        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
            session.setAttribute("Role",Const.Role.ROLE_CUSTOMER);
            return "/company/index";
        }

        model.addAttribute("msg",response.getMsg());

        return "/login";
    }

    @RequestMapping(value = "logout.do")
    public String logout(HttpSession session){
        session.invalidate();
        return "/login";
    }

    @RequestMapping(value = "register.html")
    public String register(){
        return "/register";


    }

    /**
     * 商家注册接口
     * @param account
     * @return
     */
    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(Account account){
        return iAccountService.register(account);
    }



    /**
     * 取登录页
     * @param session
     * @return
     */
    @RequestMapping(value = "adminlogin.html")
    public String adminloginPage(HttpSession session,String id, String pass){
        Admin admin = null ;
        Integer role = (Integer)session.getAttribute("Role");
        if(role!=null&&role==Const.Role.ROLE_ADMIN)
            admin = (Admin)session.getAttribute(Const.CURRENT_USER);
        if(admin != null){
            return "/admin/review";
        }else {
            ServerResponse response = iAdminService.login(id,pass);
            if(response.isSuccess()){
                session.setAttribute(Const.CURRENT_USER,response.getData());
                session.setAttribute("Role",Const.Role.ROLE_ADMIN);
                return "/admin/review";
            }
        }
        return "/adminlogin";
    }

    /**
     * 管理员登录
     * @param id
     * @param pass
     * @param session
     * @return
     */
    @RequestMapping(value = "adminlogin.do",method = RequestMethod.POST)
    public ServerResponse adminlogin(String id, String pass, HttpSession session){
        ServerResponse<Admin> response = iAdminService.login(id,pass);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
            session.setAttribute("Role",Const.Role.ROLE_ADMIN);
        }
        return response;
    }
}
