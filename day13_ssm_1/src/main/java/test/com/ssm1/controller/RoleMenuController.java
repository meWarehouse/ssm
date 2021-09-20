package test.com.ssm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.com.ssm1.bean.Menu;
import test.com.ssm1.service.MenuService;
import test.com.ssm1.service.RoleMenuService;

import java.util.List;

/**
 * @author zero
 * @create 2020-06-11 18:10
 */
@Component
@RequestMapping("/roleMenu")
public class RoleMenuController {

    private MenuService menuService;
    private RoleMenuService roleMenuService;

    @Autowired
    public void setRoleMenuService(RoleMenuService roleMenuService) {
        this.roleMenuService = roleMenuService;
    }

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menuTreeUI/{id}")
    public String menuTreeUI(@PathVariable("id") Integer id, Model model){
//        System.out.println("----------------------------------------:"+id);
        model.addAttribute("roleId",id);
        return "menuTree";
    }

    @RequestMapping("/getTree")
    @ResponseBody
    public List<Menu> getTree(){
        return roleMenuService.getRoleMenuTree();
    }

    @RequestMapping("/saveRoleTreeData")
    @ResponseBody
    public boolean saveRoleTreeData(String menuIds,Integer roleId){
        System.out.println("menuIds:"+menuIds+",roleId:"+roleId);
        return roleMenuService.saveRoleTreeData(menuIds,roleId);
    }


}
