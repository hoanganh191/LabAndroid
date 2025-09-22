package com.example.lab01;

import java.io.Serializable;

public class SinhVien implements Serializable {
    String hoTen;
    String moTa;
    boolean gioiTinh;
    boolean vanBang;
    String imageUri;

    public SinhVien() {
    }

    public SinhVien(String hoTen, String moTa, boolean gioiTinh, boolean vanBang, String imageUri) {
        this.hoTen = hoTen;
        this.moTa = moTa;
        this.gioiTinh = gioiTinh;
        this.vanBang = vanBang;
        this.imageUri = imageUri;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public boolean isVanBang() {
        return vanBang;
    }

    public void setVanBang(boolean vanBang) {
        this.vanBang = vanBang;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    @Override
    public String toString() {
        if (gioiTinh) {
            return "hoTen='" + hoTen + ' ' + ", queQuan='" + moTa + ' ' + ", gioiTinh=" + "Nam" + ", vanBang=" + vanBang;
        } else {
            return "hoTen='" + hoTen + ' ' + ", queQuan='" + moTa + ' ' + ", gioiTinh=" + "Nữ" + ", vanBang=" + vanBang;
        }
    }
}
