package com.day02.spring_2;

import org.springframework.stereotype.Component;

@Component("obj")
public class ObjImpl implements Obj {

    private String str1;

    public void setStr(String str1) {
        this.str1 = str1;
    }

    @Override
    public String objTest1() {

//        if( 0 == 0){
//            throw new RuntimeException("人为异常");
//        }

        return "this is ObjImpl's objTest1 ";
    }

    @Override
    public void objTest2(String str) {

//        if( 0 == 0){
//            throw new RuntimeException("人为异常");
//        }

        System.out.println("str1: "+str1+", this is ObjImpl's objTest2 :" + str);
    }
}
