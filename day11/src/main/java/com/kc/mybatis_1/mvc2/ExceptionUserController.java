package com.kc.mybatis_1.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wen
 * @create 2020-05-18 21:02
 */
@Controller
@RequestMapping("/ex/user")
public class ExceptionUserController {


    @GetMapping("/ex1")
    public String ex1() throws UserException {

        if(0 == 0){
            throw new UserException("一个人为异常 ExceptionUserController ex/user/ex1  。。。。 ");
        }

        return "";

    }

}
