/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import java.sql.*;
import com.raven.connectDB.DBConnect;
import com.raven.model.Model_SanPham;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dungn
 */
public class SanPham_responsitory {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_SanPham> getALLSP() {
        sql = "SELECT      IDSanPham, MaSP, TenSP, MaHex, Model, SoLuong, TrangThai FROM  SanPham";
        List<Model_SanPham> listSP = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_SanPham sp = new Model_SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)
                );
                listSP.add(sp);
            }
            return listSP;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Model_SanPham> getALLSPByTrangThai(String trangThai) {
        // Lấy dữ liệu từ cơ sở dữ liệu
        String sql = "SELECT   IDSanPham, MaSP, TenSP, MaHex, Model, SoLuong, TrangThai FROM SanPham WHERE TrangThai = ?";
        List<Model_SanPham> listSP = new ArrayList<>();

        // Xử lý dữ liệu
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, trangThai);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_SanPham sp = new Model_SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)
                );
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        // Trả về kết quả
        return listSP;
    }

    public Model_SanPham getFillTenSP(String ten) {
        sql = "SELECT  * FROM SanPham WHERE TenSP = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_SanPham mdSP = new Model_SanPham(rs.getString(1), rs.getString(2));
                return mdSP;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public Integer insert(Model_SanPham sp) {
        Integer row = null;
        sql = "INSERT INTO SanPham (MaSP, TenSP, MaHex, Model, SoLuong, TrangThai)\n"
                + "VALUES (?,?,?,?,?,?)";
        con = DBConnect.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setString(3, sp.getMaCode());
            ps.setString(4, sp.getModel());
            ps.setInt(5, sp.getSoLuong());
            ps.setString(6, sp.getTrangThai());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public int update(Model_SanPham sp, String ma) {
        sql = " UPDATE SanPham SET TenSP = ?, MaHex = ? , Model = ?, SoLuong =? , TrangThai = ? WHERE MaSP = ? ";
        con = DBConnect.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(6, ma);
            ps.setObject(1, sp.getTenSP());
            ps.setObject(2, sp.getMaCode());
            ps.setObject(3, sp.getModel());
            ps.setObject(4, sp.getSoLuong());
            ps.setObject(5, sp.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int delete(String ma) {
        sql = "DELETE FROM SanPham WHERE MaSP = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public Model_SanPham selecbyMa(String ma) {
        sql = "EXEC TongSoLuongTheoMaSP '?' ";
        List<Model_SanPham> listSL = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_SanPham sp = new Model_SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7)
                );
                listSL.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listSL.get(0);
    }

    public void updateSoLuong(String maSP) {
        String sql = "UPDATE SanPham SET SoLuong ="
                + " (SELECT SUM(SoLuong) FROM ChiTietSanPham WHERE IDSanPham = "
                + " (SELECT IDSanPham FROM SanPham WHERE MaSP = ?))"
                + "WHERE MaSP = ?";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.setString(2, maSP);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
