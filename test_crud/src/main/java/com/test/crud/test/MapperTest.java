package com.test.crud.test;

import com.test.crud.bean.Employee;
import com.test.crud.dao.DepartmentMapper;
import com.test.crud.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zero
 * @create 2020-05-31 22:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/springContext/root-context.xml")
public class MapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void testCrud(){

        System.out.println(employeeMapper);
        System.out.println(departmentMapper);

//        List<Employee> employees = employeeMapper.selectByExampleWidthDept(null);
//        for(Employee employee : employees){
//            System.out.println(employee);
//        }

        Employee employee = employeeMapper.selectByPrimaryKeyWidthDept(2);

        System.out.println(employee);

    }

}
