/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_HinhAnhXe;
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
public class HinhAnh_repository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_HinhAnhXe> getAllHA() {
        sql = "SELECT MaHinhAnh, HinhAnh FROM HinhAnhXe";
        List<Model_HinhAnhXe> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_HinhAnhXe HA = new Model_HinhAnhXe(rs.getString(1), rs.getString(2));
                list.add(HA);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Model_HinhAnhXe getTenHinhAnh(String ten) {
        sql = "SELECT * FROM HinhAnhXe WHERE HinhAnh = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_HinhAnhXe mdHA = new Model_HinhAnhXe(rs.getString(1), rs.getString(2));
                return mdHA;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
