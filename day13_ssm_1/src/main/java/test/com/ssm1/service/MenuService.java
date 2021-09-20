package test.com.ssm1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.com.ssm1.bean.Menu;
import test.com.ssm1.dao.MenuMapper;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-11 13:29
 */
@Service
public class MenuService {

    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Menu> getAllOneMenu() {
        return sqlSession.getMapper(MenuMapper.class).selectAll();
    }

    public boolean addmenue(Menu menu) {
        return sqlSession.getMapper(MenuMapper.class).addItem(menu) == 1;
    }

    public List<Menu> menuListPage(Map<String, Object> param) {
        return sqlSession.getMapper(MenuMapper.class).selectPageList(param);
    }

    public int getCount() {
        return sqlSession.getMapper(MenuMapper.class).getCount();
    }

    public Menu getMenu(Integer id) {
        return sqlSession.getMapper(MenuMapper.class).getMenu(id);
    }

    public boolean delMenu(Integer id) {
        return sqlSession.getMapper(MenuMapper.class).delMenu(id) == 1;
    }


}
