package com.kc.mybatis_1.mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author wen
 * @create 2020-05-18 18:04
 */
@Controller
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/t1")
    public @ResponseBody User get1(int id){

        User u = new User();
        u.setId(id);
        u.setName("意义");
        u.setGender("女");
        u.setBirthday(new Date());

        return  u;
    }




}
