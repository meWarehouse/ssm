package test.com.ssm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import test.com.ssm1.bean.Menu;
import test.com.ssm1.bean.User;
import test.com.ssm1.bean.UserRole;
import test.com.ssm1.service.RoleMenuService;
import test.com.ssm1.service.UserRoleService;
import test.com.ssm1.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author zero
 * @create 2020-06-03 17:44
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private UserService userService;
    private UserRoleService userRoleService;
    private RoleMenuService roleMenuService;


    @Autowired
    public void setRoleMenuService(RoleMenuService roleMenuService) {
        this.roleMenuService = roleMenuService;
    }

    @Autowired
    public void setUserRoleService(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //登入
    @GetMapping("/loginUI")
    public String loginUI() {
        return "login";
    }

    @RequestMapping("/loginMsg")
    @ResponseBody
    public boolean login(String userName, String userPassword, HttpSession session) {

        System.out.println("userName:" + userName + ",userPassword:" + userPassword);

        Map<String, Object> param = new HashMap<>();
        param.put("name", userName);
        param.put("password", userPassword);

        User u = userService.getUserForUsernameAndUserpassword(param);
        if (u == null) {
            return false;
        } else {
            session.setAttribute("u", u);

            UserRole userRole = userRoleService.getUserRole(u.getId());
            System.out.println("角色为："+userRole.getRname());

            List<Menu> userMenus = roleMenuService.getFromUser(userRole.getRid());
            for (Menu menu:userMenus){
                System.out.println(menu);
            }

            System.out.println("00-------------------------------------------------------------------------------");

            Map<Menu,List<Menu>> result = new HashMap<>();
            List<Menu> child = new ArrayList<>();
            for(int i = 0;i < userMenus.size();i++){
                if (userMenus.get(i).getPid() == 0){
                    for(int j = 0;j < userMenus.size();j++){

                        if(userMenus.get(j).getPid() == userMenus.get(i).getId()){

                            child.add(userMenus.get(j));
                        }
                    }
                    result.put(userMenus.get(i),child);
                    
                    child.clear();
                }

            }

            Set<Map.Entry<Menu, List<Menu>>> entries = result.entrySet();
            for(Map.Entry<Menu, List<Menu>> entry : entries){
                System.out.println("+++++++:"+entry);
                System.out.println(entry.getKey()+";;;;;;;"+Arrays.asList(entry.getValue()));
            }


            session.setAttribute("userMenus",result);

            return true;
        }

    }

    //查看详细资料
    @GetMapping("/details")
    public String getDetailsUI(Model model, HttpSession session) {

        User u = (User) session.getAttribute("u");

        if (u != null) {
            model.addAttribute("user", u);
            return "detailsUI";
        } else {
            return "login";
        }

    }


    //退出
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("u");
        session.invalidate();
        return "login";
    }

    //修改密码
    @GetMapping("/modifyPasswordUI")
    public String modifyPasswordUI(HttpSession session) {
        if (session.getAttribute("u") != null) {

            return "modifyPasswordUI";
        } else {
            return "login";
        }
    }

    @PostMapping("/modifyPassword")
    @ResponseBody
    public boolean modifyPassword(String oldPassword, String newPassword, HttpSession session) {

        System.out.println("oldPassword:" + oldPassword + ",newPassword:" + newPassword);

        User u = (User) session.getAttribute("u");

        if (!oldPassword.trim().equals(u.getUserPassword())) {
            return false;
        } else {
            Map<String, Object> param = new HashMap<>();
            param.put("password", newPassword);
            param.put("id", u.getId());

            userService.modifyPassword(param);

            return true;
        }


    }

    //修改头像
    @GetMapping("/modifyHeadUI")
    public String modifyHeadUI(HttpSession session) {
        if (session.getAttribute("u") != null) {
            return "modifyHeadUI";
        } else {
            return "login";
        }
    }

    @PostMapping("/modifyHead")
    public String modifyHead(MultipartFile icon, HttpServletRequest request) throws IOException {
        System.out.println("servletContextPath:"+request.getServletPath());
//        System.out.println("getRealPath:"+request.getServletContext().getRealPath("/static"));//D:\developer_tools\apache-tomcat-9.0.35-windows-x64\apache-tomcat-9.0.35\webapps\day13_ssm_1\static\images

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("u");

//        D:\developer_tools\apache-tomcat-9.0.35-windows-x64\apache-tomcat-9.0.35\webapps\day13_ssm_1\statics\images
//        D:\developer_tools\apache-tomcat-9.0.35-windows-x64\apache-tomcat-9.0.35\webapps\day13_ssm_1\static\images\1e8368da-b1e7-4b74-9f48-862057fadf4f.jpg
        String path = request.getServletContext().getRealPath("/statics/images");
        System.out.println("存放地址："+path);

        //文件名后缀
        String suffix = icon.getOriginalFilename().substring(icon.getOriginalFilename().lastIndexOf("."));
        System.out.println("suffix:"+suffix);

        String s = UUID.randomUUID().toString()+suffix;
        System.out.println("拼装文件名："+s);
        //将文件保存到 \static\images
        icon.transferTo(new File(path+"/"+s));

        Map<String,Object> param = new HashMap<>();
        param.put("id",u.getId());
        param.put("icon","\\statics\\images\\"+s);



        //将路径保存到数据库
        userService.updateIcon(param);

        return "redirect:/login/loginUI";

    }


}
