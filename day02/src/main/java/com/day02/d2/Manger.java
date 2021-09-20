package com.day02.d2;

public class Manger {

    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


    public void print(){
        System.out.println("Users:"+users.toString());
        users.print();
    }

}
