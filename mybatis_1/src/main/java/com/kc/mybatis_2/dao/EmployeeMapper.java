package com.kc.mybatis_2.dao;

import com.kc.mybatis_2.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wen
 * @create 2020-05-20 20:40
 */
public interface EmployeeMapper {

    Employee getEmp(int id);

    Employee getDetail(int id);

    List<Employee> getEmployeeByConditionIf(Employee employee);
    List<Employee> getEmployeeByConditionW(Employee employee);
    List<Employee> getEmployeeByConditionS(Employee employee);
    List<Employee> getEmployeeByConditionC(Employee employee);

    public void updateEmp(Employee employee);
    public void updateEmp1(Employee employee);

    public List<Employee> getByForeach(@Param("ids") List<Integer> ids);

//    public void addEmps(@Param("emps") List<Employee> emps);

    public void addEmps(@Param("emps") List<Employee> emps);

    public List<Employee> getEmpsTestInnerParameter(Employee employee);




}
