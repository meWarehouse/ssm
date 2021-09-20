package com.smm;

import com.smm.ben.Employee;
import com.smm.service.EmpService;

/**
 * @author wen
 * @create 2020-05-25 21:08
 */
public class Test {
    public static void main(String[] args) {
        EmpService empService = new EmpService();
        Employee employee = new Employee();
        employee.setLastName("咦咦咦");
        employee.setAge(12);
        employee.setGender("男");
        employee.setEmail("at@yiyii.com");
        employee.setDid(1);

        boolean add = empService.add(employee);

        System.out.println(add);
    }
}
