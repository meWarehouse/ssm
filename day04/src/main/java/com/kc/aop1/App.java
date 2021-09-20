package com.kc.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*

   连接点（joinpoint）：程序的执行流程中的某一个点，通常是一个方法执行的某一个时机
   通知（advice）：要加入到连接点中的某一段代码
   切入点（pointcut）：一系列的连接点的集合
   切面（aspect）：切入点+通知
   织入（weaving）：将通知植入目标之中。
*/



public class App {
    public static void main(String[] args) {

//        ApplicationContext ac = new ClassPathXmlApplicationContext("aop1.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop1_1.xml");

        //这里获取的是代理对象
        UserDao userDao = ac.getBean("userDao", UserDao.class);
//        boolean insert = userDao.insert();
        boolean delete = userDao.delete("小米",23);

        System.out.println(delete);

//        ClientDao clientDao = ac.getBean("clientDao", ClientDao.class);
//        clientDao.insert();

    }
}
