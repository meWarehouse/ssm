package com.kc.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

interface Human{
    String  sing();
    void eat(String food);
}

//被代理类
class StartHuman implements Human{

    @Override
    public String sing() {
        return "StartHuman sing";
    }

    @Override
    public void eat(String food) {
        System.out.println("StartHuman eat " + food);
    }
}


class Method{

    public void method1(){
        System.out.println("-----------------通用方法一-----------------");
    }
    public void method2(){
        System.out.println("-----------------通用方法二-----------------");
    }

}


class ProxyFactory{

    public static Object getProxyInstance(Object obj){

        MyInvocationHandler hanlder = new MyInvocationHandler(obj);


        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),hanlder);
    }

}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws Throwable {

        Method m = new Method();
        m.method1();

        Object invokeValue = method.invoke(obj, args);

        m.method2();

        return invokeValue;
    }
}




public class Test {
    public static void main(String[] args) {

        StartHuman startHuman = new StartHuman();

        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(startHuman);

        String sing = proxyInstance.sing();
        System.out.println(sing);


    }
}
