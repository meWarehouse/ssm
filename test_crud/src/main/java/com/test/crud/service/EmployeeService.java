package com.test.crud.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.crud.bean.Employee;
import com.test.crud.bean.EmployeeExample;
import com.test.crud.dao.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zero
 * @create 2020-05-31 23:22
 */
@Service
public class EmployeeService {

    @Resource
    EmployeeMapper employeeMapper;


    public List<Employee> getAllEmployee() {

        List<Employee> employees = employeeMapper.selectByExampleWidthDept(null);

        return employees;

    }


    public void saveEmp(Employee employee) {

        employeeMapper.insertSelective(employee);


    }

    public boolean checkEmpNmae(String deptName) {

        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();

        EmployeeExample.Criteria criteria1 = criteria.andEmpNameEqualTo(deptName);

        long l = employeeMapper.countByExample(employeeExample);

        return l == 0;

    }

    public List<Employee> getPage(Integer page,Integer limit){


       PageHelper.startPage(page, limit);
//       List<Employee> employees = employeeMapper.selectByExample(null);
        List<Employee> employees = employeeMapper.selectByExampleWidthDept(null);

        PageInfo<Employee> pageInfo = new PageInfo<>(employees);

        List<Employee> list = pageInfo.getList();

//        System.out.println("--------------------");
//        System.out.println(list);
//        System.out.println("---------------------");

        return list;

    }

    public int getCount(){
        return (int) employeeMapper.countByExample(null);
    }


    public boolean deleteByempId(Integer empId) {

        int i = employeeMapper.deleteByPrimaryKey(empId);
//
//        EmployeeExample employeeExample = new EmployeeExample();
//        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
//        criteria.andEmpIdEqualTo(empId);

//        int i1 = employeeMapper.deleteByExample(employeeExample);
        //-2147482646
        //-2147482646
        //-2147482646

//        System.out.println("删除："+i);
//        System.out.println("删除1:" + i1);

        return true;

    }

    public Employee getEmployee(Integer empId){
        Employee employee = employeeMapper.selectByPrimaryKeyWidthDept(empId);
        System.out.println("employee:"+employee);
        return employee;
    }
}
