package com.kc.mybatis_1;

import com.kc.mybatis_1.bean.Department;

import java.util.List;

/**
 * @author wen
 * @create 2020-05-20 17:00
 */

public interface DeparmentMapper {

    Department getDept(int id);

    List<Department> getDeptAndEmp(int id);


}
