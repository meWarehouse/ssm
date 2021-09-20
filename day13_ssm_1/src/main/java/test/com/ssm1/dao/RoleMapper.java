package test.com.ssm1.dao;

import org.apache.ibatis.annotations.Delete;
import test.com.ssm1.bean.Role;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-10 13:29
 */
public interface RoleMapper {

    //增
    public int add(Role role);

    //删
    @Delete("DELETE FROM sm_role WHERE id = #{param}")
    public int del(Integer id);

    //改
    public int update(Role role);

    //查
    public int selectCount();
    public List<Role> selectAll(Map<String,Object> map);


    List<Role> allRolez();
}
