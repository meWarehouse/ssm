package com.kc.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class spring1 {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("com/kc/spring1/beans1.xml");
        Services services = ac.getBean("services", Services.class);
        List<Students> services1 = services.get1();

        System.out.println(services1);

    }
}
