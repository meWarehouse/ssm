package com.kc.d2;

public class ClientDaoImpl implements ClientDao {
    @Override
    public boolean insert() {
        System.out.println("ClientDaoImpl insert......");
        return true;
    }
}
