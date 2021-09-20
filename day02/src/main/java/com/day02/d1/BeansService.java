package com.day02.d1;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("beansservice")
public class BeansService {

    @Resource(name = "users")
    private Beans beans;

    public void save(){
        beans.insert();
    }


}
