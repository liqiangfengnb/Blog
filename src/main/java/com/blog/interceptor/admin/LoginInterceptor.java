package com.blog.interceptor.admin;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截成功");
        if(request.getSession().getAttribute("user") == null){
//            System.out.println("密码");
            response.sendRedirect("/cn/admin");
            return false;
        }
//        System.out.println("通过");
        return true;
    }
}           
