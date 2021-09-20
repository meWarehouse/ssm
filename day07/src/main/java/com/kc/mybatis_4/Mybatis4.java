package com.kc.mybatis_4;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mybatis4 {
    public static void main(String[] args) throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis_4/mybatis-config4.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            TestMapper mapper = sqlSession.getMapper(TestMapper.class);

            Map<String, Object> mapper2 = mapper.get2();
            System.out.println("mapper2:"+mapper2);
            Set<Map.Entry<String, Object>> entries = mapper2.entrySet();
            for(Map.Entry<String, Object> entry : entries){
                System.out.println(entry.getKey()+":"+entry.getValue());
            }

            System.out.println("----------------------------------------------");

            List<Map<String, Object>> mapper3 = mapper.get3();
            System.out.println(mapper3);

            System.out.println("----------------------------------------------");
//            Classes c = new Classes();
//            c.setName("六班");
//
//            int insert = mapper.insert(c);
//
//            System.out.println(insert);
//            System.out.println(c.getCid());

            Map<String,Object> map = new HashMap<>();
            map.put("name","一班");
            List<Classes> mapper4 = mapper.get4(map);
            System.out.println("mapper4:"+mapper4);

            Classes mapper5 = mapper.get5(1);
            System.out.println("mapper5:"+mapper5);

        }


    }
}
