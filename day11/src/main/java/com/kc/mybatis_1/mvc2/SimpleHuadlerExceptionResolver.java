package com.kc.mybatis_1.mvc2;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wen
 * @create 2020-05-18 21:05
 */
@Component
public class SimpleHuadlerExceptionResolver implements HandlerExceptionResolver {

    //统一处理异常的方法，任何组件中抛出的异常都会交给这个方法来处理
    // request 当前请求   response 当前响应  handler 当正在处理的方法   ex 异常对象
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        System.out.println("SimpleHuadlerExceptionResolver resolveException");

        if(ex instanceof UserException){

            ModelAndView mv =  new ModelAndView("userException");
            mv.addObject("msg",ex.getMessage());

            return  mv;

        }else if(ex instanceof  ClickException){

            ModelAndView mv =  new ModelAndView("clickException");
            mv.addObject("msg",ex.getMessage());

            return  mv;

        }else{

            ModelAndView mv =  new ModelAndView("otherException");
            mv.addObject("msg","未知错误");

            return  mv;

        }



    }
}
