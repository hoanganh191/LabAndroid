package com.example.lab01;

import java.io.Serializable;

public class NhanVien2 implements Serializable {
    private String hoten;
    private String quequan;
    private boolean gioitinh;

    private String imageUri;


    public NhanVien2(String hoten, String quequan, boolean gioitinh, String imageUri) { // <<<< THAY ĐỔI: Tham số cuối là String imageUri
        this.hoten = hoten;
        this.quequan = quequan;
        this.gioitinh = gioitinh;
        this.imageUri = imageUri; // <<<< THAY ĐỔI
    }

    public NhanVien2() {

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


    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Override
    public String toString() {
        String gt = "";
        if (gioitinh == true) {
            gt = "Nam";
        } else {
            gt = "Nữ";
        }
        return "Họ tên: " + hoten + " Quê quán: " + quequan + " Giới tính: " + gt;
    }
}
