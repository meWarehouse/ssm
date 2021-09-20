package com.kc.test1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {

    private static SqlSessionFactory sqlSessionFactory;


    public static void init() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("test1/mybatis-config1.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

    }


    public static SqlSessionFactory  getInstance(){

        return sqlSessionFactory;
    }



}
