package com.day02.spring_3;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component
public class Dao<T> {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void init(BasicDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        System.out.println(jdbcTemplate);
    }

    private Class<T> clazz;

    public Dao() {

        Type superclass = getClass().getGenericSuperclass();

        if (superclass instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType) superclass).getActualTypeArguments();

            if (types != null && types.length > 0) {

                if (types[0] instanceof Class) {
                    clazz = (Class<T>) types[0];
                }

            }

        }
    }


    //增
    //删
    //改
    public Object update(String sql, Object... args) {

        return jdbcTemplate.update(sql, args);

    }

    //插入并返回插入的主键
    public List insert(String sql, Object... args) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});

               ps.setString(1,args[0].toString());
               ps.setInt(2,Integer.parseInt(args[1].toString()));
               ps.setInt(3,Integer.parseInt(args[2].toString()));

                return ps;
            }
        }, keyHolder);

        List<Map<String, Object>> keyList = keyHolder.getKeyList();

        return keyList;

    }


    //查
    public List<T> getForList(String sql, Object... args){

//        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql, args);

        List<T> ts = jdbcTemplate.queryForList(sql, args, clazz);

        return  ts;

    }

    public T get(String sql, Object... args){

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<T>(clazz), args);

    }

    public <E> E getForValue(String sql, Object... args){

        Object o = jdbcTemplate.queryForObject(sql, args, Object.class);

        return (E) o;
    }


}
