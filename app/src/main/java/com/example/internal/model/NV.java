package com.example.internal.model;

import java.io.Serializable;

public class NV implements Serializable {
    private int id;
    private String name, year, quequan,trinhdo;
    public static int snv=1000;

    public NV() {
    }

    public NV(String name, String year, String quequan, String trinhdo) {
        this.id=snv++;
        this.name = name;
        this.year = year;
        this.quequan = quequan;
        this.trinhdo = trinhdo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    public static int getSnv() {
        return snv;
    }

    public static void setSnv(int snv) {
        NV.snv = snv;
    }

    @Override
    public String toString() {
        return "NV{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", quequan='" + quequan + '\'' +
                ", trinhdo='" + trinhdo + '\'' +
                '}';
    }
}
