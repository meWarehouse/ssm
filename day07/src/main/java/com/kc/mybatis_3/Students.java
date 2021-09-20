package com.kc.mybatis_3;

public class Students {


    private int sid;
    private String sno;
    private String sname;
    private String sgender;
    private int cid;

    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sgender='" + sgender + '\'' +
                ", cid=" + cid +
                '}'+"\n";
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Students() {
    }
}
