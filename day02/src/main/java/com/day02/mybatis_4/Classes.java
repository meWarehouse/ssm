package com.day02.mybatis_4;

import java.util.List;

public class Classes {

    private int cid;
    private String name;

    private List<Students> stus;

    @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", stus=" + stus +
                '}';
    }

    public List<Students> getStus() {
        return stus;
    }

    public void setStus(List<Students> stus) {
        this.stus = stus;
    }

    public Classes() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
