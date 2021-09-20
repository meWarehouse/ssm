package com.kc.ssm1;

import org.springframework.stereotype.Component;

/**
 * @author wen
 * @create 2020-05-20 22:24
 */
@Component
public interface UserMapper {

    User getUser(Integer id);


    int deleteUser(Integer id);

    int add1(User user);



}
