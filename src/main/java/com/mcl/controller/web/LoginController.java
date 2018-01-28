package com.mcl.controller.web;

import com.mcl.common.Const;
import com.mcl.common.ServerResponse;
import com.mcl.pojo.Account;
import com.mcl.service.IAccountService;
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

    /**
     * 取登录页
     * @param session
     * @return
     */
    @RequestMapping(value = "login.html")
    public String loginPage(String uname, String upass, HttpSession session, Model model){
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
}
