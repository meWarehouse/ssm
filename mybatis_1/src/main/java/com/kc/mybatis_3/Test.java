package com.kc.mybatis_3;

import com.kc.mybatis_3.bean.Employee;
import com.kc.mybatis_3.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

/**
 * @author wen
 * @create 2020-05-23 21:18
 */
public class Test {

    private static   SqlSessionFactory sqlSessionFactory;

    static{

        String config = "mybatis_3/mybatis-config3.xml";
        try {
            InputStream resourceAsStream = getResourceAsStream(config);

            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

            sqlSessionFactory = sqlSessionFactoryBuilder.build(resourceAsStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @org.junit.Test
    public void test1(){

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee emp1 = mapper.getEmp(1);
            System.out.println(emp1);

//            Employee emp2 = mapper.getEmp(1);
//            System.out.println(emp2);


        }

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee emp1 = mapper.getEmp(1);
            System.out.println(emp1);


        }

    }


}
