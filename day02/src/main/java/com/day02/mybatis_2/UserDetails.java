package com.day02.mybatis_2;

public class UserDetails {

    private int id;
    private String name;
    private int age;
    private String gender;

    private int aid;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getAid() {
        return aid;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", aid=" + aid +
                '}'+"\n";
    }
}
