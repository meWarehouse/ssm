package test.com.ssm1.dao;

import org.apache.ibatis.annotations.Param;
import test.com.ssm1.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @author zero
 * @create 2020-06-02 23:35
 */
public interface UserMapper {

    List<User> test();

    List<User> listPage(Map<String, Integer> params);

    int getCount();

    int deleteById(Integer userId);

    int add(User user);

    int updateById(User user);
    
    User checkUserName(String userName);

    User selectById(Integer id);

    User getUserForUsernameAndUserpassword(Map<String, Object> param);

    int modifyPassword(Map<String, Object> param);

    void updateIcon(Map<String, Object> param);

    int updateRid(@Param("uid") Integer uid, @Param("rid") Integer rid);
}
