package com.kc.jdbc_1;

public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Integer surplusAge;

    public User() {
    }

    public User(String name, Integer age, Integer surplusAge) {
        this.name = name;
        this.age = age;
        this.surplusAge = surplusAge;
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

    public Integer getSurplusAge() {
        return surplusAge;
    }

    public void setSurplusAge(Integer surplusAge) {
        this.surplusAge = surplusAge;
    }

    @Override
    public String
    toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", surplusAge=" + surplusAge +
                '}';
    }
}
