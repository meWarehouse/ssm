package com.kc.aop1;

import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public boolean insert() {
        System.out.println("UserDaoImpl insert");

        return true;
    }

    @Override
    public boolean delete(String name,int age) {
        System.out.println("UserDaoImpl delete");
//        if(1 == 1){
//            throw new RuntimeException("运行时异常");
//        }
        return true;
    }
}
