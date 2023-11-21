/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.math.BigDecimal;

/**
 *
 * @author dungn
 */
public class Model_ChiTietSanPham {

    public Object[] toData2() {
        return new Object[]{
            this.ID, this.MaCTSP, this.MauSac, this.giaTien, this.thuongHieu.getTenThuongHieu(), this.ghiDong.getLoaiGD(), this.LoaiLip.getLoaiLip(), this.TenKhungXe.getTenKhungXe(), this.TenLopXe.getTenLX(), this.TenPhanhXe.getTenPhanhXe(), this.TenBanhXe.getTenBanhXe(), this.HinhAnhXe.getHinhAnh()
        };
    }

    public Model_ChiTietSanPham() {
    }

    public long ID;
    public String MaCTSP;
    public String MauSac;
    public Model_Thuonghieu thuongHieu = new Model_Thuonghieu();
    public BigDecimal giaTien;
    public Model_GhiDong ghiDong = new Model_GhiDong();
    public Model_HeThongTruyenDong LoaiLip = new Model_HeThongTruyenDong();
    public Model_KhungXe TenKhungXe = new Model_KhungXe();
    public Model_LopXe TenLopXe = new Model_LopXe();
    public Model_PhanhXe TenPhanhXe = new Model_PhanhXe();
    public Model_BanhXe TenBanhXe = new Model_BanhXe();
    public Model_HinhAnhXe HinhAnhXe = new Model_HinhAnhXe();

    public Model_ChiTietSanPham(long ID, String MaCTSP, String MauSac, BigDecimal giaTien, Model_Thuonghieu thuongHieu, Model_GhiDong ghiDong, Model_HeThongTruyenDong LoaiLip, Model_KhungXe TenKhungXe, Model_LopXe TenLopXe, Model_PhanhXe TenPhanhXe, Model_BanhXe TenBanhXe, Model_HinhAnhXe HinhAnhXe) {
        this.ID = ID;
        this.MaCTSP = MaCTSP;
        this.MauSac = MauSac;
        this.thuongHieu = thuongHieu;
        this.giaTien = giaTien;
        this.ghiDong = ghiDong;
        this.LoaiLip = LoaiLip;
        this.TenKhungXe = TenKhungXe;
        this.TenLopXe = TenLopXe;
        this.TenPhanhXe = TenPhanhXe;
        this.TenBanhXe = TenBanhXe;
        this.HinhAnhXe = HinhAnhXe;
    }

    public long getID() {
        return ID;
    }

    public String getMaCTSP() {
        return MaCTSP;
    }

    public String getMauSac() {
        return MauSac;
    }

    public Model_Thuonghieu getThuongHieu() {
        return thuongHieu;
    }

    public BigDecimal getGiaTien() {
        return giaTien;
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

    public Model_HinhAnhXe getHinhAnhXe() {
        return HinhAnhXe;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setMaCTSP(String MaCTSP) {
        this.MaCTSP = MaCTSP;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public void setThuongHieu(Model_Thuonghieu thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public void setGiaTien(BigDecimal giaTien) {
        this.giaTien = giaTien;
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

    public void setHinhAnhXe(Model_HinhAnhXe HinhAnhXe) {
        this.HinhAnhXe = HinhAnhXe;
    }

    @Override
    public String toString() {
        return "Model_ChiTietSanPham{" + "ID=" + ID + ", MaCTSP=" + MaCTSP + ", MauSac=" + MauSac + ", thuongHieu=" + thuongHieu + ", giaTien=" + giaTien + ", ghiDong=" + ghiDong + ", LoaiLip=" + LoaiLip + ", TenKhungXe=" + TenKhungXe + ", TenLopXe=" + TenLopXe + ", TenPhanhXe=" + TenPhanhXe + ", TenBanhXe=" + TenBanhXe + ", HinhAnhXe=" + HinhAnhXe + '}';
    }

}
