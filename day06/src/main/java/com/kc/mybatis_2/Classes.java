package com.kc.mybatis_2;

import java.util.List;

public class Classes {

    private int cid;
    private String cname;

    private List<Students> studertsList;



    public List<Students> getStudertsList() {
        return studertsList;
    }

    public void setStudertsList(List<Students> studertsList) {
        this.studertsList = studertsList;
    }

    public Classes() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", studertsList=" + studertsList +
                '}'+"\n";
    }
}
