package com.day02.d1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component("users")
public class Users implements Beans {
    public Users() {
        System.out.println("User 构造器");
    }

    @Override
    public void insert() {
        System.out.println("User insert 。。。。。");
    }
}
