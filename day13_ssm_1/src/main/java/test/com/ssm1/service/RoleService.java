package test.com.ssm1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.com.ssm1.bean.Role;
import test.com.ssm1.dao.RoleMapper;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-10 13:29
 */
@Service
public class RoleService {

    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    public boolean addRole(Role role) {
        return sqlSession.getMapper(RoleMapper.class).add(role) == 1;
    }

    public List<Role> roleListPage(Map<String, Object> param) {
        return sqlSession.getMapper(RoleMapper.class).selectAll(param);
    }

    public int getCount() {
        return sqlSession.getMapper(RoleMapper.class).selectCount();
    }

    public boolean updateRole(Role role) {
        return sqlSession.getMapper(RoleMapper.class).update(role) == 1;
    }

    public List<Role> allRolez() {
        return sqlSession.getMapper(RoleMapper.class).allRolez();
    }
}
