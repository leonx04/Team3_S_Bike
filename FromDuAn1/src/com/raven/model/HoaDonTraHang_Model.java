/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.util.Date;

/**
 *
 * @author Thu Phuong
 */
public class HoaDonTraHang_Model {
    private String maHD;
    private String maNV;
    private String tenNN;
    private String SDT;
    private String diaChi;
    private int mucGG;
    private int tongTien;
    private int phiVC;
    private Date ngayTao;
    private String nguoiTao;
    private Date ngaySua;

    public HoaDonTraHang_Model() {
    }

    public HoaDonTraHang_Model(String maHD, String maNV, String tenNN, String SDT, String diaChi, int mucGG, int tongTien, int phiVC, Date ngayTao, String nguoiTao, Date ngaySua) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.tenNN = tenNN;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.mucGG = mucGG;
        this.tongTien = tongTien;
        this.phiVC = phiVC;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.ngaySua = ngaySua;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMucGG() {
        return mucGG;
    }

    public void setMucGG(int mucGG) {
        this.mucGG = mucGG;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getPhiVC() {
        return phiVC;
    }

    public void setPhiVC(int phiVC) {
        this.phiVC = phiVC;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }
    
}
