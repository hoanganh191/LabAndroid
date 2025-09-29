package com.example.lab03;

import java.io.Serializable;

public class SanPham implements Serializable {
    private String tenSp;
    private String moTa;
    private int gia;
    private int anh;

    public SanPham() {

    }

    public SanPham(String tenSp, String moTa, int gia, int anh) {
        this.tenSp = tenSp;
        this.moTa = moTa;
        this.gia = gia;
        this.anh = anh;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
