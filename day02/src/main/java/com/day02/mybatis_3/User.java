package com.day02.mybatis_3;

public class User {
    private int id;
    private String name;
    private int age;
    private String gender;
    private int aid;

    private Details details;

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", details=" + details +
                '}'+"\n";
    }
}
