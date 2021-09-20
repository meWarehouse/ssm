package com.day02.mybatis_1;

public interface UserMapper {

    int insert(User user);

    User get(int id);


}
