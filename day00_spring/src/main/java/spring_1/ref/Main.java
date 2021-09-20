package spring_1.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_1/beans.xml");



        Dao dao = ac.getBean(Dao.class);

        dao.save();

    }
}
