package com.day02.aoptest.aop;

//实现被代理的接口
//调用被代理类的同名方法
//class myProxy{
//
//    public static Object getProxyInstance(Object obj){//参数被代理类
//
//        myInvocationHandler handler = new myInvocationHandler(obj);
//
//        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
//    }
//
//}
//
//class myInvocationHandler implements InvocationHandler{
//
//    private Object obj;
//
//    public myInvocationHandler(Object obj) {
//        this.obj = obj;
//    }
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//        Advice advice = new Advice();
//
//        advice.beforeAdvice();
//
//        Object invokeValue = method.invoke(obj, args);
//
//        advice.afterAdvice();
//
//        return invokeValue;
//    }
//}
//
//
//public class ProxyTest {
//    public static void main(String[] args) {
//
//        //获取被代理类
//        ClothFactoryImpl clothFactory = new ClothFactoryImpl();
//
//        Factory factory = (Factory) myProxy.getProxyInstance(clothFactory);
//
//        factory.make();
//        factory.machining("一个月",9999);
//
//
//    }
//}
