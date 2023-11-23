package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_Thuonghieu;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author dungn
 */
public class ThuongHieu_repository {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_Thuonghieu> getAllTH() {
        sql = "SELECT IDThuongHieu, MaTH, TenTH FROM ThuongHieu";
        List<Model_Thuonghieu> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_Thuonghieu TH = new Model_Thuonghieu(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                list.add(TH);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Model_Thuonghieu getTenThuongHieu(String ten) {
        sql = "SELECT  * FROM ThuongHieu WHERE TenTH = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_Thuonghieu mdTH = new Model_Thuonghieu(rs.getInt(1), rs.getString(2),
                        rs.getString(3));
                return mdTH;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public int getID(String tenThuongHieu) {
        sql = "SELECT IDThuongHieu FROM ThuongHieu WHERE TenTH = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, tenThuongHieu);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int InsertTH(Model_Thuonghieu ma) {
        sql = "INSERT INTO ThuongHieu(MaTH, TenTH) VALUES (?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma.getMa());
            ps.setString(2, ma.getTenThuongHieu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0;
    }
}
