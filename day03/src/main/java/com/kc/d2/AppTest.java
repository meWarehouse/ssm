package com.kc.d2;

import java.lang.reflect.Proxy;

public class AppTest {
    public static void main(String[] args) {

        /*UserDao target = new UserDaoImpl();

        UserDaoProxy proxy = new UserDaoProxy();
        proxy.setTarget(target);
        proxy.insert();


       ClientDao clientDaoTarget = new ClientDaoImpl();

        ClientDaoProxy proxy1 = new ClientDaoProxy();
        proxy1.setClientDao(clientDaoTarget);
        proxy1.insert();*/


        UserDao target1 = new UserDaoImpl();
        ClientDao target2 = new ClientDaoImpl();

        /*

           jdk 动态代理：只能为实现接口的代理类生成代理 代理类与目标类没有关系

        public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
                               throws IllegalArgumentException
                loader - 定义代理类的类加载器
                interfaces - 代理类要实现的接口列表
                h - 指派方法调用的调用处理程序


            target1.getClass().getClassLoader() 加载器  类需执行，需要被jvm类加载器加载到内存中
            target1.getClass().getInterfaces()==UserDao  确定此对象所表示的类或接口实现的接口
            获取 target1 的代理对象
         */
        UserDao p1 = (UserDao) Proxy.newProxyInstance(target1.getClass().getClassLoader(), target1.getClass().getInterfaces(), new JdkProxy(target1));
        boolean b = p1.insert();//调用代理类的方法
        System.out.println(b);

        System.out.println(p1.delete());

        ClientDao c  = (ClientDao)Proxy.newProxyInstance(target2.getClass().getClassLoader(),target2.getClass().getInterfaces(),new JdkProxy(target2));
        System.out.println(c.insert());

        System.out.println("--------------------------------------");

        //代理类与目标类没有关系
        System.out.println(c instanceof ClientDao);
        System.out.println(c instanceof ClientDaoImpl);



    }
}
