package test.com.ssm1.dao;

import test.com.ssm1.bean.Category;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-04 16:14
 */
public interface CategoryMapper {

    List<Category> getCategoryLevelAll(Map<String, Object> param);

    int getCategoryLevelCount(Map<String, Object> param);

    List<Category> selectLevel(int i);

    int getMaxOrder(Map<String, Object> param);

    int addCategory(Category category);

    int delete(Integer id);

    int updateCategory(Map<String, Object> param);

    Category getCategoryByIdOrOrder(Map<String, Object> param1);

    List<Category> twoLevelMsg(int pId, int i);
}
