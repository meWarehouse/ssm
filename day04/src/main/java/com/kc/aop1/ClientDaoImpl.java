package com.kc.aop1;

import org.springframework.stereotype.Component;

@Component("clientDao")
public class ClientDaoImpl implements ClientDao {
    @Override
    public boolean insert() {
        System.out.println("ClientDaoImpl insert");
        return true;
    }
}
