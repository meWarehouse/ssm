package com.kc.mybatis_1.mvc3;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author wen
 * @create 2020-05-18 21:40
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    public LoginHandlerInterceptor() {
    }


    //在 action 处理请求之前执行此方法
    // 返回 true 表示放行，后序的拦截器和 action方法
    // 返回 false 表示在此方法中完成请求的处理，后序的action和拦截器不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("------------ preHandle  -----------");

        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");

        if(username == null || username.equals("")){
            response.sendRedirect("/day11/user/loginUI");
            return false;
        }else {

            return true;
        }

    }

    //在 action 处理请求之后，但是视图还没有被渲染的时候(action 方法已经执行完毕) 执行此方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //在视图渲染完毕并返回给浏览器之后，执行次方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
