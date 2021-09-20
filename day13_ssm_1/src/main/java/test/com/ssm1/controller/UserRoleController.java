package test.com.ssm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.com.ssm1.bean.UserRole;
import test.com.ssm1.service.RoleService;
import test.com.ssm1.service.UserRoleService;
import test.com.ssm1.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-10 20:52
 */
@Controller
@RequestMapping("userRole")
public class UserRoleController {

    private UserRoleService userRoleService;
    private RoleService roleService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @RequestMapping("/userRoleMsg")
    @ResponseBody
    public Map<String,Object> userRoleMsg(Integer page,Integer limit){

        Map<String,Object> param = new HashMap<>();
        param.put("start",(page-1)*limit);
        param.put("limit",limit);

        List<UserRole> roles = userRoleService.userRoleMsg(param);
        int count = userRoleService.getCount();

        //{"code":0,"msg":"","count":1000,"data":[{"id
        Map<String,Object> res = new HashMap<>();

        res.put("code",0);
        res.put("msg","");
        res.put("count",count);
        res.put("data",roles);

        return res;

    }

    @RequestMapping("/updateUserRid")
    @ResponseBody
    public boolean updateUserRid(Integer uid,Integer rid){
//        System.out.println("uid:"+uid+",rid:"+rid+",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");

        return userService.updateRid(uid,rid);

    }





}
