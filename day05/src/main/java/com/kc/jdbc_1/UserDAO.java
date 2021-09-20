package com.kc.jdbc_1;

import java.util.List;
import java.util.Map;

public interface UserDAO {

    void test();

    void test1();


    public boolean insert(User user);


    public boolean delete(int id);


    public boolean update(User u);


    public User get(int id);


    public Map<String, Object> queryForMap(int id);


    public int getCount();


    public List<User> list();


    public List<Map<String, Object>> queryForList();





}
