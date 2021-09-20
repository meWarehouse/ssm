package com.kc.aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 *
 *  连接点（joinpoint）：程序的执行流程中的某一个点，通常是一个方法执行的某一个时机
 *  通知（advice）：要加入到连接点中的某一段代码
 *  切入点（pointcut）：一系列的连接点的集合
 *  切面（aspect）：切入点+通知
 *  织入（weaving）：将通知植入目标之中。
 *
 */


public class App {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("aop2.xml");

        UserDao userDao = ac.getBean("userDao", UserDao.class);

        User user = new User();

//        user.setAge(23);
//        user.setName("小明");

//        userDao.delete(3);

//        user.setName("四四");
//        user.setAge(4);
//        user.setId(4);
//
//        boolean flag = userDao.update(user);
//
//        System.out.println("flag:"+flag);

//        User user1 = userDao.get(5);
//        Map<String, Object> stringObjectMap = userDao.queryForMap(5);

//        int count = userDao.getCount();

        List<User> users = userDao.select();

//        List<Map<String, Object>> maps = userDao.queryForList();


        System.out.println("users:"+users);


    }
}
