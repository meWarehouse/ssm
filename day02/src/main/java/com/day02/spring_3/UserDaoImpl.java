package com.day02.spring_3;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("userDAO")
public class UserDaoImpl extends Dao<User> implements UserDao {

    @Override
    public boolean insert(User user) {

        String sql = "INSERT INTO t_user(name,age,aa) VALUES(?,?,?)";

        Object update = update(sql, user.getName(), user.getAge(), user.getAa());

        String s = update.toString();

        int val = Integer.parseInt(s);

        return val == 1;
    }

    @Override
    public List insert1(User user) {
        String sql = "INSERT INTO t_user(name,age,aa) VALUES(?,?,?)";

        List key = insert(sql, user.getName(), user.getAge(), user.getAa());

        return key;
    }

    @Override
    public boolean delete(int id) {

        String sql = "delete from t_user where id = ?";

        Object forValue = update(sql, id);

        String s = forValue.toString();

        int val = Integer.parseInt(s);

        return val == 1;
    }

    @Override
    public boolean update(User u) {

        String sql = "update t_user set name = ?,age = ?,aa = ? where id = ?";

        return (boolean) update(sql, u.getName(), u.getAge(), u.getAa());
    }

    @Override
    public User get(int id) {

        String sql = "select * from t_user where id = ?";

        return get(sql, id);
    }

    @Override
    public Map<String, Object> queryForMap(int id) {
        return null;
    }

    @Override
    public int getCount(String name) {

        String sql = "select count(0) from t_user where name = %?%";

        Object forValue = getForValue(sql, name);

        String s = forValue.toString();

        int val = Integer.parseInt(s);

        return val;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryForList() {



        return null;
    }





    /*private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(BasicDataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);

        System.out.println("jdbc:----:" + jdbcTemplate);
    }



    @Override
    public List insert1(User user) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("insert into t_user(name,age,aa) values(?,?,?)", new String[] {"id"});

                ps.setString(1,user.getName());
                ps.setInt(2,user.getAge());
                ps.setInt(3,user.getAa());

                return ps;
            }
        },keyHolder);

        List<Map<String, Object>> keyList = keyHolder.getKeyList();

        return  keyList;


    }



    @Override
    public boolean insert(User user) {

        String sql = "INSERT INTO t_user(name,age,surplusAge) VALUES(?,?,?)";

        int update = jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getAa());

        return update == 1;
    }

    @Override
    public boolean delete(int id) {

        int update = jdbcTemplate.update("delete from t_user where id = ?", id);

        return update == 1;
    }

    @Override
    public boolean update(User u) {
        return false;
    }

    @Override
    public User get(int id) {

        User user = jdbcTemplate.queryForObject("select * from t_user where id = ?", new BeanPropertyRowMapper<User>(User.class), id);

        return user;
    }

    @Override
    public Map<String, Object> queryForMap(int id) {
        return null;
    }

    @Override
    public int getCount() {
        Integer integer = jdbcTemplate.queryForObject("select count(0) from t_user", Integer.class);
        return integer;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public List<Map<String, Object>> queryForList() {
        return null;
    }*/
}
