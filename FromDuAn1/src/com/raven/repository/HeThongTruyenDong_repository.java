/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
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
        sql = "SELECT MaHTTD, LoaiLip FROM HeThongTruyenDong";
        List<Model_HeThongTruyenDong> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_HeThongTruyenDong HTTD = new Model_HeThongTruyenDong(rs.getString(1),
                        rs.getString(2));
                list.add(HTTD);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Model_HeThongTruyenDong getTenLip(String ten) {
        sql = "SELECT * FROM HeThongTruyenDong WHERE LoaiLip = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            while (rs.next()) {
                Model_HeThongTruyenDong mdHTTD = new Model_HeThongTruyenDong(rs.getString(1), rs.getString(2));
                return mdHTTD;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
