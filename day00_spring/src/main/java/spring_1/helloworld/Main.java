package spring_1.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {


//      HelloWorld helloWorld = new HelloWorld();
//      helloWorld.setUser("Tom");
//      helloWorld.hello();

        //1.创建一个 IOC 容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring_1/beans.xml");

        //2.从 IOC 容器中 获取 bean 的实例

        /*
            根据类型来获取 bean 的实例: 要求在  IOC 容器中只有一个与之类型匹配的 bean, 若有多个则会抛出异常.
		    一般情况下, 该方法可用, 因为一般情况下, 在一个 IOC 容器中一个类型对应的 bean 也只有一个.
         */
//        HelloWorld helloWorld = ac.getBean(HelloWorld.class);

//        HelloWorld helloWorld = (HelloWorld) ac.getBean("hw");

        HelloWorld helloWorld = (HelloWorld)ac.getBean("hw3");

        //使用 bean
        helloWorld.hello();

        Car car = (Car) ac.getBean("car");

        System.out.println(car);

        Car car2 = (Car) ac.getBean("car2");

        System.out.println(car2);




    }

}
