package com.kc.d2;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean insert() {
        System.out.println("UserDaoImpl insert...");
        return true;
    }

    @Override
    public boolean delete() {
        System.out.println("UserDaoImpl delete...");
        return true;
    }
}
