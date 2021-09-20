package com.day02.mybatis_3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        String config = "mybatis_2/mybatis-config_3.xml";

        InputStream is = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);

        try (SqlSession sqlSession = sessionFactory.openSession(true)) {

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//
//            Details details = mapper.get(1001);
//
//            System.out.println("details:"+details);

            List<User> user = mapper.getUser(1);
            System.out.println(user);


        }


    }
}
