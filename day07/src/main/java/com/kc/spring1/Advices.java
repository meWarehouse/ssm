package com.kc.spring1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advices {

    @Pointcut("execution(* com.kc.spring1.Services.get1())")
    public void aopPointcut(){}


    @Before("aopPointcut()")
    public void beforeAdvice(){
        System.out.println("this is beforeAdvice..............");
    }


}
