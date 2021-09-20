package com.day02.spring_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

       ApplicationContext ac = new ClassPathXmlApplicationContext("spring_3/spring_3.xml");

//        UserDao userDAO = ac.getBean("userDAO", UserDao.class);
//////
////        User user = new User("小明",10,90);
//////
//////       // List list = userDAO.insert1(user);
//////
//////        //boolean a = userDAO.delete(1);
//////
//////        User a = userDAO.get(2);
//////
//////        System.out.println("----:"+a);
////
////
//////        boolean insert = userDAO.insert(user);
////
//////        List list = userDAO.insert1(user);
////
////        boolean list = userDAO.delete(3);
////
////
////        System.out.println("boolean:----:" + list);


        UserService userService = ac.getBean("userService", UserService.class);


        userService.test();


    }
}
