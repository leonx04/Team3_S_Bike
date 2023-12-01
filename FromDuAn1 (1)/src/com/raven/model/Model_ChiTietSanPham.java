/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author dungn
 */
public class Model_ChiTietSanPham {

    public Object[] toData2() {
        return new Object[]{
            this.ID, this.MaCTSP, this.HinhAnhXe, this.SoLuong, this.giaTien, this.thuongHieu.getTenThuongHieu(), this.MauSac.getTenMS(), this.ghiDong.getLoaiGD(), this.TenKhungXe.getTenKhungXe(),this.LoaiLip.getLoaiLip(),  this.TenLopXe.getTenLX(), this.TenPhanhXe.getTenPhanhXe(), this.TenBanhXe.getTenBanhXe(), this.SanPham.getTenSP()
        };
    }

    public Model_ChiTietSanPham() {
    }

    public long ID;
    public String MaCTSP;
    public String HinhAnhXe;
    public int SoLuong;
    public BigDecimal giaTien;
    public String TrangThai;
    public Model_Thuonghieu thuongHieu = new Model_Thuonghieu();
    public Model_MauSac MauSac = new Model_MauSac();
    public Model_GhiDong ghiDong = new Model_GhiDong();
    public Model_HeThongTruyenDong LoaiLip = new Model_HeThongTruyenDong();
    public Model_KhungXe TenKhungXe = new Model_KhungXe();
    public Model_LopXe TenLopXe = new Model_LopXe();
    public Model_PhanhXe TenPhanhXe = new Model_PhanhXe();
    public Model_BanhXe TenBanhXe = new Model_BanhXe();
    public Model_SanPham SanPham = new Model_SanPham();
    public String Create_by;
    private Date Update_at;
    public String Update_by;
    public String Deleted_by;
    private Date Create_at;

    public Model_ChiTietSanPham(long ID, String MaCTSP, String HinhAnhXe, int SoLuong, BigDecimal giaTien, String TrangThai, String Create_by, Date Update_at, String Update_by, String Deleted_by, Date Create_at) {
        this.ID = ID;
        this.MaCTSP = MaCTSP;
        this.HinhAnhXe = HinhAnhXe;
        this.SoLuong = SoLuong;
        this.giaTien = giaTien;
        this.TrangThai = TrangThai;
        this.Create_by = Create_by;
        this.Update_at = Update_at;
        this.Update_by = Update_by;
        this.Deleted_by = Deleted_by;
        this.Create_at = Create_at;
    }

    
    
    public long getID() {
        return ID;
    }

    public String getMaCTSP() {
        return MaCTSP;
    }

    public String getHinhAnhXe() {
        return HinhAnhXe;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public BigDecimal getGiaTien() {
        return giaTien;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public Model_Thuonghieu getThuongHieu() {
        return thuongHieu;
    }

    public Model_MauSac getMauSac() {
        return MauSac;
    }

    public Model_GhiDong getGhiDong() {
        return ghiDong;
    }

    public Model_HeThongTruyenDong getLoaiLip() {
        return LoaiLip;
    }

    public Model_KhungXe getTenKhungXe() {
        return TenKhungXe;
    }

    public Model_LopXe getTenLopXe() {
        return TenLopXe;
    }

    public Model_PhanhXe getTenPhanhXe() {
        return TenPhanhXe;
    }

    public Model_BanhXe getTenBanhXe() {
        return TenBanhXe;
    }

    public Model_SanPham getSanPham() {
        return SanPham;
    }

    public String getCreate_by() {
        return Create_by;
    }

    public Date getUpdate_at() {
        return Update_at;
    }

    public String getUpdate_by() {
        return Update_by;
    }

    public String getDeleted_by() {
        return Deleted_by;
    }

    public Date getCreate_at() {
        return Create_at;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setMaCTSP(String MaCTSP) {
        this.MaCTSP = MaCTSP;
    }

    public void setHinhAnhXe(String HinhAnhXe) {
        this.HinhAnhXe = HinhAnhXe;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setGiaTien(BigDecimal giaTien) {
        this.giaTien = giaTien;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public void setThuongHieu(Model_Thuonghieu thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public void setMauSac(Model_MauSac MauSac) {
        this.MauSac = MauSac;
    }

    public void setGhiDong(Model_GhiDong ghiDong) {
        this.ghiDong = ghiDong;
    }

    public void setLoaiLip(Model_HeThongTruyenDong LoaiLip) {
        this.LoaiLip = LoaiLip;
    }

    public void setTenKhungXe(Model_KhungXe TenKhungXe) {
        this.TenKhungXe = TenKhungXe;
    }

    public void setTenLopXe(Model_LopXe TenLopXe) {
        this.TenLopXe = TenLopXe;
    }

    public void setTenPhanhXe(Model_PhanhXe TenPhanhXe) {
        this.TenPhanhXe = TenPhanhXe;
    }

    public void setTenBanhXe(Model_BanhXe TenBanhXe) {
        this.TenBanhXe = TenBanhXe;
    }

    public void setSanPham(Model_SanPham SanPham) {
        this.SanPham = SanPham;
    }

    public void setCreate_by(String Create_by) {
        this.Create_by = Create_by;
    }

    public void setUpdate_at(Date Update_at) {
        this.Update_at = Update_at;
    }

    public void setUpdate_by(String Update_by) {
        this.Update_by = Update_by;
    }

    public void setDeleted_by(String Deleted_by) {
        this.Deleted_by = Deleted_by;
    }

    public void setCreate_at(Date Create_at) {
        this.Create_at = Create_at;
    }

//    public Model_ChiTietSanPham(long ID, String MaCTSP, String HinhAnhXe, int SoLuong, BigDecimal giaTien, Model_Thuonghieu thuongHieu, Model_MauSac MauSac, Model_GhiDong ghiDong, Model_HeThongTruyenDong LoaiLip, Model_KhungXe TenKhungXe, Model_LopXe TenLopXe, Model_PhanhXe TenPhanhXe, Model_BanhXe TenBanhXe) {
//        this.ID = ID;
//        this.MaCTSP = MaCTSP;
//        this.HinhAnhXe = HinhAnhXe;
//        this.SoLuong = SoLuong;
//        this.giaTien = giaTien;
//        this.thuongHieu = thuongHieu;
//        this.MauSac = MauSac;
//        this.ghiDong = ghiDong;
//        this.LoaiLip = LoaiLip;
//        this.TenKhungXe = TenKhungXe;
//        this.TenLopXe = TenLopXe;
//        this.TenPhanhXe = TenPhanhXe;
//        this.TenBanhXe = TenBanhXe;
//    }
    
    public Model_ChiTietSanPham(long ID, String MaCTSP, String HinhAnhXe, int SoLuong, BigDecimal giaTien, Model_Thuonghieu thuongHieu, Model_MauSac MauSac, Model_GhiDong ghiDong, Model_HeThongTruyenDong LoaiLip, Model_KhungXe TenKhungXe, Model_LopXe TenLopXe, Model_PhanhXe TenPhanhXe, Model_BanhXe TenBanhXe, Model_SanPham SanPham) {
        this.ID = ID;
        this.MaCTSP = MaCTSP;
        this.HinhAnhXe = HinhAnhXe;
        this.SoLuong = SoLuong;
        this.giaTien = giaTien;
        this.thuongHieu = thuongHieu;
        this.MauSac = MauSac;
        this.ghiDong = ghiDong;
        this.LoaiLip = LoaiLip;
        this.TenKhungXe = TenKhungXe;
        this.TenLopXe = TenLopXe;
        this.TenPhanhXe = TenPhanhXe;
        this.TenBanhXe = TenBanhXe;
        this.SanPham = SanPham;
    }

    @Override
    public String toString() {
        return "Model_ChiTietSanPham{" + "ID=" + ID + ", MaCTSP=" + MaCTSP + ", HinhAnhXe=" + HinhAnhXe + ", SoLuong=" + SoLuong + ", giaTien=" + giaTien + ", thuongHieu=" + thuongHieu + ", MauSac=" + MauSac + ", ghiDong=" + ghiDong + ", LoaiLip=" + LoaiLip + ", TenKhungXe=" + TenKhungXe + ", TenLopXe=" + TenLopXe + ", TenPhanhXe=" + TenPhanhXe + ", TenBanhXe=" + TenBanhXe + '}';
    }

}
