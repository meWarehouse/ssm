package com.day02.spring_2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class Method {


    @Pointcut("execution(* com.day02.spring_2.*Impl.obj*(..))")
    public void aopPointcut(){}


    @Before("aopPointcut()&&args(obj,..)")
    public void beforeAdvice(JoinPoint jp,Object obj){

//        s = "这是一个额外参数";
//        i = 9090900;

        obj = new Date();

        System.out.println("Method's beforeAdvice 前置通知 在方法前执行,调用方法："+jp.getSignature().toLongString()+",参数："+ Arrays.asList(jp.getArgs())+",通知的参数：："+obj);
    }

    @Around("aopPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("Method's aroundAdvice 环绕通知");

        Object proceed = null;

        try {
            proceed = pjp.proceed();

        } catch (Throwable throwable) {
            System.out.println("aroundAdvice's 环绕通知 例外通知");
            throw throwable;
        }finally {
            System.out.println("aroundAdvice's 环绕通知 最终通知");
        }

        System.out.println("aroundAdvice's 环绕通知 后置通知：proceed : "+proceed);

        return proceed;

    }

    @After(value = "aopPointcut()")
    public void afterAdvice(){

        System.out.println("Method's afterAdvice 最终通知");

    }

    @AfterReturning(value = "aopPointcut()",returning = "o")
    public void afterReturn(Object o){

        System.out.println("Method's afterReturn 后置通知 方法正常结束时通知,返回:"+o);

    }

    @AfterThrowing(value = "aopPointcut()",throwing = "t")
    public void afterThrowing(Throwable t){

        System.out.println("Method's afterThrowing 列外通知  执行的方法异常时通知,异常："+t);

    }



}
