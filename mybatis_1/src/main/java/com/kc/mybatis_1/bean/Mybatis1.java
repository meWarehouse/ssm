package com.kc.mybatis_1.bean;

import org.apache.ibatis.type.Alias;

/**
 * @author wen
 * @create 2020-05-19 20:38
 */
@Alias("myba")
public class Mybatis1 {

    private Integer id;
    private String lastName;
    private Integer age;
    private String email;

    @Override
    public String toString() {
        return "Mybatis1{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}'+"\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
