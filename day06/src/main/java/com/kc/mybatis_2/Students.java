package com.kc.mybatis_2;

public class Students {

    private int sid;
    private int sno;
    private String sname;
    private String sgender;
    private int cid;

    public Students() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    @Override
    public String toString() {
        return "Studerts{" +
                "sid=" + sid +
                ", sno=" + sno +
                ", sname='" + sname + '\'' +
                ", sgender='" + sgender + '\'' +
                ", cid=" + cid +
                '}'+"\n";
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
