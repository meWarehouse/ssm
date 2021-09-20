package com.day02.mybatis_2;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {

        String config = "mybatis_2/mybatis-config_2.xml";

        InputStream is = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//            System.out.println("mappwe:"+mapper);

//            UserDetails userDetails = mapper.get2(1);
//            System.out.println("user:"+userDetails);
//            User user = mapper.get1(1);
//            System.out.println("user:"+user);

//            User u = new User("熊大",9,"男");
//            int insert = mapper.insert(u);
//            System.out.println("insert:"+insert);

//            int delete = mapper.delete(3);

//            User u = new User();
//            u.setName("大大的");
//            u.setAge(11);
//            u.setGender("男");
//            u.setId(1);
//
//            int update = mapper.update(u);

//            int count = mapper.getCount();

//            List<UserDetails> forList = mapper.getForList();
//
//            for(UserDetails u : forList){
//                System.out.println(u);
//            }

//            Map<String, Object> map  = mapper.getMap(1);
//
//            Set<Map.Entry<String, Object>> entries = map.entrySet();
//            for(Map.Entry<String, Object> entry : entries){
//                System.out.println(entry.getKey() + "---" + entry.getValue());
//            }

//            System.out.println("de--:"+forList);

            List<User> users = mapper.getUser("100");
            System.out.println(users);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
