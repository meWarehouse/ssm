package com.day02.d1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansApp {


    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("d1.xml");
//        BeansService bs = ac.getBean("beansservice",BeansService.class);
//        bs.save();

        Users u1 = ac.getBean("users", Users.class);
        u1.insert();
        Users u2 = ac.getBean("users", Users.class);
        u2.insert();

        System.out.println("u1 == u2:"+(u1 == u2) );

        Works w1 = ac.getBean("works",Works.class);
        w1.insert();
        Works w2 = ac.getBean("works",Works.class);
        w2.insert();

        System.out.println("w1 == w2:"+(w1 == w2) );

    }

}
