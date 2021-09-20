package com.smm.controller;

import com.smm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * @author wen
 * @create 2020-05-27 17:10
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private EmpService empService;

    @Autowired
    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    @GetMapping("/loginUI")
    public String loginUI(){
        return "login";
    }

    @RequestMapping("/loginmsg")
    public @ResponseBody  boolean login(@RequestParam("lastname") String lastName, String idcard, HttpSession session){
        System.out.println("lastname:"+lastName+",idcard:"+idcard+",session:"+session);
        boolean empBylastnameAndIdcard = empService.getEmpBylastnameAndIdcard(lastName, idcard, session);
        System.out.println("empBylastnameAndIdcard:"+empBylastnameAndIdcard);

        return empBylastnameAndIdcard;

    }

    @GetMapping("/logout")
    public String logout(HttpSession session){

        ServletContext servletContext = session.getServletContext();

        String contextPath = servletContext.getContextPath();

        System.out.println("contextPath:"+contextPath);

        session.removeAttribute("emp");
        session.invalidate();

        return "redirect:login/loginUI";

    }


}
