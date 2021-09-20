package com.kc.mybatis_3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mybatis3 {
    public static void main(String[] args) throws IOException {


        String config = "mybatis_3/mybatis-config3.xml";

        InputStream is = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            TestMapper mapper = sqlSession.getMapper(TestMapper.class);

//            Students students = mapper.get(1);
//            System.out.println("students:"+students);
//
//            System.out.println("----------------------------");
//
//            List<Students> students1 = mapper.searchList();
//            System.out.println(students1);

            Map<String,Object> param = new HashMap<>();
            param.put("name","Jim");

            List<Students> mapper3 = mapper.get3(param);
            System.out.println("mapper3:"+mapper3);

        }

    }
}
