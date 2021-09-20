package com.day02.d2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("d2.xml");
//        Users u = (Users) ac.getBean("sf");
//        u.eat();

        Manger m = ac.getBean("m", Manger.class);
        m.print();

        System.out.println();

    }
}
