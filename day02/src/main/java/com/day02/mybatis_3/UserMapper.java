package com.day02.mybatis_3;

import java.util.List;

public interface UserMapper {

    List<User> getUser(int id);

    Details get(int id);

}
