package com.kc.jdbc_1;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component("userDao")
public class UserDAOImpl implements  UserDAO{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(BasicDataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("BasicDataSource:"+jdbcTemplate);
    }


    @Override
    public boolean insert(User user) {

        String sql = "INSERT INTO t_user(name,age,surplusAge) VALUES(?,?,?)";

        int update = jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getSurplusAge());

        return update == 1;
    }

    @Override
    public boolean delete(int id) {

        int delete = jdbcTemplate.update("DELETE FROM t_user WHERE id = " + id);

        System.out.println("delete:"+delete);

        return delete == 1;
    }

    @Override
    public boolean update(User u) {

        String sql = "UPDATE t_user SET name = ?,age = ?,surplusAge = ? WHERE id = ?";

        int i = jdbcTemplate.update(sql,u.getName(),u.getAge(),u.getSurplusAge(),u.getId());

        return i == 1;
    }

    @Override
    public User get(int id) {

        String sql = "SELECT * FROM t_user WHERE id = ?";

        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);


        return user;
    }

    @Override
    public Map<String, Object> queryForMap(int id) {
        String sql = "SELECT id,name,age FROM t_user WHERE id =?";

        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, id);

        return stringObjectMap;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryForList() {
        return null;
    }



    /*****************************************************************/

    @Override
    public void test() {

        KeyHolder KeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                return connection.prepareStatement("INSERT INTO t_user(name,age,surplusAge) VALUES('意义',1,99)");
            }
        });

//        int i = KeyHolder.getKey().intValue();//获取插入数据的主键
//
//        System.out.println("主键："+i);

    }

    @Override
    public void test1() {

        String sql="INSERT INTO t_user(name) values(?)";

        int count = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setObject(1,"name1");
            }
        });

    }
}
