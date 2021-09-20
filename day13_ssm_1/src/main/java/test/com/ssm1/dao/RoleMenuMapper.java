package test.com.ssm1.dao;

import org.apache.ibatis.annotations.Param;
import test.com.ssm1.bean.Menu;

import java.util.List;

/**
 * @author zero
 * @create 2020-06-11 17:41
 */
public interface RoleMenuMapper {

    List<Menu> getMenuTree();


    void deleteRoleId(Integer roleId);

    void insert(@Param("menuId") Integer menuId, @Param("roleId") Integer roleId);

    List<Menu> getFromUser(Integer roleId);



}
