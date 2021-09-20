package com.kc.ssm1.service;

import com.kc.ssm1.bean.Employees;
import com.kc.ssm1.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wen
 * @create 2020-05-24 2:16
 */
@Service
public class EmpService {

    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Employees> getEmps(){

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employees> emps = mapper.getEmps();

        return emps;

    }


}
