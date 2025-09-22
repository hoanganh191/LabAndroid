package com.example.lab01;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private String hoten, quequan;
    private boolean gioitinh;

    public NhanVien(String quequan, boolean gioitinh, String hoten) {
        this.quequan = quequan;
        this.gioitinh = gioitinh;
        this.hoten = hoten;
    }

    public NhanVien() {
        this.quequan = "";
        this.gioitinh = true;
        this.hoten = "";
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return
                "hoten='" + hoten + '\'' + ", quequan='" + quequan + '\'' + ", gioitinh=" + gioitinh;
    }
}
