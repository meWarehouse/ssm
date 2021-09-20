package com.day02.mybatis_3;

public class Details {

    private int aid;
    private String hobby;
    private String eat;
    private String height;
    private String from;

    @Override
    public String toString() {
        return "Details{" +
                "aid=" + aid +
                ", hobby='" + hobby + '\'' +
                ", eat='" + eat + '\'' +
                ", height='" + height + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
