package com.kc.mybatis_1.mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wen
 * @create 2020-05-18 12:49
 */
@Controller
@RequestMapping("/returnVal")
public class ReturnValController {

    @GetMapping("/get1")
    public String get1(int id,Model model) {
        System.out.println("get1.................");
        User u = new User();
        u.setId(id);
        u.setName("里啊");
        u.setGender("男");

        model.addAttribute("user", u);

        return "userDetails";

    }

    @GetMapping("/get2")
    public String get2() {

        System.out.println("get2............");

        return "forward:get3";//spring 的 转发只能转发给一个 action

    }

    @GetMapping("/get3")
    public String get3() {

        System.out.println("get3............");

        return "userDetails";

    }

//    @GetMapping("/get4")
//    PostMapping
//    DeleteMapping
//    PutMapping

    @PostMapping
    @GetMapping
    @PutMapping
    @DeleteMapping
    @PatchMapping
    @RequestMapping

    public String get4() {

        System.out.println("get4............");

        return "redirect:get3";//请求转发

    }

    @GetMapping("/get5")
    public void get5(HttpServletRequest request, HttpServletResponse response) throws IOException {

      response.setCharacterEncoding("UTF-8");

      response.setContentType("text/html");

        PrintWriter pw = response.getWriter();
        pw.write("hello spring mvc");

    }

    @GetMapping("/package")
    public String getPackage(){
        return "test1";
    }

    @PostMapping("/get6")
    public String get6(User user){

        return "userDetails";

    }



}
