package com.kc.mybatis_1.mvc3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author wen
 * @create 2020-05-18 21:46
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/loginUI")
    public String loginUI(){
        return "login";
    }

    @PostMapping("/login")
    public String login(String name, String passwd, HttpSession session, Model model){

        session.setAttribute("username",name);

        model.addAttribute("msg","登录成功");

        return "loginResult";
    }
    @GetMapping("/msg")
    public String message(){

        return "userMessage";
    }


}
