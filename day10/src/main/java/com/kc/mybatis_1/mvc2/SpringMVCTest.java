 package com.kc.mybatis_1.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wen
 * @create 2020-05-19 0:42
 */
@Controller
@RequestMapping("/springmvc")
public class SpringMVCTest {

    private static final String SUCCESS = "success";



    @RequestMapping(value = "/testRestParam")
    public String testRestParam(@RequestParam(value = "username") String nu,@RequestParam(value = "age") int age){
        System.out.println("username:"+nu);
        System.out.println("age:"+ age);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testRestDeletePut(@PathVariable Integer id){

        System.out.println("testRest Put : " + id);

        return SUCCESS;
    }


    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id){

        System.out.println("testRest DELETE : " + id);

        return SUCCESS;
    }


    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testRest(){

        System.out.println("testRest POST : ");

        return SUCCESS;
    }


    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testRest(@PathVariable Integer id){

        System.out.println("testRest GET : " + id);

        return SUCCESS;
    }



}
