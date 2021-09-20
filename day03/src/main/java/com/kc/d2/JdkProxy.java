package com.kc.d2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {

    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method 目标方法
     * @param args 目标对象的方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");

        Object r = method.invoke(target, args);//反射调用目标对象的方法

        System.out.println("代理后");

        return r;
    }
}
