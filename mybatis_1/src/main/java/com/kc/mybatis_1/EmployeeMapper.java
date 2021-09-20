package com.kc.mybatis_1;

import com.kc.mybatis_1.bean.Department;
import com.kc.mybatis_1.bean.Employee;

import java.util.List;

/**
 * @author wen
 * @create 2020-05-20 16:03
 */
public interface EmployeeMapper {

    Employee getEmployee(int id);

    Employee getEmployeeAndDept(int id);

    Employee getEmployeeAndDeptA(int id);

    List<Department> getDept();


}
