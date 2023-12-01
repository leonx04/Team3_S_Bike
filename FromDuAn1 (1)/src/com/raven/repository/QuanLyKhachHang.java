/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_KhachHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author VanHieu
 */
public class QuanLyKhachHang {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql="select IDKhachHang,makh,tenkh,sdt,email,diachi,ngaysinh,trangthai from KhachHang";

    public List<Model_KhachHang> getAll() {
        List<Model_KhachHang> listKH = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_KhachHang KH = new Model_KhachHang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
                listKH.add(KH);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public int addNV(Model_KhachHang kh) {
        sql = "insert into khachhang(makh,tenkh,sdt,email,diachi,ngaysinh,trangthai) values (?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getMakh());
            ps.setObject(2, kh.getTenKH());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.getEmail());
            ps.setObject(5, kh.getDiachi());
            ps.setObject(6, kh.getNgaysinh());
            ps.setObject(7, kh.getTrangthai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String MaKH) {
        sql = "delete KhachHang where MaKH = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, MaKH);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Model_KhachHang kh, String MaKH) {
        sql = "update KhachHang set tenkh = ?, sdt = ?, email=?, diachi = ?,ngaysinh=?, trangthai = ? where MaKH = ? ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, kh.getTenKH());
            ps.setObject(2, kh.getSdt());
            ps.setObject(3, kh.getEmail());
            ps.setObject(4, kh.getDiachi());
            ps.setObject(5, kh.getNgaysinh());
            ps.setObject(6, kh.getTrangthai());
            ps.setObject(7, MaKH);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

     public  List<Model_KhachHang> TimKiem(String MaKH) {
        List<Model_KhachHang> listkh = new ArrayList<>();
        try {
            sql ="select id,makh,tenkh,sdt,email,diachi,ngaysinh,trangthai from KhachHang where MaSV like'&"+MaKH+"&' ";
            con = ps.getConnection();
            rs = ps.executeQuery();
            while(rs.next()){
                Model_KhachHang kh = new Model_KhachHang();
                kh.setId(rs.getInt(1));
                kh.setMakh(rs.getString(2));
                kh.setTenKH(rs.getString(3));
                kh.setSdt(rs.getString(4));
                kh.setEmail(rs.getString(5));
                kh.setDiachi(rs.getString(6));
                kh.setNgaysinh(rs.getString(7));
                kh.setTrangthai(rs.getString(8));
                listkh.add(kh);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                rs.close(); ps.close(); con.close();
            } catch (Exception e) {
            }
        }
        return listkh;
}
     public Model_KhachHang checkTrungMa(String ma) { 
        sql = "select id,makh,tenkh,sdt,email,diachi,ngaysinh,trangthai from KhachHang where maKH = ?";
        Model_KhachHang kh = null;
        try { 
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                kh = new Model_KhachHang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      public boolean isMaKhachHangDuplicated(String maKhachHang) {
        String query = "SELECT COUNT(*) FROM KhachHang WHERE MaKH = ?";
        
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, maKhachHang);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
