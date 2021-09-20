package com.kc.d1;

public class UserDaoProxy implements UserDao{

    /*

        静态代理：程序在运行前，代理类就已经存在
        动态代理：程序运行前，代理类不存在，程序运行时，代理类生成
            jdk 动态代理：只能为实现接口的代理类生成代理
            jdk 动态代理生成的代理类和目标实现相同的接口，对外表现相同的功能 生成的代理类与目标类没有关系

            cglib 动态代理可以为任何类生成代理
            cglib 动态代理生成的代理类是目标类的子类，对外表现相同的功能


            cglib 动态代理的效率高于 jdk 动态代理





     */

    //代理目标
    private UserDao target;

    public void setTarget(UserDao target) {
        this.target = target;
    }

    @Override
    public boolean insert() {

        before();

        target.insert();//实际代理的任务由目标执行

        after();

        return false;
    }

    private void before(){
        System.out.println("代理前通知");
    }
    private void after(){
        System.out.println("代理后通知");
    }

}
