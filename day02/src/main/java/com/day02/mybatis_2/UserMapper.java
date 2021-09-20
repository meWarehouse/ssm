package com.day02.mybatis_2;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public User get1(int id);

    public UserDetails get2(int id);


    public int insert(User user);

    int delete(int id);

    int update(User user);

    int getCount();


    List<UserDetails> getForList();

    Map<String,Object> getMap(int id);

    List<User> getUser(String name);


}
