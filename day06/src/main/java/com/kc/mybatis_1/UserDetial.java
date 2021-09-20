package com.kc.mybatis_1;

public class UserDetial {

    private Integer id;
    private String name;
    private Integer age;
    private Integer aa;
    private String gender;

    private Address address;

    public UserDetial() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDetial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", aa=" + aa +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                '}';
    }
}
