package com.day02.spring_3;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public boolean insert(User user);

    public List insert1(User user);


    public boolean delete(int id);


    public boolean update(User u);


    public User get(int id);


    public Map<String, Object> queryForMap(int id);


    public int getCount(String name);


    public List<User> list();


    public List<Map<String, Object>> queryForList();





}
