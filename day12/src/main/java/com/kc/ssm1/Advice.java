package com.kc.ssm1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wen
 * @create 2020-05-21 10:19
 */
@Component
@Aspect
public class Advice {

    @Pointcut("execution(* com.kc.ssm1.UserService.*(..))")
    public void aopPointcut(){};

    @Before("aopPointcut()")
    public void before(){

        System.out.println("前置通知。。。。。。。。。。。。。。。。。。。。");
    }

}
