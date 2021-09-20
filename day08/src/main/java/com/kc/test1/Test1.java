package com.kc.test1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {
    public static void main(String[] args) throws IOException {

        String config = "test1/mybatis-config1.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {


            TestMapper mapper = sqlSession.getMapper(TestMapper.class);

//            List<Classes> mapper1 = mapper.get1();

//            List<Students> mapper3 = mapper.get3();
//            Students s = new Students();
//            s.setNo("1001");
//            s.setName("");
//            s.setGender("女");
//            List<Students> mapper4 = mapper.get4(s);
//
//            System.out.println(mapper4);

        }


    }
}
