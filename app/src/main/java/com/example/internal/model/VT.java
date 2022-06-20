package com.example.internal.model;

import java.io.Serializable;

public class VT implements Serializable {
    private int id;
    private String title, des;
    public static int svt=1000;

    public VT() {
    }

    public VT(String title, String des) {
        this.id=svt++;
        this.title = title;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public static int getSvt() {
        return svt;
    }

    public static void setSvt(int svt) {
        VT.svt = svt;
    }

    @Override
    public String toString() {
        return "VT{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
