package com.kc.mybatis_2.dao;

import com.kc.mybatis_2.bean.Department;

/**
 * @author wen
 * @create 2020-05-20 20:39
 */
public interface DeparmentMapper {

    Department getDept(int id);

    //一对多
    Department getDeptDetials(int id);


}
