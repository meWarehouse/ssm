package com.kc.aop2;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public boolean insert(User user);

    public boolean delete(int id);

    public boolean update(User user);

    public User get(int id);

    Map<String, Object> queryForMap(int id);

    public int getCount();

    public List<User> select();

    List<Map<String, Object>> queryForList();

}
