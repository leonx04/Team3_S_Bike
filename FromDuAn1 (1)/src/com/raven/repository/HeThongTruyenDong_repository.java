/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_HeThongTruyenDong;
import com.raven.model.Model_HeThongTruyenDong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dungn
 */
public class HeThongTruyenDong_repository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_HeThongTruyenDong> getAllHTTD() {
        sql = "SELECT IDHeThongTruyenDong, MaHTTD, TenHTTD FROM HeThongTruyenDong";
        List<Model_HeThongTruyenDong> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_HeThongTruyenDong HTTD = new Model_HeThongTruyenDong(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                list.add(HTTD);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Model_HeThongTruyenDong getTenLip(String ten) {
        sql = "SELECT * FROM HeThongTruyenDong WHERE TenHTTD = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            while (rs.next()) {
                Model_HeThongTruyenDong mdHTTD = new Model_HeThongTruyenDong(rs.getInt(1),
                        rs.getString(2), rs.getString(3));
                return mdHTTD;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public int InsertHTTD(Model_HeThongTruyenDong ma) {
        sql = "INSERT INTO HeThongTruyenDong(MaHTTD, TenHTTD) VALUES (?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma.getMaHTTD());
            ps.setString(2, ma.getLoaiLip());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public Model_HeThongTruyenDong getByID(int id) {
        sql = "SELECT IDHeThongTruyenDong, MaHTTD, TenHTTD FROM HeThongTruyenDong WHERE IDHeThongTruyenDong = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Model_HeThongTruyenDong mdHTTD = new Model_HeThongTruyenDong(rs.getInt(1),
                        rs.getString(2), rs.getString(3));
                return mdHTTD;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateHTTDByMaGD(Model_HeThongTruyenDong HTTD) {
        sql = "UPDATE HeThongTruyenDong SET TenHTTD = ? WHERE MaHTTD = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, HTTD.getLoaiLip());
            ps.setString(2, HTTD.getMaHTTD());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteHTTDById(String ma) {
        sql = "DELETE FROM HeThongTruyenDong WHERE MaHTTD = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
