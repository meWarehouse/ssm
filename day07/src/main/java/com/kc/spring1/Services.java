package com.kc.spring1;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("services")
public class Services {

    private SqlSession sqlSession;


    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Transactional
    public List<Students> get1(){

        TestMapper mapper = sqlSession.getMapper(TestMapper.class);

        List<Students> studentsList = mapper.get1();



//        if(0 == 0){
//            throw new RuntimeException("人为异常");
//        }

        System.out.println("------------------------------------------------------------");

        ClassMapper mapper1 = sqlSession.getMapper(ClassMapper.class);
        List<Classes> classesList = mapper1.get1();

        System.out.println("studentsList:"+studentsList);
        System.out.println("classesList:"+classesList);


        return null;

    }

}
