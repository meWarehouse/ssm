package com.kc.mybatis_2.bean;

import java.util.List;

/**
 * @author wen
 * @create 2020-05-20 18:59
 */
public class Department {

    private Integer id;
    private String deptName;

    private List<Employee> employeesList;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", employeesList=" + employeesList +
                '}';
    }

    public Department(Integer id) {
        this.id = id;
    }

    public Department() {
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

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }
}
