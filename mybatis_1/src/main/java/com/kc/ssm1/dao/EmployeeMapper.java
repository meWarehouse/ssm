package com.kc.ssm1.dao;

import com.kc.ssm1.bean.Employees;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wen
 * @create 2020-05-24 1:50
 */
@Component
public interface EmployeeMapper {

    List<Employees> getEmps();

}
