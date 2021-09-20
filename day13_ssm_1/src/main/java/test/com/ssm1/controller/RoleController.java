package test.com.ssm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.com.ssm1.bean.Role;
import test.com.ssm1.service.RoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-10 13:29
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/forwardPages/{path}")
    public String forwardPages(@PathVariable("path") String path, Model model){
        List<Role> roles = roleService.allRolez();
        model.addAttribute("roles",roles);
        return path;
    }

    @RequestMapping("/addRole")
    @ResponseBody
    public boolean addRole(Role role){
        return  roleService.addRole(role);
    }

    @RequestMapping("/roleList")
    @ResponseBody
    public Map<String,Object> roleList(Integer page,Integer limit){
        Map<String,Object> param = new HashMap<>();
        param.put("start",(page-1)*limit);
        param.put("limit",limit);

        List<Role> roles = roleService.roleListPage(param);
        int count = roleService.getCount();

        //{"code":0,"msg":"","count":1000,"data":[{"id
        Map<String,Object> res = new HashMap<>();

        res.put("code",0);
        res.put("msg","");
        res.put("count",count);
        res.put("data",roles);

        return res;
    }

    @RequestMapping("/updateRole")
    @ResponseBody
    public boolean updateRole(Role role){
        return roleService.updateRole(role);
    }




}
