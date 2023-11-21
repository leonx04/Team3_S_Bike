/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_BanhXe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author dungn
 */
public class BanhXe_repository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_BanhXe> getAllBX() {
        sql = "SELECT MaBanhXe, TenBanhXe FROM BanhXe";
        List<Model_BanhXe> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_BanhXe BX = new Model_BanhXe(rs.getString(1),
                        rs.getString(2));
                list.add(BX);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Model_BanhXe getfillTenBanhXe(String ten) {
        sql = "SELECT  * FROM BanhXe WHERE TenBanhXe = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_BanhXe mdTH = new Model_BanhXe(rs.getString(1), rs.getString(2));
                return mdTH;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public int getID(String ten) {
        sql = "SELECT ID FROM BanhXe WHERE TenBanhXe = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
