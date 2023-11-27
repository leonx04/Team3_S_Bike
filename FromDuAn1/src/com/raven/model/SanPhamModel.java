/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author Thu Phuong
 */
public class SanPhamModel {
    private int STT;
    private String maSP;
    private String tenSP;
    private String hinhAnh;
    private int soLuong;
    private int giaTien;
    private String trangthai;
    private String maHex;
    private String model;
    private String thuongHieu;
    private String mauSac;
    

    public SanPhamModel() {
    }

    public SanPhamModel(int STT, String maSP, String tenSP, String hinhAnh, int soLuong, int giaTien, String trangthai, String maHex, String model) {
        this.STT = STT;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.hinhAnh = hinhAnh;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.trangthai = trangthai;
        this.maHex = maHex;
        this.model = model;
    }
    
    public SanPhamModel(String maSP, String tenSP,int soLuong, int giaTien) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }
    
    public SanPhamModel(String maSP, String tenSP,String thuongHieu, String mauSac, int soLuong, int giaTien) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.thuongHieu = thuongHieu;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getMaHex() {
        return maHex;
    }

    public void setMaHex(String maHex) {
        this.maHex = maHex;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    
}
