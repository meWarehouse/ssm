package com.test.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.crud.bean.Employee;
import com.test.crud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-02 0:07
 */
@Controller
@RequestMapping("/layuiController")
public class LayuiEmployeeController {

    @Resource
    EmployeeService employeeService;


    @GetMapping("/layuiUI")
    public String layuiUI(){
        return "layuiUI";
    }

    @RequestMapping("/getPageMsg")
    @ResponseBody
    public Map<String,Object> getPageMsg(Integer page, Integer limit){

//        //使用分页插件分页
        PageHelper.startPage(page,limit);
        //紧跟分页数据
        List<Employee> allEmployee = employeeService.getAllEmployee();

        PageInfo<Employee> pageInfo = new PageInfo<>(allEmployee, 5);

        Map<String,Object> result = new HashMap<>();

        result.put("msg","");
        result.put("code",0);
        result.put("date",pageInfo.getList());
        result.put("count",pageInfo.getTotal());

        return result;

    }

    @RequestMapping("/getPage")
    @ResponseBody
    public Map<String,Object> getPage(Integer page,Integer limit){

//        System.out.println("page:"+page+",limit:"+limit);

        List<Employee> employeeListPage = employeeService.getPage(page,limit);
//        System.out.println(employeeListPage);

        int count = employeeService.getCount();

        //封装结果 code":0,"msg":"","count":1000,"data":[]
        Map<String,Object> result = new HashMap<>();

        result.put("code",0);
        result.put("msg","");
        result.put("count",count);
        result.put("data",employeeListPage);

        return result;

    }

    /**
     * 单个删除
     * @param empId
     * @return
     */
    @PostMapping("/deleteById")
    @ResponseBody
   public boolean deleteByempId(Integer empId){
        System.out.println("empid:"+empId);
        boolean b = employeeService.deleteByempId(empId);
        return b;
   }

   //编辑
    @RequestMapping("/editUI")
    public String editUI(Integer empId, Model model){
        System.out.println(empId);
        employeeService.getEmployee(empId);
        model.addAttribute("emp",employeeService.getEmployee(empId));
        return "edit";
    }

















}
