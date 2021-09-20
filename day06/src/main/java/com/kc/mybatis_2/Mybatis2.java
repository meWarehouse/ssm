package com.kc.mybatis_2;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis2 {
    public static void main(String[] args) throws IOException {

        String config = "mybatis_2/mybatis-config2.xml";

        InputStream is = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            TestMapper mapper = sqlSession.getMapper(TestMapper.class);

            Classes mapper2 = mapper.get2(1);

            System.out.println(mapper2);

            Students studerts = mapper.get1(1);
            System.out.println("studerts:"+studerts);


            Classes classes = mapper.get3(1);

            System.out.println(classes);

            System.out.println("----------------------------------------------------");

            Classes classes1 = mapper.get4(1);
            System.out.println(classes1);

            System.out.println("---------------------- mybatis的N+1问题 --------------------");

            List<Classes> classesList = mapper.get5();
            System.out.println(classesList);

            List<Classes> mapper6 = mapper.get6();
            System.out.println("mapper6:"+mapper6);


        }


    }
}
