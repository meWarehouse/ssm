package com.smm.dao;

import com.smm.ben.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author wen
 * @create 2020-05-25 0:22
 */
@Component
public interface EmpMappper {

    List<Employee> getTest();

    int add(Employee employee);

    List<Employee> emploeeListPage(Map<String,Object> map);
    int getCount();

    int deleteById(Integer id);
    Employee getById(Integer id);


    Employee getEmpBylastnameAndIdcard(String lastName, String idcard);

    Employee getEmpByIdcard(String idcard);

    int update(Employee employee);

}
