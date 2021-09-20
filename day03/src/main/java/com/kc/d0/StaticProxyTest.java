package com.kc.d0;


/**
 * 静态代理
 * <p>
 * 特点：代理类和被代理类在编译期间就已经确定
 */

interface ClothFactory {
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//被代理类
class NickClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nick 工厂生产一批运动服");
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {


        //创建被代理类
        ClothFactory nike = new NickClothFactory();
        //创建代理类
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();


    }
}
