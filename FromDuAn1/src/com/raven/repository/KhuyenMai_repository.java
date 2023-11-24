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
            ResultSet rs = stm.executeQuery(" SELECT IDKhuyenMai,MaKM,TenKM,SoLuong,HinhThuc,MucGiamGia,ThoiGianBatDau,ThoiGianKetThuc,MoTa,TrangThai,Create_at,Create_by,Update_at,Update_by,Deleted_by FROM KhuyenMai");
            while (rs.next()) {
                int ID = rs.getInt(1);
                String MaKM = rs.getNString(2);
                String TenKM = rs.getNString(3);
                int SoLuong = rs.getInt(4);
                String hinhThuc = rs.getNString(5);
                int mucGiamGia = rs.getInt(6);
                Date thoiGianBatDau = rs.getDate(7);
                Date thoiGianKetThuc = rs.getDate(8);
                String moTa = rs.getNString(9);
                String trangthai = rs.getNString(10);
                Date ngaytao = rs.getDate(11);
                String nguoitao = rs.getNString(12);
                Date ngaysua = rs.getDate(13);
                String nguoisua = rs.getNString(14);
                String nguoixoa = rs.getNString(15);
                lst.add(new KhuyenMai(ID,MaKM, TenKM, SoLuong, hinhThuc, mucGiamGia, thoiGianBatDau, thoiGianKetThuc, moTa, trangthai, ngaytao, nguoitao, ngaysua, nguoisua, nguoixoa));
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
            ResultSet rs = stm.executeQuery(" SELECT IDKhuyenMai,MaKM,TenKM,SoLuong,HinhThuc,MucGiamGia,ThoiGianBatDau,ThoiGianKetThuc,MoTa,TrangThai,Create_at,Create_by,Update_at,Update_by,Deleted_by  FROM KhuyenMai WHERE TrangThai =N'Hết Hạn'");
            while (rs.next()) {
                int ID = rs.getInt(1);
                String MaKM = rs.getNString(2);
                String TenKM = rs.getNString(3);
                int SoLuong = rs.getInt(4);
                String hinhThuc = rs.getNString(5);
                int mucGiamGia = rs.getInt(6);
                Date thoiGianBatDau = rs.getDate(7);
                Date thoiGianKetThuc = rs.getDate(8);
                String moTa = rs.getNString(9);
                String trangthai = rs.getNString(10);
                Date ngaytao = rs.getDate(11);
                String nguoitao = rs.getNString(12);
                Date ngaysua = rs.getDate(13);
                String nguoisua = rs.getNString(14);
                String nguoixoa = rs.getNString(15);
                lst.add(new KhuyenMai(ID, MaKM, TenKM, SoLuong, hinhThuc, mucGiamGia, thoiGianBatDau, thoiGianKetThuc, moTa, trangthai, ngaytao, nguoitao, ngaysua, nguoisua, nguoixoa));
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
            ResultSet rs = stm.executeQuery(" SELECT IDKhuyenMai,MaKM,TenKM,SoLuong,HinhThuc,MucGiamGia,ThoiGianBatDau,ThoiGianKetThuc,MoTa,TrangThai,Create_at,Create_by,Update_at,Update_by,Deleted_by  FROM KhuyenMai WHERE TrangThai =N'Còn Hạn'");
            while (rs.next()) {
                int ID = rs.getInt(1);
                String MaKM = rs.getNString(2);
                String TenKM = rs.getNString(3);
                int SoLuong = rs.getInt(4);
                String hinhThuc = rs.getNString(5);
                int mucGiamGia = rs.getInt(6);
                Date thoiGianBatDau = rs.getDate(7);
                Date thoiGianKetThuc = rs.getDate(8);
                String moTa = rs.getNString(9);
                String trangthai = rs.getNString(10);
                Date ngaytao = rs.getDate(11);
                String nguoitao = rs.getNString(12);
                Date ngaysua = rs.getDate(13);
                String nguoisua = rs.getNString(14);
                String nguoixoa = rs.getNString(15);
                lst.add(new KhuyenMai(ID, MaKM, TenKM, SoLuong, hinhThuc, mucGiamGia, thoiGianBatDau, thoiGianKetThuc, moTa, trangthai, ngaytao, nguoitao, ngaysua, nguoisua, nguoixoa));
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

            String sql = "UPDATE KhuyenMai SET MaKM=?, TenKM= ? ,SoLuong=?,HinhThuc= ?,MucGiamGia=?,ThoiGianBatDau=?,ThoiGianKetThuc=?,MoTa= ?,TrangThai= ?,Create_At=GETDATE(),Create_by= ?,Update_At= GETDATE(),Update_by= ?,Deleted_by=? WHERE IDKhuyenMai=?";

            PreparedStatement stm = conn.prepareStatement(sql); 
            stm.setString(1, km.getMaKM());
            stm.setString(2, km.getTenKM());
            stm.setInt(3, km.getSoLuong());
            stm.setString(4, km.getHinhThuc());
            stm.setInt(5, km.getMucGiamGia());
            stm.setString(6, dateFormat.format(km.getThoiGianBatDau()));
            stm.setString(7, dateFormat.format(km.getThoiGianKetThuc()));
            stm.setString(8, km.getMoTa());
            stm.setString(9, km.getTrangThai());
//            stm.setString(11, dateFormat.format(km.getCreateAt()));
            stm.setString(10, km.getCreateBy());
//            stm.setString(13, dateFormat.format(km.getUpdateAt()));
            stm.setString(11, km.getUpdateBy());
            stm.setString(12, km.getDeletedBy());
                        stm.setInt(13, km.getID());
            stm.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteById(int ID) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "DELETE FROM KhuyenMai WHERE IDKhuyenMai =?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, ID);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
