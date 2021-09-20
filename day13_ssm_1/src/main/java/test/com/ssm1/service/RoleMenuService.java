package test.com.ssm1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.com.ssm1.bean.Menu;
import test.com.ssm1.dao.RoleMenuMapper;

import java.util.List;

/**
 * @author zero
 * @create 2020-06-11 18:15
 */
@Service
public class RoleMenuService {

    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    public List<Menu> getRoleMenuTree() {
        return sqlSession.getMapper(RoleMenuMapper.class).getMenuTree();
    }

    @Transactional
    public boolean saveRoleTreeData(String menuIds, Integer roleId) {

        String[] split = menuIds.split(",");
        RoleMenuMapper mapper = sqlSession.getMapper(RoleMenuMapper.class);

        //先删除 roleId 的所有
        mapper.deleteRoleId(roleId);
        for (String menuId : split){
            mapper.insert(Integer.parseInt(menuId),roleId);
        }

        return true;
    }

    public List<Menu> getFromUser(Integer rid) {
        return sqlSession.getMapper(RoleMenuMapper.class).getFromUser(rid);
    }
}
