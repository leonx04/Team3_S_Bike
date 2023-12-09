/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.HoaDon_Model;
import com.raven.model.LichSuHD_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thu Phuong
 */
public class LichSuHD_responsitory {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<LichSuHD_Model> getAllHD() {
        List<LichSuHD_Model> list = new ArrayList<>();
        try {
            sql = "SELECT NhanVien.MaNV, NhanVien.TenNV, KhachHang.TenKH, HoaDon.TongTien, HoaDon.create_at, HoaDon.TenNguoiNhan, LichSuGiaoDich.TrangThai\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             KhachHang ON HoaDon.IDKhachHang = KhachHang.ID INNER JOIN\n"
                    + "             LichSuGiaoDich ON HoaDon.ID = LichSuGiaoDich.IDHoaDon INNER JOIN\n"
                    + "             NhanVien ON HoaDon.IDNhanVien = NhanVien.ID\n"
                    + "			 where LichSuGiaoDich.TrangThai like N'Đã thanh toán'";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                LichSuHD_Model lsgd = new LichSuHD_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7));
                list.add(lsgd);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
