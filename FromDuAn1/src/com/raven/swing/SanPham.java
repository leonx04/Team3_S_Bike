/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.swing;

/**
 *
 * @author MSI
 */
public class SanPham {
    String MaSP;
    String Ten;
    String MaCode;
    int soLuong;
    String TrangThai;

    public SanPham() {
    }

    public SanPham(String MaSP, String Ten, String MaCode, int soLuong, String TrangThai) {
        this.MaSP = MaSP;
        this.Ten = Ten;
        this.MaCode = MaCode;
        this.soLuong = soLuong;
        this.TrangThai = TrangThai;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getMaCode() {
        return MaCode;
    }

    public void setMaCode(String MaCode) {
        this.MaCode = MaCode;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
