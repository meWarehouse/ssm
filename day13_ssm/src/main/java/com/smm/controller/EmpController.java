package com.smm.controller;

import com.smm.ben.Employee;
import com.smm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wen
 * @create 2020-05-25 0:34
 */
@Controller
@RequestMapping("/emp")
public class EmpController {

    private EmpService empService;

    @Autowired
    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }


    @GetMapping("/test")
    public String test(Map<String, Object> map) {
        List<Employee> test = empService.getTest();
        map.put("emps", test);
        return "hello";
    }

    /* 添加 Employee */

    @RequestMapping("/addui")
    public String addUI(){
        return "addui";
    }

    @PostMapping("/add")
    public @ResponseBody boolean add(Employee employee){
        System.out.println("emp:-------------"+employee);

        return empService.add(employee);
    }

    /* 分页显示用户列表 */
    @GetMapping("/employeeListPagesUI")
    public String employeeListPagesUI(){
        return "list";
    }

    /**
     *
     * @param page 表示第几页
     * @param limit 表示要几条数据
     * @return
     */
    @RequestMapping("/employeeListPages")
    public @ResponseBody Map<String,Object> employeeListPages(Integer page,Integer limit){

        //封装查询条件
        Map<String,Object> param = new HashMap<>();
        param.put("start",(page-1)*limit);
        param.put("limit",limit);

        List<Employee> employeeListPage = empService.getEmployeeListPage(param);

        System.out.println(employeeListPage);

        int count = empService.getCount();
        System.out.println("count--------------:"+count);

        //封装结果 code":0,"msg":"","count":1000,"data":[]
        Map<String,Object> result = new HashMap<>();

        result.put("code",0);
        result.put("msg","");
        result.put("count",count);
        result.put("data",employeeListPage);

        return result;
    }

    /* delete 操作 */
    @RequestMapping("/delete")
    public @ResponseBody boolean delete(Integer id){
//        System.out.println(" delete  id :  :" + id);
        boolean flag = empService.delete(id);

        return flag;
    }

    /* updateUI 操作 */
    @GetMapping("/updateUI")
    public String updateUI(Integer id, Model model){

        Employee employeeById = empService.getEmployeeById(id);

        model.addAttribute("employee",employeeById);

        return "employeeUpdate";
    }

    @PostMapping("/update")
    public @ResponseBody boolean update(Employee employee){
        System.out.println("update-----------------:"+employee);
        boolean flag = empService.update(employee);

        return flag;
    }




}
