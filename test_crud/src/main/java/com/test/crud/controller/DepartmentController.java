package com.test.crud.controller;

import com.test.crud.bean.Department;
import com.test.crud.bean.Employee;
import com.test.crud.bean.Msg;
import com.test.crud.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zero
 * @create 2020-06-01 20:33
 */
@Controller
@RequestMapping("/dept")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;



    @RequestMapping("/getdept")
    @ResponseBody
    public Msg getDept(){

        List<Department> depts = departmentService.getDept();

        return Msg.success().add("depts",depts);
    }


}
