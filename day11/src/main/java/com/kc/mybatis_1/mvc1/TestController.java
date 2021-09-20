package com.kc.mybatis_1.mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wen
 * @create 2020-05-18 12:10
 */

@Controller
@RequestMapping("/user")
public class TestController {


    @RequestMapping("/t1")      //该注解可以接受get请求也可以接受post请求
    public ModelAndView test1(String name, String gender, Integer age) {

        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("gender:"+gender);



        ModelAndView mv = new ModelAndView();

        mv.addObject("name", name);
        mv.addObject("age", age);
        mv.addObject("gender", gender);

        mv.setViewName("/WEB-INF/jsp/hello.jsp");

        return mv;

    }

//    @RequestMapping("/t2")
//    @RequestMapping(value = "/t2",method = RequestMethod.GET)
//    @RequestMapping(value = "/t2",method = RequestMethod.POST)
//    @RequestMapping(value = {"/t2","/t3"},method = {RequestMethod.GET,RequestMethod.DELETE})
//    @GetMapping("/t2")
    @PostMapping("/t2")
    public ModelAndView test2(int id){

        User u = new User();
        u.setId(id);
        u.setName("里啊");
        u.setGender("男");

        ModelAndView mv = new ModelAndView();
        mv.addObject("username",u.getName());

        mv.setViewName("/WEB-INF/jsp/userDetails.jsp");

        return mv;
    }

    @RequestMapping("/t3")
    public String test3(User user){

        return "userDetails";

    }





}
