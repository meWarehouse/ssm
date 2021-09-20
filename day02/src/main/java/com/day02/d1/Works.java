package com.day02.d1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component("works")
public class Works implements Beans {
    public Works() {
        System.out.println("works 构造器");
    }

    @Override
    public void insert() {
        System.out.println("Works insert...");
    }
}
