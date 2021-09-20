package test.com.ssm1.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.com.ssm1.bean.Category;
import test.com.ssm1.dao.CategoryMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-04 16:14
 */
@Service
public class CategoryService {

    private SqlSession sqlSession;

    @Autowired
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Category> getCategoryLevelAll(Map<String, Object> param) {
        return sqlSession.getMapper(CategoryMapper.class).getCategoryLevelAll(param);

    }

    public int getCategoryLevelCount(Map<String, Object> param) {
        return sqlSession.getMapper(CategoryMapper.class).getCategoryLevelCount(param);
    }

    public List<Category> selectLevel(int i) {

        return sqlSession.getMapper(CategoryMapper.class).selectLevel(i);

    }

    public int getMaxOrder(Map<String, Object> param) {

        return sqlSession.getMapper(CategoryMapper.class).getMaxOrder(param);

    }

    public boolean addCategory(Category category) {
        return sqlSession.getMapper(CategoryMapper.class).addCategory(category) == 1;
    }

    public boolean delete(Integer id) {
        return sqlSession.getMapper(CategoryMapper.class).delete(id) == 1;
    }

    public boolean updateCategory(String name, String id) {
        Map<String,Object> param = new HashMap<>();
        param.put("name",name);
        param.put("id",id);
        return sqlSession.getMapper(CategoryMapper.class).updateCategory(param) == 1;
    }

    @Transactional
    public boolean upMove(Integer id) {
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);

        Map<String,Object> param1 = new HashMap<>();
        param1.put("id",id);
        Category category = mapper.getCategoryByIdOrOrder(param1);
        int order = category.getOrder()-1;

        Map<String,Object> param = new HashMap<>();
        param.put("id",id);
        param.put("order",order);
        int i = mapper.updateCategory(param);

        System.out.println("category:"+category);

        System.out.println("=================order:"+order);
//        param1.clear();
        Map<String,Object> param2 = new HashMap<>();
        param2.put("order",order+1);
        Category category1 = mapper.getCategoryByIdOrOrder(param2);
        System.out.println(category1+"----------------------");
        param.clear();
        param.put("id",category1.getId());
        param.put("order",order);
        int i1 = mapper.updateCategory(param);



        return  i1 ==1;
    }

    public boolean downMove(Integer id, Integer pId) {

        return true;

    }

    public List<Category> twoLevelMsg(int pId, int i) {
        return sqlSession.getMapper(CategoryMapper.class).twoLevelMsg(pId,i);
    }
}
