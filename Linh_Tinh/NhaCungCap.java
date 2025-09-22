package com.example.thi_nghiem;

public class NhaCungCap {
    private String maCongTy;
    private String tenCongTy;
    private String tenGiaoDich;
    private String diaChi;
    private String email;
    private String dienThoai;
    private String fax;

    // Constructor
    public NhaCungCap(String maCongTy, String tenCongTy, String tenGiaoDich, String diaChi, String email, String dienThoai, String fax) {
        this.maCongTy = maCongTy;
        this.tenCongTy = tenCongTy;
        this.tenGiaoDich = tenGiaoDich;
        this.diaChi = diaChi;
        this.email = email;
        this.dienThoai = dienThoai;
        this.fax = fax;
    }

    // Getters
    public String getMaCongTy() {
        return maCongTy;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public String getTenGiaoDich() {
        return tenGiaoDich;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getEmail() {
        return email;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public String getFax() {
        return fax;
    }

    // Bạn có thể thêm Setters nếu cần thiết
}