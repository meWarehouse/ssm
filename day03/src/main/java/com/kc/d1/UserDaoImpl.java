package com.kc.d1;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean insert() {
        System.out.println("UserDaoImpl insert...");
        return true;
    }
}
