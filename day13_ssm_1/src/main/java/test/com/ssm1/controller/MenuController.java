package test.com.ssm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.com.ssm1.bean.Menu;
import test.com.ssm1.service.MenuService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-11 13:29
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    private MenuService menuService;

    @Autowired
    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/pageForwards/{path}")
    public String pageForwards(@PathVariable("path") String path, Model model){
        List<Menu> oneMenus = menuService.getAllOneMenu();
        model.addAttribute("oneMenus",oneMenus);
        return path;
    }

    @RequestMapping("/addmenue")
    @ResponseBody
    public boolean addmenue(Menu menu){
//        System.out.println(menu+",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");

        return menuService.addmenue(menu);
    }

    @RequestMapping("/menuList")
    @ResponseBody
    public Map<String,Object> menuList(Integer page, Integer limit,Integer pid){
        System.out.println("page:"+page+",limit:"+limit+",pid:"+pid+"...................................");
        Map<String,Object> param = new HashMap<>();
        param.put("start",(page-1)*limit);
        param.put("limit",limit);
        param.put("pid",pid);

        List<Menu> menus = menuService.menuListPage(param);
        int count = menuService.getCount();

        //{"code":0,"msg":"","count":1000,"data":[{"id
        Map<String,Object> res = new HashMap<>();

        res.put("code",0);
        res.put("msg","");
        res.put("count",count);
        res.put("data",menus);

        return res;
    }

    @PostMapping("/getMenu")
    @ResponseBody
    public Menu getMenu(Integer id){
        return menuService.getMenu(id);
    }

    @RequestMapping("/updateMenu")
    @ResponseBody
    public boolean updateMenu(Menu menu){
        System.out.println(menu+",:::::::::::::::::::::::::::::::");
        return false;
    }

    @RequestMapping("/del")
    @ResponseBody
    public boolean del(Integer id){
        return menuService.delMenu(id);
    }
















}
