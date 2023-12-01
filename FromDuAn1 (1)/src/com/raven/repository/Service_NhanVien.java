/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.raven.model.Model_NhanVien;

/**
 *
 * @author nhdao
 */
public class Service_NhanVien {

    List<Model_NhanVien> listNV = new ArrayList<>();

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    Model_NhanVien nv = null;

    public List<Model_NhanVien> getAll() {
        sql = "Select maNV,tenNV,SoDienThoai,Email,SoCCCD,NgaySinh,GioiTinh,ChucVu,TrangThai from NhanVien";
        List<Model_NhanVien> list_NV = new ArrayList<>();
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new Model_NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(8), rs.getString(9));
                list_NV.add(nv);
            }
            return list_NV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addNV(Model_NhanVien nv) {
        sql = "INSERT INTO NhanVien(maNV,tenNV,SoDienThoai,Email,SoCCCD,NgaySinh,GioiTinh,ChucVu,TrangThai) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getSdt());
            ps.setObject(4, nv.getCccd());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getNgaysinh());
            ps.setObject(7, nv.isGioitinh());
            ps.setObject(8, nv.getChucvu());
            ps.setObject(9, nv.getTrangthai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
        public Model_NhanVien checkTrungMa(String ma) { 
        sql = "SELECT maNV,tenNV,SoDienThoai,Email,SoCCCD,NgaySinh,GioiTinh,ChucVu,TrangThai from NhanVien FROM STUDENTS WHERE maNV = ?";
        Model_NhanVien nv = null;
        try { 
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new Model_NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7), rs.getString(8), rs.getString(9));
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    public int deleteNV(String maNV) {
        sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        try {//xóa được
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, maNV);//? thứ nhất: 1
            ps.executeUpdate();
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
        public int updateNV(String ma, Model_NhanVien nv) {
        sql = "UPDATE NhanVien SET MaNV = ? ,TenNV = ?,SoDienThoai = ?,SoCCCD = ? ,Email = ?,NgaySinh = ?,GioiTinh = ?, ChucVu = ?, TrangThai = ? WHERE MaNV = ?";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getTenNV());
            ps.setObject(3, nv.getSdt());
            ps.setObject(4, nv.getCccd());
            ps.setObject(5, nv.getEmail());
            ps.setObject(6, nv.getNgaysinh());
            ps.setObject(7, nv.isGioitinh());
            ps.setObject(8, nv.getChucvu());
            ps.setObject(9, nv.getTrangthai());
            ps.setObject(10, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}


