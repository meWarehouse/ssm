package com.test.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.crud.bean.Employee;
import com.test.crud.bean.Msg;
import com.test.crud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zero
 * @create 2020-05-31 23:22
 */
@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Resource
    EmployeeService employeeService;

    @RequestMapping("/check")
    @ResponseBody
    public Msg checkEmpNmae(@RequestParam("empName") String empName){

        System.out.println("----------------:"+empName);

        boolean flag = employeeService.checkEmpNmae(empName);

        if(flag){
            return Msg.success().add("msg","用户名可用");
        }else{
            return Msg.fail().add("msg","用户名不可用");
        }
    }


    @RequestMapping("/saveemp")
    @ResponseBody
    public Msg saveEmp(Employee employee){
        employeeService.saveEmp(employee);
        return Msg.success();
    }

    @RequestMapping("/bootstrapUI")
    public String bootstrapUI(){

        return "bootstrapUI";

    }

    @RequestMapping("/bootstrapMag")
    @ResponseBody
    public Msg bootstrapMsg(@RequestParam(value = "pn",defaultValue = "1") Integer pn){

        System.out.println("-----------------pn:"+pn);

        PageHelper.startPage(pn,10);
        List<Employee> employees = employeeService.getAllEmployee();

        PageInfo<Employee> employeePageInfo = new PageInfo<>(employees, 5);

        return Msg.success().add("pageInfo",employeePageInfo);

    }


}
