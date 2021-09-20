package com.test.crud.service;

import com.test.crud.bean.Department;
import com.test.crud.dao.DepartmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zero
 * @create 2020-06-01 20:34
 */
@Service
public class DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    public List<Department> getDept(){
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }



}
