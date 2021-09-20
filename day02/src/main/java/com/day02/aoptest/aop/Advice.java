package com.day02.aoptest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component("advice")
@Aspect
public class Advice {

    @Pointcut("execution(* com.day02.aoptest.aop.*Impl.*(..))")
    public void daoPointcut(){}

     /*
                        before 前置通知
                        after 最终通知，不管方法是否正常结束，都会得到执行
                        around 环绕通知，包含其他通知，可以控制目标方法的执行，可以修改目标方法的返回值
                        after-returning 后置通知，当方法正常结束时会得到执行，如果方法抛出异常就不会得到执行
                        after-throwing 例外通知，当方法抛出异常时会得到执行
      */

    @Before("daoPointcut()&&args(obj,..)")
    public void beforeAdvice(JoinPoint pjp,Object obj){
        obj = new Date();
        System.out.println("前置通知    cloth factory 准备材料  "+",执行方法："+pjp.getSignature().toLongString()+",参数："+ Arrays.asList(pjp.getArgs())+",时间："+obj);

    }

    @Around("daoPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知  cloth make-->make-->make...  ");

        Object r = null;
        try {
            r = pjp.proceed();
        } catch (Throwable throwable) {
            System.out.println("环绕通知 的 例外通知   cloth make-->make-->make...  throw   ");
            throw throwable;
        }finally {
            System.out.println("环绕通知 的 最终通知 cloth make-->make-->make... 完成 ");
        }

        System.out.println("环绕通知 的后置通知 cloth make-->make-->make... finish。。。。。  ");

        return r;

    }


    @AfterThrowing(pointcut = "daoPointcut()",throwing = "e")
    public void afterThrowAdvice(JoinPoint jp,Throwable e){
        System.out.println("例外通知   cloth make throw 。。。"+",异常："+e);
    }


    @AfterReturning(pointcut = "daoPointcut()",returning = "r")
    public void afterReturningAdvice(JoinPoint jp,Object r){

        System.out.println("后置通知   cloth make finish。。。 "+",返回值："+r);
    }

    @After("daoPointcut()")
    public void afterAdvice(){

        System.out.println("最终通知  cloth factory 出货  ");

    }




}
