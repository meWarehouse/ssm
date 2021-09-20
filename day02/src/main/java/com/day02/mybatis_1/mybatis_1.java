package com.day02.mybatis_1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mybatis_1 {
    public static void main(String[] args) throws IOException {

        String config = "mybatis_1/mybatis-config_1.xml";

        InputStream is = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = builder.build(is);



        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = mapper.get(1);

            System.out.println("-----:"+user);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
