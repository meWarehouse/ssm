package com.kc.d3;

import org.springframework.cglib.proxy.Enhancer;

public class AppTest {
    public static void main(String[] args) {


//        cglib 动态代理可以为任何类生成代理
//        cglib 动态代理生成的代理类是目标类的子类，对外表现相同的功能

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDaoImpl.class);//设置目标类作为代理对象

        enhancer.setCallback(new CglibProxy());//设置代理类

        UserDao p1 = (UserDao)enhancer.create();

        p1.insert();

        System.out.println(p1 instanceof UserDao);
        System.out.println(p1 instanceof UserDaoImpl)   ;

    }
}
