package com.kc.aop2;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component("userDao")
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(BasicDataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println(jdbcTemplate);
    }


    @Override
    public boolean insert(User user) {

        String sql = "INSERT INTO t_user(name,age) VALUES(?,?)";

        int i = jdbcTemplate.update(sql, user.getName(), user.getAge());

        return i == 1;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM t_user WHERE id = ?";
        int i = jdbcTemplate.update(sql, id);
        return i == 1;
    }

    @Override
    public boolean update(User user) {
        String sql = "UPDATE t_user SET name = ?,age = ? WHERE id = ?";

        int i = jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getId());

        return i == 1;
    }

    //结果集对象映射器
    private static final class UserRowMapper implements RowMapper<User>{

        /**
         * spring 对于 结果集中的每一行数据，调用 mapRow 方法，获取一个对象
         * @param rs 代表结果集中一行数据
         * @param rowNum 代表第几行数据
         * @return
         * @throws SQLException
         */
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            return user;
        }
    }

    @Override
    public User get(int id) {

        String sql = "SELECT id,name,age FROM t_user WHERE id =?";
        //查询单行数据
//        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(),id);

        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);

        return user;
    }

    @Override
    public Map<String, Object> queryForMap(int id) {
        String sql = "SELECT id,name,age FROM t_user WHERE id =?";

        //查询单行数据   列名为key 列的值为value
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, id);

        return stringObjectMap;
    }

    @Override
    public int getCount() {
        String sql = "SELECT COUNT(id) FROM t_user";
        Integer n = jdbcTemplate.queryForObject(sql, Integer.class);
        return n;
    }

    @Override
    public List<User> select() {

        String sql = "SELECT * FROM t_user";

//        List<User> userList = jdbcTemplate.query(sql, new UserRowMapper());
        List<User> userList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));

        return userList;
    }

    @Override
    public List<Map<String, Object>> queryForList() {
        String sql = "SELECT * FROM t_user";

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        return maps;
    }



}
