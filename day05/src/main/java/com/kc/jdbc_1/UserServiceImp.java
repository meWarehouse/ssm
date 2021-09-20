package com.kc.jdbc_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userService")
public class UserServiceImp implements UserService{

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    /**
     * 使用xml的声明式事务
     */

    /*
        配置事务管理器的“id”的值 必须和支持注解的事务“transaction-manager”一致 且必须为transactionManager

@Transactional(value = "transactionManager")里面value的值写不写都可以 默认transactionManager

    <!-- 3.配置事务管理器 -->
    <bean id="transactionManager"
        class="org.springframework.orm.jpa.JpaTransactionManager">
        <property name="entityManagerFactory"
            ref="entityManagerFactory"></property>
    </bean>

    <!-- 4.配置支持注解的事务 -->
    <tx:annotation-driven
        transaction-manager="transactionManager" />

除此之外还有种可能是 transactionManager'找到匹配的

     */

    @Override
    @Transactional //在 需要 事物的方法上注解  @Transactional 就可开启事物
    public void remove() {
        // 在前记录日志
        userDAO.delete(7);

//        if(0 == 0){
//            throw new RuntimeException("人为异常");
//        }

        userDAO.delete(8);

        //在后记录日志
    }

    /**
     * 配置编程式事务
     */


//    事物模板类
//    private TransactionTemplate transactionTemplate;
//    @Autowired
//    public void init(PlatformTransactionManager txManger){
//        this.transactionTemplate = new TransactionTemplate(txManger);
//    }
//
//    @Override
//    public void remove() {
//
//        /*
//            要使得其同时成功或同时失败
//
//         */
//
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//
//            //调用次方法前开启事物
//            //如果方法异常回滚事物
//            //没有异常就提交事务
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus status) {
//                //在前记录日志
//                userDAO.delete(7);
//
////                if(0 == 0){
////                    throw new RuntimeException("人为异常");
////                }
//
//                userDAO.delete(8);
//
//                //在后记录日志
//            }
//        });
//    }








}
