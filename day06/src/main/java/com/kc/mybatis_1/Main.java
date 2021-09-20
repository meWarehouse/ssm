package com.kc.mybatis_1;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        String config = "mybatis-config.xml";//代表 classpath 下的配置文件

        InputStream is = Resources.getResourceAsStream(config);//代表 classpath 下配置文件的输入流

        /*
            构建一个 SqlSessionFactory 的构建器
            一旦创建了 SqlSessionFactory，就不再需要它了。 因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域 （也就是局部方法变量）
         */
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        /*
            构建一个 SqlSessionFactory 对象 一个数据库对应一个 SqlSessionFactory 对象
            SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在， SqlSessionFactory 在应用运行期间不要重复创 建多次，而应该是单例的
         */
        SqlSessionFactory sqlSessionFactory = builder.build(is);
//        SqlSessionFactory sqlSessionFactory = builder.build(is,"指定环境可以指定多个 没有指定就是 mybatits-config.xml 问见中的默认环境 <environments default="development"> ");


        /*
            打开一个 SqlSession
                SqlSession 的实例不是线程安全的，因此是不能被共享的，每个线程都应该有它自己的 SqlSession 实例。 SqlSession的作用域应该是请求或方法作用域。 每次收到 HTTP 请求，就可以打开一个 SqlSession，返回一个响应 后，就关闭它
         */
        SqlSession session = null;

        try {

            //!!!! sqlSessionFactory.openSession() 默认是不提交事务的 调用 SqlSession 的 commit() 方法提交事务 sqlSessionFactory.openSession(true) 自动提交事务
            session = sqlSessionFactory.openSession(true);

            /*
                userMapper 是实现了  UserMapper 的一个接口的实列
                映射器是一些绑定映射语句的接口。映射器接口的实例是从 SqlSession 中获得的。映射器实例的作用域应该是方法 作用域。 也就是说，映射器实例应该在调用它们的方法中被获取，使用完毕之后即可丢弃。 映射器实例并不需要被 显式地关闭
             */
            UserMapper userMapper = session.getMapper(UserMapper.class);
            //userMapper：org.apache.ibatis.binding.MapperProxy@4f970963 通过代理创建
            System.out.println("userMapper：" + userMapper);

//            User user = userMapper.get(25);
//            System.out.println(user);

//            User user =  new User("士",99,1);
////            int insert = userMapper.insert(user);
//            int insert1 = userMapper.insert1(user);
////
//            System.out.println("insert:" + insert1);

//            int delete = userMapper.delete(22);
//            int delete = userMapper.delete1("000000");
//            System.out.println("delete:"+delete);

//            User u = new User("sisi",12,88);
//            u.setId(4);
//            userMapper.update(u);

//            List<User> select = userMapper.select();
//            System.out.println(select);

//            int count = userMapper.getCount();
//            System.out.println("count:"+count);


//            session.commit();


            //   /************** 结果映射 ************** /

//            Map<String,Object> mapUser = userMapper.getMap(4);
//
//            Set<Map.Entry<String, Object>> entries = mapUser.entrySet();
//            for(Map.Entry<String, Object> entry : entries){
//                System.out.println(entry.getKey()+":"+entry.getValue());
//            }

//            User userMapper1 = userMapper.get1(4);
//            System.out.println(userMapper1);

//            User userMapper2 = userMapper.get2(4);
//            System.out.println(userMapper2);

//            UserDetial userMapper3 = userMapper.get3(4);
//            System.out.println(userMapper3);

            UserDetial userMapper4 = userMapper.get4(3);

            System.out.println(userMapper4);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭 session
            session.close();
        }

        //jdk8 新特性 SqlSession 一定会被关闭
//        try(SqlSession session = sqlSessionFactory.openSession()) {
//            UserMapper userMapper = session.getMapper(UserMapper.class);
//            User user = userMapper.get(4);
//            System.out.println(user);
//        }





    }
}
