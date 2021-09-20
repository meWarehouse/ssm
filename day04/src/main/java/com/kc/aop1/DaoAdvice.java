package com.kc.aop1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Aspect // 表示切面注解
public class DaoAdvice {

    //切入点
    @Pointcut("execution(* com.kc.aop1.*Impl.*(..))")
    public void daoPointcut(){}

    //目标执行前   jp 当前连接点
    @Before("daoPointcut()")//引用daoPointcut切入点
    public void beforeAdvice(JoinPoint jp) {
//        jp.getSignature() 连接点签名   jp.getArgs() 获取方法参数
        System.out.println("before 前置通知:"+jp.getSignature().toLongString()+"，方法参数："+ Arrays.toString(jp.getArgs()));
    }


    //目标执行后
    @After("daoPointcut()")
    public void afterAdvice(JoinPoint jp) {
        System.out.println("after 最终通知，不管方法是否正常结束，都会得到执行:"+jp.getSignature().toLongString());
    }

    //执行前一次 执行后一次  在环绕通知中可以使用ProceedingJoinPoint，其他通知中使用JoinPoint。
    @Around("daoPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知，包含其他通知，可以控制目标方法的执行，可以修改目标方法的返回值");

        Object p = null;

        try {
             p = pjp.proceed();//调用目标方法  结果是目标方法的返回值(ClientDaoImpl的insert()方法的返回值)

        } catch (Throwable e) {
            System.out.println("around  throwing 列外通知:"+pjp.getSignature().toLongString());//列外通知
            throw e;
        }finally {
            System.out.println("around 最终通知:"+pjp.getSignature().toLongString());//最终通知
        }

        System.out.println("around 正常后置通知:"+pjp.getSignature().toLongString());//后置通知
        return p;
    }
/*

    //正常执行时 执行后
    // r 用于保存目标方法的返回值
    @AfterReturning("daoPointcut()")
    public void afterReturningAdvice(@org.jetbrains.annotations.NotNull JoinPoint jp, Object r){
        System.out.println("after-returning 后置通知，当方法正常结束时会得到执行，如果方法抛出异常就不会得到执行:"+jp.getSignature().toLongString()+",目标方法的返回值："+r);
    }

    //异常执行时 执行后
    // e 保存目标方法的异常
    @AfterThrowing(value = "daoPointcut()")
    public void afterThrowingAdvice(JoinPoint jp,Throwable e){
        System.out.println("after-throwing 例外通知，当方法抛出异常时会得到执行:"+jp.getSignature().toLongString()+"，异常信息："+e.getMessage());
    }
 */



    /*
                before 前置通知
                after 最终通知，不管方法是否正常结束，都会得到执行
                around 环绕通知，包含其他通知，可以控制目标方法的执行，可以修改目标方法的返回值
                after-returning 后置通知，当方法正常结束时会得到执行，如果方法抛出异常就不会得到执行
                after-throwing 例外通知，当方法抛出异常时会得到执行
     */

}
