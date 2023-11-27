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
public class LichSuHD_Model {
    private int STT;
    private String tenNV;
    private String maNV;
    private String tenKH;
    private int tongTien;
    private Date ngayTao;
    private String nguoiNhanHang;
    private String trangThai;

    public LichSuHD_Model() {
    }

    public LichSuHD_Model(int STT, String tenNV, String maNV, String tenKH, int tongTien, Date ngayTao, String nguoiNhanHang, String trangThai) {
        this.STT = STT;
        this.tenNV = tenNV;
        this.maNV = maNV;
        this.tenKH = tenKH;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.nguoiNhanHang = nguoiNhanHang;
        this.trangThai = trangThai;
    }
    
    public LichSuHD_Model(String tenNV, String maNV, String tenKH, int tongTien, Date ngayTao, String nguoiNhanHang, String trangThai) {
        this.tenNV = tenNV;
        this.maNV = maNV;
        this.tenKH = tenKH;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.nguoiNhanHang = nguoiNhanHang;
        this.trangThai = trangThai;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getnguoiNhanHang() {
        return nguoiNhanHang;
    }

    public void setnguoiNhanHang(String nguoiNhanHang) {
        this.nguoiNhanHang = nguoiNhanHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}
