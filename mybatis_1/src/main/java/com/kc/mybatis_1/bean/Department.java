package com.kc.mybatis_1.bean;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @author wen
 * @create 2020-05-20 15:43
 */
@Alias("dept")
public class Department {

    private Integer id;
    private String deptName;

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", employees=" + employees +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
