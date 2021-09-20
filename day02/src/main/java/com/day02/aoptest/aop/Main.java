package com.day02.aoptest.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("aop/aop1.1.xml");

        Factory factory = ac.getBean("factory", Factory.class);

//        factory.make();
        factory.machining("一个月",9999);


    }
}
