package com.smm.controller;

import com.smm.ben.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author wen
 * @create 2020-05-28 0:24
 */
@Controller
@RequestMapping("/idcard")
public class PasswordModelController {

    @GetMapping("/idcardUI")
    public String idcardUI(){
        return "idcard";
    }

    @PostMapping("/oldIdcard")
    public @ResponseBody boolean verify(String oldIdcard, HttpSession session){
        Employee emp = (Employee) session.getAttribute("emp");
        String idcard = emp.getIdcard();

        return idcard.equals(oldIdcard.trim());
    }

}
