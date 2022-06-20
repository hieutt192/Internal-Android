package com.example.internal.model;

import java.io.Serializable;
import java.time.LocalDate;

public class NVVT implements Serializable {
    private int id;
    private NV nv;
    private VT vt;
    private String create_at;
    public static int snv=1000;

    public NVVT() {
    }

    public NVVT(NV nv, VT vt) {
        this.id=snv++;
        this.nv = nv;
        this.vt = vt;
        this.create_at= LocalDate.now().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NV getNv() {
        return nv;
    }

    public void setNv(NV nv) {
        this.nv = nv;
    }

    public VT getVt() {
        return vt;
    }

    public void setVt(VT vt) {
        this.vt = vt;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public static int getSnv() {
        return snv;
    }

    public static void setSnv(int snv) {
        NVVT.snv = snv;
    }

    @Override
    public String toString() {
        return "NVVT{" +
                "id=" + id +
                ", nv=" + nv.getName() +
                ", vt=" + vt.getTitle() +
                ", create_at='" + create_at + '\'' +
                '}';
    }
}
