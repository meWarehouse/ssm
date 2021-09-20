package com.kc.ssm1;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wen
 * @create 2020-05-20 22:24
 */
@Service("userService")
public class UserService {

    private SqlSession sqlSession;

    @Autowired
    public  void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public User get(Integer id){
        return sqlSession.getMapper(UserMapper.class).getUser(id);
    }

    @Transactional
    public int delete(){

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int a = mapper.deleteUser(1);

//        if(0==0){
//            throw new RuntimeException("人为异常--------------");
//        }

        int b = mapper.deleteUser(2);

        return a+b;
    }

    public void add(User user){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.add1(user);
        System.out.println("i:"+i);
    }

}
