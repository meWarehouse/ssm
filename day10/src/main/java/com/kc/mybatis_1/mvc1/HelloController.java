package com.kc.mybatis_1.mvc1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

//@Controller 注解表示该类是一个控制器
//@RestController
@Controller
public class HelloController {

    //@RequestMapping("/hello") 指示此方法绑定 url:/hello
    @RequestMapping("/hello")
    public ModelAndView hello(){

        System.out.println("hello..............");

        //模型视图
        ModelAndView mv = new ModelAndView();
        //将键值对放入模型中
        mv.addObject("name","小猪佩奇");
        //视图路径
        mv.setViewName("WEB-INF/jsp/hello.jsp");
        // spring 会将 model 中的数据放入到 view 中，然后将 view 渲染并返回给浏览器
        return mv;

    }

    @RequestMapping("/form")
    public ModelAndView form(){
        return new ModelAndView("WEB-INF/jsp/form.jsp");
    }

    //八种基本类型，八种包装类型，字符串

    @RequestMapping("/t1")
    public void test1(String name,String gender,int age){//参数只需要和 input 中的 name 相同即可 与顺序无关
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("gender:"+gender);
    }

    @RequestMapping("/t2")
    public void test2(String name,String gender,Integer age){
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("gender:"+gender);
    }


    //@RequestParam
    @RequestMapping("/t3")
    public void test3(@RequestParam("name")String username, String gender, Integer age){
        //如果请求参数与参数不同使用 @RequestParam     @RequestParam("name") String username 取请求参数中的 name 赋值给 username
        System.out.println("name:"+username);
        System.out.println("age:"+age);
        System.out.println("gender:"+gender);
    }


    //对象参数绑定
    @RequestMapping("/t4")
    public void test4(User user){
        System.out.println(user);
    }

   // 数组参数绑定  使用数组接收多个同名参数

    @RequestMapping("/t5")
    public void test5(String[] interests){
        System.out.println(Arrays.toString(interests));
    }


    //请求路径参数 将请求路径中的参数 id 赋值给参数 aid
    @RequestMapping("/t6/{id}")
    public void test6(@PathVariable("id")Integer aid){
        System.out.println("id:"+aid);
    }


    @RequestMapping("/t7")
    public void test7(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {

        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("age"));
        System.out.println(request.getParameter("gender"));

        System.out.println("session:"+session);

        response.getWriter().write("hello spring mvc");


    }





}
