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
        sql = "SELECT      ID, MaSP, TenSP, MaCode, Model, SoLuong, TrangThai FROM  SanPham";
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

    public Integer insert(Model_SanPham sp) {
        Integer row = null;
        sql = "INSERT INTO SanPham (MaSP, TenSP, MaCode, Model, SoLuong, TrangThai)\n"
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
        sql = " UPDATE SanPham SET TenSP = ?, MaCode = ? , Model = ?, SoLuong =? , TrangThai = ? WHERE MaSP = ? ";
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
