package com.mcl.controller.interceptor;

import com.mcl.common.Const;
import com.mcl.pojo.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员登录的拦截器
 * @author yz
 */
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Integer role = (Integer)httpServletRequest.getSession().getAttribute("Role");
        /// /判断是否已经登录
        if(role!=null&&Const.Role.ROLE_ADMIN==role){
            Admin admin = (Admin)httpServletRequest.getSession().getAttribute(Const.CURRENT_USER);
            if(admin != null){
                return true;
            }
        }else{

        }
        httpServletResponse.sendRedirect("/adminlogin.html");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
