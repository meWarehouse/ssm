package com.kc.d3;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {



    /**
     *
     * @param target 目标对象
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("前置通知");

        Object r = methodProxy.invokeSuper(target,objects);//调用目标对象的方法

        System.out.println("后置通知");
        return r;
    }
}
