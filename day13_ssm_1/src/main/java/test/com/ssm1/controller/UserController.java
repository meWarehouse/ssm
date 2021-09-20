package test.com.ssm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.com.ssm1.bean.User;
import test.com.ssm1.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-02 23:44
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //增
    @GetMapping("/addUI")
    public String addUI(){
        return "add";
    }

    @PostMapping("/addUser")
    @ResponseBody
    public boolean addUser(User user){
        System.out.println("--------------------------user"+user);
        return userService.add(user);
    }

    //校验
    @PostMapping("/check")
    @ResponseBody
    public boolean checkUserName(String userName){

        boolean b = userService.checkUserName(userName);
        return b;
    }


    //删
    @PostMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteById(@PathVariable("id") Integer id){
//        System.out.println("---------------id : " + id);
        return userService.deleteById(id);
    }

    //改
    @GetMapping("/updateUI")
    public String updateUI(Integer id,Model model){
        User u = userService.selectById(id);
        model.addAttribute("user",u);
        return "update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean update(User user){
        System.out.println("---00------------:"+user);
        return userService.updateById(user);
    }




    /* 用户列表 */
    @RequestMapping("listUI")
    public String listUI(){
        return "list";
    }

    @RequestMapping("listDatas")
    @ResponseBody
    public Map<String,Object> list(Integer page,Integer limit){
        Map<String,Integer> params = new HashMap<>();
        params.put("start",(page-1)*limit);
        params.put("limit",limit);
        List<User> userList = userService.listPage(params);

        System.out.println(userList);

        int count = userService.getCount();

        //{"code":0,"msg":"","count":1000,"data":[{"i
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("msg","");
        result.put("count",count);
        result.put("data",userList);

        return result;
    }

    @GetMapping("/test")
    @ResponseBody
    public void test(Model model){
        List<User> users = userService.test();
//        System.out.println(users);
        model.addAttribute("users",users);
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }





}
