/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_MauSac;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author dungn
 */
public class MauSac_repository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_MauSac> getAllMS() {
        sql = "SELECT IDMauSac, MaMS, TenMS FROM MauSac";
        List<Model_MauSac> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_MauSac TH = new Model_MauSac(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                list.add(TH);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Model_MauSac getFillTenMS(String ten) {
        sql = "SELECT  * FROM MauSac WHERE TenMS = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_MauSac mdTH = new Model_MauSac(rs.getString(1), rs.getString(2));
                return mdTH;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public int getID(String tenMS) {
        sql = "SELECT ID FROM MauSac WHERE TenMS = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tenMS);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int InsertMS(Model_MauSac ma) {
        sql = "INSERT INTO MauSac(MaMS, TenMS) VALUES (?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma.getMaMS());
            ps.setString(2, ma.getTenMS());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }
}
