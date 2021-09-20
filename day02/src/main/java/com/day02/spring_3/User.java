package com.day02.spring_3;

public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Integer aa;

    public User() {
    }

    public User(String name, Integer age, Integer aa) {
        this.name = name;
        this.age = age;
        this.aa = aa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAa() {
        return aa;
    }

    public void setAa(Integer aa) {
        this.aa = aa;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", aa=" + aa +
                '}';
    }
}
