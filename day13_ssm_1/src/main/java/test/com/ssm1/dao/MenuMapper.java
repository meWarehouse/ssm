package test.com.ssm1.dao;

import test.com.ssm1.bean.Menu;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-11 13:29
 */
public interface MenuMapper {

    //查
    int getCount();
    List<Menu> selectPageList(Map<String,Object> map);
    List<Menu> selectAll();

    // 增
    int addItem(Menu menu);

    // 改
    int updateItem(Menu menu);


    Menu getMenu(Integer id);

    int delMenu(Integer id);
}

