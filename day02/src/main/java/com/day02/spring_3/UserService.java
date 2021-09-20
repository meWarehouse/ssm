package com.day02.spring_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Component("userService")
public class UserService {


    UserDao userDAO;

    @Autowired
    public void setUserDAO(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    private TransactionTemplate transactionTemplate;

    @Autowired
    public void init(DataSourceTransactionManager transactionManager){
        transactionTemplate = new TransactionTemplate(transactionManager);
    }


    @Transactional
   public void test(){

//
//       ApplicationContext ac = new ClassPathXmlApplicationContext("spring_3/spring_3.xml");
//
//       UserDao userDAO = ac.getBean("userDAO", UserDao.class);

       User u = new User("来来来",12,88);

       List list = userDAO.insert1(u);

//       if(0 == 0){
//           throw new RuntimeException("异常");
//       }

       System.out.println("insert1-----:"+list);

       boolean delete = userDAO.delete(19);

       System.out.println("delete:-----" + delete);



//      transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//          @Override
//          protected void doInTransactionWithoutResult(TransactionStatus status) {
//              User u = new User("000000",12,88);
//
//              List list = userDAO.insert1(u);
//
//              if(0 == 0){
//                  throw new RuntimeException("异常");
//              }
//
//              System.out.println("insert1-----:"+list);
//
//              boolean delete = userDAO.delete(19);
//
//              System.out.println("delete:-----" + delete);
//          }
//      });


   }

}
