package com.day02.spring_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_2/spring_2.xml");

        Obj obj = ac.getBean("obj", Obj.class);

//        System.out.println("与被代理类的关系："+(obj instanceof ObjImpl));

        String s = obj.objTest1();
        System.out.println("obj.objTest1():"+s);

        System.out.println("-----------------------------------------------------");

        obj.objTest2("100");



    }
}
