package test.com.ssm1.dao;

import test.com.ssm1.bean.UserRole;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-10 20:53
 */
public interface UserRoleMapper {

    //查
    public int getCount();
    public List<UserRole> selectAll(Map<String,Object> map);

    //改
    public int update(UserRole userRole);


    UserRole getUserRole(Integer id);
}
