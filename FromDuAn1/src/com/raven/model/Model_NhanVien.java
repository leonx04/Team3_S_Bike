/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.sql.Date;

/**
 *
 * @author nhdao
 */
public class Model_NhanVien {
    private String maNV;
    private String tenNV;
    private String sdt;
    private String email;
    private String cccd;
    private String ngaysinh;
    private boolean gioitinh;
    private String chucvu;
    private String trangthai;

    public Model_NhanVien() {
    }

    public Model_NhanVien(String maNV, String tenNV, String sdt, String email, String cccd, String ngaysinh, boolean gioitinh, String chucvu, String trangthai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sdt = sdt;
        this.email = email;
        this.cccd = cccd;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.trangthai = trangthai;
    }

    public Model_NhanVien(String ma, String ten, int sdt, int cccd, String email, String ngaysinh, boolean gioiTinh, String chucvu, String trangthai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
    
}
