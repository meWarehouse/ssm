package com.day02.d2;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Users {
    private String name;
    private Integer age;
    private String sex;
    private List<String> list;
    private Set<String> set;
    private Map<String,Object> map;

    @Resource(name = "c")
    private Customers customers;

    public void setSet(Set<String> set) {
        System.out.println("调用 setSet 方法");
        this.set = set;
    }

    public void setMap(Map<String, Object> map) {
        System.out.println("调用 setMap 方法");
        this.map = map;
    }

    public void setList(List<String> list) {
        System.out.println("调用 setList 方法");
        this.list = list;
    }

    public Users() {
        System.out.println("User 构造器");
    }

    public void eat(){
        System.out.println("eat.......");
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        System.out.println("调用 setSex 方法");
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("调用 setAge 方法");
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("调用 setName 方法");
        this.name = name;
    }

    public void print(){
        customers.print();
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
