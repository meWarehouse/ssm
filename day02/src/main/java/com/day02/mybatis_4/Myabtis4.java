package com.day02.mybatis_4;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Myabtis4 {
    public static void main(String[] args) throws IOException {

        String config = "mybatis_4/mybatis-config4.xml";

        InputStream is = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            TestMapper mapper = sqlSession.getMapper(TestMapper.class);

            List<Classes> classes = mapper.get1(1);

            System.out.println(classes);


        }


    }
}
