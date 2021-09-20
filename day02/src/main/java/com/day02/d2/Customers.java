package com.day02.d2;

public class Customers {
    private String phone;
    private String address;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void print(){
        System.out.println("phone:"+phone+",address:"+address);
    }
}
