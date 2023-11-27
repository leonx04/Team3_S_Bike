/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_LopXe;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author dungn
 */
public class LopXe_repository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_LopXe> getAllLX() {
        sql = "SELECT IDLopXe,MaLX,TenLX FROM LopXe";
        List<Model_LopXe> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_LopXe TH = new Model_LopXe(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                list.add(TH);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Model_LopXe getFilTenLopXe(String ten) {
        sql = "SELECT  * FROM LopXe WHERE TenLX = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_LopXe mdLX = new Model_LopXe(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                return mdLX;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public int InsertLX(Model_LopXe ma) {
        sql = "INSERT INTO LopXe(MaLX,TenLX) VALUES (?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma.getMaLX());
            ps.setString(2, ma.getTenLX());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }

    public int updateLopXeByMaGD(Model_LopXe ghiDong) {
        sql = "UPDATE LopXe SET TenLX = ? WHERE MaLX = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ghiDong.getTenLX());
            ps.setString(2, ghiDong.getMaLX());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteLopXeById(String ma) {
        sql = "DELETE FROM LopXe WHERE MaLX = ?";
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
