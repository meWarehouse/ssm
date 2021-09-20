package com.kc.jdbc_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_1_1.xml");

        UserDAO userDao = ac.getBean("userDao", UserDAO.class);

        User u = new User();

        UserService userService = ac.getBean("userService", UserService.class);

        userService.remove();


    }
}
