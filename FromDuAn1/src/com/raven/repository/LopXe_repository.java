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
        sql = "SELECT MaLopXe, TenLopXe FROM LopXe";
        List<Model_LopXe> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_LopXe TH = new Model_LopXe(rs.getString(1),
                        rs.getString(2));
                list.add(TH);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Model_LopXe getFilTenLopXe(String ten) {
        sql = "SELECT  * FROM LopXe WHERE TenLopXe = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_LopXe mdLX = new Model_LopXe(rs.getString(1), rs.getString(2));
                return mdLX;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
