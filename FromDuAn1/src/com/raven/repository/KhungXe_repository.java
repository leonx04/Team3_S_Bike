/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_KhungXe;
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
public class KhungXe_repository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_KhungXe> getAllKX() {
        sql = "SELECT IDKhungXe,MaKX,TenKX FROM KhungXe";
        List<Model_KhungXe> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_KhungXe KX = new Model_KhungXe(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                list.add(KX);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Model_KhungXe getTenKhungXe(String ten) {
        sql = "SELECT  * FROM KhungXe  WHERE TenKX = ? ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_KhungXe mdkx = new Model_KhungXe(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                return mdkx;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public int InsertKX(Model_KhungXe ma) {
        sql = "INSERT INTO KhungXe(MaKX,TenKX) VALUES (?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma.getMaKX());
            ps.setString(2, ma.getTenKhungXe());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }
}
