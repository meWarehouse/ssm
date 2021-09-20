package com.kc.mybatis_1.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wen
 * @create 2020-05-18 20:58
 */
@Controller
@RequestMapping("/ex")
public class ExceptionController {

    @GetMapping("/ex1")
    public String ex1() throws ClickException {

        if(0 == 0){
            throw new ClickException("一个人为异常  ex1  。。。。 ");
        }

        return "";

    }
    @GetMapping("/ex2")
    public String ex2() throws ClickException {

        if(0 == 0){
            throw new ClickException("一个人为异常  ex2  。。。。 ");
        }

        return "";

    }



}
