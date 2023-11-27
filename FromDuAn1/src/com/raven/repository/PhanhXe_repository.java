package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_PhanhXe;
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
public class PhanhXe_repository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_PhanhXe> getAllPX() {
        sql = "SELECT  IDPhanhXe,MaPX,TenPX FROM PhanhXe";
        List<Model_PhanhXe> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_PhanhXe TH = new Model_PhanhXe(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                list.add(TH);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Model_PhanhXe getFillTenPhanhXe(String ten) {
        sql = "SELECT  * FROM PhanhXe WHERE TenPX  = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_PhanhXe mdPX = new Model_PhanhXe(rs.getString(1), rs.getString(2));
                return mdPX;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public int getID(String tenPhanhXe) {
        sql = "SELECT IDPhanhXe FROM PhanhXe WHERE TenPX = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tenPhanhXe);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Trả về ID tương ứng nếu có
                return rs.getInt("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý ngoại lệ tại đây nếu cần
        }
        return -1;
    }

    public int InsertPX(Model_PhanhXe ma) {
        sql = "INSERT INTO PhanhXe(MaPX,TenPX) VALUES (?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma.getMaPX());
            ps.setString(2, ma.getTenPhanhXe());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }
}
