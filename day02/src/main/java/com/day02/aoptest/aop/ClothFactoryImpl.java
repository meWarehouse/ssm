package com.day02.aoptest.aop;

import org.springframework.stereotype.Component;

@Component("factory")
public class ClothFactoryImpl implements Factory {
    @Override
    public boolean make() throws RuntimeException {
        System.out.println("ClothFactory make cloth...制作 cloth ...");

//        if(1 ==1 ){
//            throw new RuntimeException("这是一个人为异常");
//        }

        return true;
    }

    @Override
    public boolean machining(String time,double money) throws RuntimeException {
        System.out.println("ClothFactory machining cloth...加工 cloth ...");

        if(1 ==1 ){
            throw new RuntimeException("这是一个人为异常");
        }

        return true;
    }
}
