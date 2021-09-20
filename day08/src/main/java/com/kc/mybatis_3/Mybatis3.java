package com.kc.mybatis_3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class Mybatis3 {
    public static void main(String[] args) throws IOException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("com/kc/mybatis_3/beans.xml");
        Service service = ac.getBean("service", Service.class);

        List<Students> service3 = service.get3();

        System.out.println("service3:"+service3);

//
//        String config = "com/kc/mybatis_3/mybatis-config3.xml";
//
//        InputStream is = Resources.getResourceAsStream(config);
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
//
//        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
//
//            TestMapper mapper = sqlSession.getMapper(TestMapper.class);
//
////            Students students = mapper.get(1);
////            System.out.println("students:"+students);
////
////            System.out.println("----------------------------");
////
////            List<Students> students1 = mapper.searchList();
////            System.out.println(students1);
//
//            Map<String,Object> param = new HashMap<>();
//            param.put("name","Jim");
//
//            List<Students> mapper3 = mapper.get3(param);
//            System.out.println("mapper3:"+mapper3);
//
//        }

    }
}
