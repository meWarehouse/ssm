package com.kc.d1;

public class AppTest {
    public static void main(String[] args) {

        UserDao target = new UserDaoImpl();

        UserDaoProxy proxy = new UserDaoProxy();
        proxy.setTarget(target);
        proxy.insert();


       ClientDao clientDaoTarget = new ClientDaoImpl();

        ClientDaoProxy proxy1 = new ClientDaoProxy();
        proxy1.setClientDao(clientDaoTarget);
        proxy1.insert();

    }
}
