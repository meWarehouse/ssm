package com.kc.ssm1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wen
 * @create 2020-05-20 23:36
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");


        String url="jdbc:mysql://localhost/spring_mybatis? useUnicode=true&characterEncoding=UTF8&userSSL=true&serverTimezone=GMT%2B8";
        String user="root";
        String pawwword = "root";

        Connection connection = DriverManager.getConnection(url,user,pawwword);

        System.out.println(connection);


    }

}
