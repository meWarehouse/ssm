package com.kc.mybatis_4.test;

import com.kc.mybatis_4.bean.Employee;
import com.kc.mybatis_4.bean.EmployeeExample;
import com.kc.mybatis_4.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

/**
 * @author wen
 * @create 2020-05-24 21:28
 */
public class Test {

    private static SqlSessionFactory sqlSessionFactory;

    static{

        String config = "mybatis_4/mybatis-config4.xml";
        try {
            InputStream resourceAsStream = getResourceAsStream(config);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void test1(){

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {


            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);


            // xxxExample 就是封装查询条件的  selectByExample 查询所有
            List<Employee> employees = mapper.selectByExample(null);


            //所有带条件的查询都使用 EmployeeExample 进行拼装
            EmployeeExample example = new EmployeeExample();
            //创建一个 Criteria 这个 Criteria 就是拼装查询条件
            EmployeeExample.Criteria criteria = example.createCriteria();
            criteria.andLastNameLike("%t%");
            criteria.andGenderEqualTo("女");

            EmployeeExample.Criteria criteria1 = example.createCriteria();
            criteria1.andEmailLike("%t%");
            example.or(criteria1);

            List<Employee> employees1 = mapper.selectByExample(example);


            for(Employee emp : employees1){
                System.out.println(emp);
            }


        }


    }

}
