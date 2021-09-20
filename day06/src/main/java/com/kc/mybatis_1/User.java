package com.kc.mybatis_1;

public class User {

    private Integer id;
    private String name;
    private Integer age;
    private Integer aa;

    private Address address;

    /***
     *
     * 该类必须要有一个无参构造器
     *
     * UserMapper userMapper = session.getMapper(UserMapper.class);
     *
     * 这个方法是通过反射创建 UserMapper 对象的
     *
     */

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", aa=" + aa +
                ", address=" + address +
                '}';
    }
}
