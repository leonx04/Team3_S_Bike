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
public class HoaDon_Model {
    private int STT;
    private String maHD;
    private Date ngayTao;
    private Date ngayThanhToan;
    private int tongTien;
    private String loaiHD;
    private String maNV;
    private String tenKH;
    private String SDT;
    private String trangThai;
    private String tenNN;
    private String tenNV;
    private String hanhDong;
    private String diaChi;
    private int mucGG;
    private int phiVC;
    private String nguoiTao;
    private Date ngaySua;

    public HoaDon_Model() {
    }

    public HoaDon_Model(int STT, String maHD, Date ngayTao, Date ngayThanhToan, int tongTien, String loaiHD, String maNV, String tenKH, String tenNN, String SDT, String trangThai) {
        this.STT = STT;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.loaiHD = loaiHD;
        this.maNV = maNV;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.trangThai = trangThai;
        this.tenNN = tenNN;
        
    }
    
    public HoaDon_Model( String maHD, Date ngayTao, Date ngayThanhToan, int tongTien, String loaiHD, String maNV, String tenKH, String tenNN, String SDT, String trangThai) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.loaiHD = loaiHD;
        this.maNV = maNV;
        this.tenKH = tenKH;
        this.SDT = SDT;
        this.trangThai = trangThai;
        this.tenNN = tenNN;
    }
    
    public HoaDon_Model(Date ngayTao, String maNV, String tenNV, String hanhDong) {
        this.ngayTao = ngayTao;
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.hanhDong = hanhDong;
    }
    
    public HoaDon_Model(String maHD, String maNV, String tenNN, String SDT, String diaChi, int mucGG, int tongTien, int phiVC, Date ngayTao, String nguoiTao, Date ngaySua) {
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
    
    public HoaDon_Model(String maHD, String maNV, String tenKH, String trangThai, Date ngayTao) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.tenKH = tenKH;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public String getLoaiHD() {
        return loaiHD;
    }

    public void setLoaiHD(String loaiHD) {
        this.loaiHD = loaiHD;
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

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getHanhDong() {
        return hanhDong;
    }

    public void setHanhDong(String hanhDong) {
        this.hanhDong = hanhDong;
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

    public int getPhiVC() {
        return phiVC;
    }

    public void setPhiVC(int phiVC) {
        this.phiVC = phiVC;
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
    



    @Override
    public String toString() {
        return "HoaDon_Model{" + "STT=" + STT + ", maHD=" + maHD + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", tongTien=" + tongTien + ", maNV=" + maNV + ", tenKH=" + tenKH + ", SDT=" + SDT + ", trangThai=" + trangThai + ", TenNN=" + tenNN+ '}';
    }
    public Object[] toDataRow(){
        int i=1;
        return new Object[] {i++, this.maHD, this.ngayTao, this.ngayThanhToan, this.tongTien, this.maNV, this.tenKH,this.tenNN, this.SDT, this.trangThai};
    }
}
