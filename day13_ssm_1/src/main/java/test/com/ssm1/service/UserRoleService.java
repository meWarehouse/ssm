package test.com.ssm1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.com.ssm1.bean.UserRole;
import test.com.ssm1.dao.UserRoleMapper;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-10 21:07
 */
@Service
public class UserRoleService {

    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<UserRole> userRoleMsg(Map<String, Object> param) {
        return sqlSession.getMapper(UserRoleMapper.class).selectAll(param);
    }

    public int getCount() {
        return sqlSession.getMapper(UserRoleMapper.class).getCount();
    }

    public UserRole getUserRole(Integer id) {
        return sqlSession.getMapper(UserRoleMapper.class).getUserRole(id);
    }
}
