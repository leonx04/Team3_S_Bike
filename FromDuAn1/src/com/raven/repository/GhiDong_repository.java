/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_GhiDong;
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
public class GhiDong_repository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_GhiDong> getAllGD() {
        sql = "SELECT IDGhiDong, MaGD, TenGD FROM GhiDong";
        List<Model_GhiDong> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_GhiDong GD = new Model_GhiDong(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                list.add(GD);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Model_GhiDong getTenGhiDong(String ten) {
        sql = "SELECT  * FROM GhiDong WHERE TenGD = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_GhiDong mdGD = new Model_GhiDong(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                return mdGD;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public int InsertGD(Model_GhiDong ma) {
        sql = "INSERT INTO GhiDong(MaGD, TenGD) VALUES (?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma.getMaGD());
            ps.setString(2, ma.getLoaiGD());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public int updateGhiDongByMaGD(Model_GhiDong ghiDong) {
        sql = "UPDATE GhiDong SET TenGD = ? WHERE MaGD = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ghiDong.getLoaiGD());
            ps.setString(2, ghiDong.getMaGD());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteGhiDongById(String ma) {
        sql = "DELETE FROM GhiDong WHERE MaGD = ?";
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
