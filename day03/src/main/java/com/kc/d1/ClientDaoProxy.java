package com.kc.d1;

public class ClientDaoProxy implements ClientDao {

    private ClientDao clientDao;

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void insert() {
        before();

        clientDao.insert();

        after();
    }

    private void before(){
        System.out.println("代理前通知");
    }
    private void after(){
        System.out.println("代理后通知");
    }
}
