package com.kc.ssm1.controller;

import com.kc.ssm1.bean.Employees;
import com.kc.ssm1.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author wen
 * @create 2020-05-24 2:13
 */
@Controller
public class EmpController {


    private EmpService empService;

    @Autowired
    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    @RequestMapping("/getemps")
    public String getEmps(Map<String,Object> map){

        List<Employees> emps = empService.getEmps();

        map.put("allEmps", emps);

        return "list";

    }


}
