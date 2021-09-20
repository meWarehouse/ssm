package com.kc.mybatis_3;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("service")
public class Service {

    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Students> get3(){


        TestMapper mapper = sqlSession.getMapper(TestMapper.class);

        Map<String,Object> param = new HashMap<>();
        param.put("name","Jim");
        List<Students> mapper3 = mapper.get3(param);



        return mapper3;

    }


}
