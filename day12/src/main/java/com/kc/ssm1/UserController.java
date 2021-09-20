package com.kc.ssm1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wen
 * @create 2020-05-20 22:26
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/t1")
    public String test(Integer id){

        System.out.println("UserController test .............. ");

        return "testView";

    }

    @GetMapping("/t2")
    public String getUserById(Integer id, Model model){

        System.out.println("id:"+id);

        User user = userService.get(id);

        System.out.println("user:"+user);

        model.addAttribute("user",user);

        return "userMessage";
    }

    @GetMapping("/t3")
    public String deleteUser(){

        int delete = userService.delete();

        System.out.println("delete:"+delete);

        return "userMessage";
    }

    @RequestMapping("/add1")
    public String addUI(){
        return "addUI";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response){

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");

        System.out.println("name:"+name+",age:"+age+",gender:"+gender);

        User user = new User(name,Integer.parseInt(age),gender);

        userService.add(user);

        return "add";
    }


}
