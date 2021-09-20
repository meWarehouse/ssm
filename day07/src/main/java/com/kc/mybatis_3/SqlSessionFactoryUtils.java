package com.kc.mybatis_3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {

    public static SqlSessionFactory sqlSessionFactory;

    public static void init() throws IOException {

        String config = "mybatis_3/mybatis-config3.xml";

        InputStream is = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        sqlSessionFactory = sqlSessionFactoryBuilder.build(is);


    }

    public static SqlSessionFactory getInstance() {
        return sqlSessionFactory;
    }
}
