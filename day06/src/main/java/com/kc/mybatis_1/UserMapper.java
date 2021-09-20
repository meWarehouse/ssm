package com.kc.mybatis_1;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public User get(int id);

    public int insert(User user);
    public int insert1(User user);

    public int delete(int id);
    public int delete1(String name);

    public int update(User user);

    public List<User> select();

    public int getCount();

    //   /************** 结果映射 ************** /

    /*

    结果映射有三种形式：
        将结果集映射到一个map中
        如果结果集中的列名和一个java bean的属性名相同，可以将结果集映射到一个java bean中
        如果结果集中的列名和java bean的属性名不同，还可以显式的配置一个ResultMap

     */

    //将结果集映射到一个map中
    //通过 id 获取数据库的一行，将结果放入一个 map 中  Map<列名,列值> 无需对应的数据的 bean 对象直接获取数据库中的数据
    public Map<String,Object> getMap(int id);

    /*
        如果结果集中的列名和一个 ***java bean的属性名相同***，可以将结果集映射到一个java bean中
        如果不同 （例如数据数据库中的属性列表为 u_id,u_naem java bean 中的属性为 id name ）可以通过取别名的方式解决

        select * from t_user where id = #{id} --> select u_id id,u_name name,u_age age,u_aa aa from t_user where u_id=#{id}
     */
    public User get1(int id);

    //如果结果集中的列名和java bean的属性名不同，还可以显式的配置一个ResultMap
    public User get2(int id);

    public UserDetial get3(int id);

    public UserDetial get4(int id);


}
