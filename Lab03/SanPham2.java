package com.example.lab03;

import java.io.Serializable;

public class SanPham2 implements Serializable {
    private String tenSp;
    private int gia;
    private int anh;

    public SanPham2() {
    }

    public SanPham2(String tenSp, int gia, int anh) {
        this.tenSp = tenSp;
        this.gia = gia;
        this.anh = anh;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
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
