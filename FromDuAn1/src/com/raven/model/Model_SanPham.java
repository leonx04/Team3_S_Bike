/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author dungn
 */
public class Model_SanPham {

    public Model_SanPham(long ID, String maSP, String tenSP, String maCode, String Model, int SoLuong, String TrangThai) {
        this.ID = ID;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maCode = maCode;
        this.Model = Model;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
    }

    public Model_SanPham(String maSP, String tenSP, String maCode, String Model, int SoLuong, String TrangThai) {

        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maCode = maCode;
        this.Model = Model;
        this.SoLuong = SoLuong;
        this.TrangThai = TrangThai;
    }

    public Model_SanPham(String maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    
    public long getID() {
        return ID;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getMaCode() {
        return maCode;
    }

    public String getModel() {
        return Model;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setMaCode(String maCode) {
        this.maCode = maCode;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "Model_SanPham{" + "ID=" + ID + ", maSP=" + maSP + ", tenSP=" + tenSP + ", maCode=" + maCode + ", Model=" + Model + ", SoLuong=" + SoLuong + ", TrangThai=" + TrangThai + '}';
    }

    public long ID;
    public String maSP;
    public String tenSP;
    public String maCode;
    public String Model;
    public int SoLuong;
    public String TrangThai;

    public Model_SanPham() {
    }

    public Object[] toData() {
        return new Object[]{
            this.ID,
            this.maSP,
            this.tenSP,
            this.maCode,
            this.Model,
            this.SoLuong,
            this.TrangThai
        };
    }
}
