package com.nice.filter;

import com.nice.model.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nice
 */
public class WebIntercrptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        System.out.println("前拦截器处理完毕");
        User user = (User) request.getSession().getAttribute("USER");
        if (user!=null) {
            return true;
        }else {
            response.sendRedirect("/user/login");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        long endTime=System.currentTimeMillis();
        System.out.println("后拦截器处理完毕,本次处理时间为" + (endTime - startTime));
        request.setAttribute("handleTime",endTime+startTime);
    }
}
