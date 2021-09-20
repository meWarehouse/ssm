package com.day02.d2;

public class StaticFactory {
//    private static Users user = new Users();

    public static Users createInstance(){
        return new Users();
    }

}
