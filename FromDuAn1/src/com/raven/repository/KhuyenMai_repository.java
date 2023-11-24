/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.swing.KhuyenMai;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author MSI
 */
public class KhuyenMai_repository {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public List<KhuyenMai> getAllKM() {
        List<KhuyenMai> lst = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(" SELECT MaKM,TenKM,SoLuong,HinhThuc,MucGiamGia,ThoiGianBatDau,ThoiGianKetThuc,MoTa,TrangThai,Create_at,Create_by,Update_at,Update_by,Deleted_by FROM KhuyenMai");
            while (rs.next()) {
                String MaKM = rs.getNString(1);
                String TenKM = rs.getNString(2);
                int SoLuong = rs.getInt(3);
                String hinhThuc = rs.getNString(4);
                int mucGiamGia = rs.getInt(5);
                Date thoiGianBatDau = rs.getDate(6);
                Date thoiGianKetThuc = rs.getDate(7);
                String moTa = rs.getNString(8);
                String trangthai = rs.getNString(9);
                Date ngaytao = rs.getDate(10);
                String nguoitao = rs.getNString(11);
                Date ngaysua = rs.getDate(12);
                String nguoisua = rs.getNString(13);
                String nguoixoa = rs.getNString(14);
                lst.add(new KhuyenMai(MaKM, TenKM, SoLuong, hinhThuc, mucGiamGia, thoiGianBatDau, thoiGianKetThuc, moTa, trangthai, ngaytao, nguoitao, ngaysua, nguoisua, nguoixoa));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<KhuyenMai> getAllKMHetHan() {
        List<KhuyenMai> lst = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(" SELECT MaKM,TenKM,SoLuong,HinhThuc,MucGiamGia,ThoiGianBatDau,ThoiGianKetThuc,MoTa,TrangThai,Create_at,Create_by,Update_at,Update_by,Deleted_by  FROM KhuyenMai WHERE TrangThai =N'Hết Hạn'");
            while (rs.next()) {
                String MaKM = rs.getNString(1);
                String TenKM = rs.getNString(2);
                int SoLuong = rs.getInt(3);
                String hinhThuc = rs.getNString(4);
                int mucGiamGia = rs.getInt(5);
                Date thoiGianBatDau = rs.getDate(6);
                Date thoiGianKetThuc = rs.getDate(7);
                String moTa = rs.getNString(8);
                String trangthai = rs.getNString(9);
                Date ngaytao = rs.getDate(10);
                String nguoitao = rs.getNString(11);
                Date ngaysua = rs.getDate(12);
                String nguoisua = rs.getNString(13);
                String nguoixoa = rs.getNString(14);
                lst.add(new KhuyenMai(MaKM, TenKM, SoLuong, hinhThuc, mucGiamGia, thoiGianBatDau, thoiGianKetThuc, moTa, trangthai, ngaytao, nguoitao, ngaysua, nguoisua, nguoixoa));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public List<KhuyenMai> getAllKMconHan() {
        List<KhuyenMai> lst = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(" SELECT MaKM,TenKM,SoLuong,HinhThuc,MucGiamGia,ThoiGianBatDau,ThoiGianKetThuc,MoTa,TrangThai,Create_at,Create_by,Update_at,Update_by,Deleted_by  FROM KhuyenMai WHERE TrangThai =N'Còn Hạn'");
            while (rs.next()) {
                String MaKM = rs.getNString(1);
                String TenKM = rs.getNString(2);
                int SoLuong = rs.getInt(3);
                String hinhThuc = rs.getNString(4);
                int mucGiamGia = rs.getInt(5);
                Date thoiGianBatDau = rs.getDate(6);
                Date thoiGianKetThuc = rs.getDate(7);
                String moTa = rs.getNString(8);
                String trangthai = rs.getNString(9);
                Date ngaytao = rs.getDate(10);
                String nguoitao = rs.getNString(11);
                Date ngaysua = rs.getDate(12);
                String nguoisua = rs.getNString(13);
                String nguoixoa = rs.getNString(14);
                lst.add(new KhuyenMai(MaKM, TenKM, SoLuong, hinhThuc, mucGiamGia, thoiGianBatDau, thoiGianKetThuc, moTa, trangthai, ngaytao, nguoitao, ngaysua, nguoisua, nguoixoa));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }

    public boolean Add(KhuyenMai km) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "INSERT INTO KhuyenMai(MaKM,TenKM,SoLuong,HinhThuc,MucGiamGia,ThoiGianBatDau,ThoiGianKetThuc,MoTa,TrangThai,Create_at,Create_by,Update_at,Update_by,Deleted_by)VALUES(?,?,?,?,?,?,?,?,?,GETDATE(),?,GETDATE(),?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, km.getMaKM());
            stm.setString(2, km.getTenKM());
            stm.setInt(3, km.getSoLuong());
            stm.setString(4, km.getHinhThuc());
            stm.setInt(5, km.getMucGiamGia());
            stm.setString(6, dateFormat.format(km.getThoiGianBatDau()));
            stm.setString(7, dateFormat.format(km.getThoiGianKetThuc()));
            stm.setString(8, km.getMoTa());
            stm.setString(9, km.getTrangThai());
//            stm.setString(10, dateFormat.format(km.getCreateAt()));
            stm.setString(10, km.getCreateBy());
//            stm.setString(12, dateFormat.format(km.getUpdateAt()));
            stm.setString(11, km.getUpdateBy());
            stm.setString(12, km.getDeletedBy());
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(KhuyenMai km) {
        try {
            Connection conn = DBConnect.getConnection();

            String sql = "UPDATE KhuyenMai SET TenKM=?,SoLuong=?,HinhThuc=?,MucGiamGia=?,ThoiGianBatDau=?,ThoiGianKetThuc=?,MoTa=?,TrangThai=?,Create_at=?,Create_by=?,Update_at=?,Update_by=?,Deleted_by=? WHERE MaKM=?";

            PreparedStatement stm = conn.prepareStatement(sql);
//            stm.setString(1, km.getMaKM());
//            stm.setString(2, km.getTenKM());
//            stm.setInt(3, km.getSoLuong());
//            stm.setString(4, km.getHinhThuc());
//            stm.setInt(5, km.getMucGiamGia());
//            stm.setString(6, dateFormat.format(km.getThoiGianBatDau()));
//            stm.setString(7, dateFormat.format(km.getThoiGianKetThuc()));
//            stm.setString(8, km.getMoTa());
//            stm.setString(9, km.getTrangThai());
//            stm.setString(10, dateFormat.format(km.getCreateAt()));
//            stm.setString(11, km.getCreateBy());
//            stm.setString(12, dateFormat.format(km.getUpdateAt()));
//            stm.setString(13, km.getUpdateBy());
//            stm.setString(14, km.getDeletedBy());
//=====
//            stm.setString(1, km.getMaKM());
            stm.setString(2, km.getTenKM());
            stm.setInt(3, km.getSoLuong());
            stm.setString(4, km.getHinhThuc());
            stm.setInt(5, km.getMucGiamGia());
            stm.setString(6, dateFormat.format(km.getThoiGianBatDau()));
            stm.setString(7, dateFormat.format(km.getThoiGianKetThuc()));
            stm.setString(8, km.getMoTa());
            stm.setString(9, km.getTrangThai());
//            stm.setString(10, dateFormat.format(km.getCreateAt()));
            stm.setString(10, km.getCreateBy());
//            stm.setString(12, dateFormat.format(km.getUpdateAt()));
            stm.setString(11, km.getUpdateBy());
            stm.setString(12, km.getDeletedBy());
            stm.executeUpdate();            
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteById(String MaKM) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "DELETE FROM KhuyenMai WHERE MaKM=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, MaKM);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
