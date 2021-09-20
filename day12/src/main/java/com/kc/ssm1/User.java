package com.kc.ssm1;

/**
 * @author wen
 * @create 2020-05-20 22:24
 */
public class User {

    private Integer id;
    private String lastName;
    private Integer age;
    private String gender;

    public User(String lastName, Integer age, String gender) {
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
