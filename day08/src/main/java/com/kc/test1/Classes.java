package com.kc.test1;

public class Classes {
    private int cid;
    private String name;

    public Classes() {
        super();

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

    @Override
    public String toString() {
        return "Classes [cid=" + cid + ", name=" + name + "]";
    }
}
