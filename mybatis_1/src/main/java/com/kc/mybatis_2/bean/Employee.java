package com.kc.mybatis_2.bean;

/**
 * @author wen
 * @create 2020-05-20 18:58
 */
public class Employee {

    private Integer id;
    private String lastName;
    private Integer age;
    private String gender;
    private String email;

    private Integer did;

    public Employee() {
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Employee(Integer id, String lastName, Integer age, String gender, String email, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.department = department;
    }

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                '}';
    }
}
