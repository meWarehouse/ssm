package com.kc.d0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil{
    public void method1(){
        System.out.println("====================通用方法一====================");

    }

    public void method2(){
        System.out.println("====================通用方法二====================");
    }
}

/**
 * 想要实现动态代理，需要解决的问题
 *      问题一：如何根据加载到内存中的被代理类，动态创建一个代理类及其对象
 *      问题二：当通过代理类的对象调用方法 a 时，如何动态的去调用被代理类的同名方法
 *
 */
class ProxyFactory{
    //调用此方法，返回一个代理类对象，解决问题一
    public static Object getProxyInstance(Object obj){//被代理类对象

        MyInvocationHandler handler = new MyInvocationHandler(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }

}

class MyInvocationHandler implements InvocationHandler{
    
    private Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    //当通过代理类对象，调用方法 a 时，就会自动的调用如下方法：invoke()
    //将被代理类要执行的方法 a 的功能声明在 invoke() 方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();

        util.method1();

        //method:即为代理类对象调用的方法，此方法也就作为被代理类对象要调用的方法
        Object returnValue = method.invoke(obj, args);

        util.method2();

        //上述方法的返回值就作为当前类中的invoke()的返回值。
        return returnValue;
    }
}



public class ProxyTest {
    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        //当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");
        System.out.println("*****************************");

        NickClothFactory nickClothFactory = new NickClothFactory();

        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nickClothFactory);

        proxyClothFactory.produceCloth();

    }
}
