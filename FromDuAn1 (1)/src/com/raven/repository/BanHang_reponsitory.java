/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_SanPham;
import com.raven.model.Model_SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thu Phuong
 */
public class BanHang_reponsitory {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
//    public List<Model_SanPham> getAllSanPham() {
//        List<Model_SanPham> list = new ArrayList<>();
//        try {
//            sql = "SELECT SanPham.MaSP, SanPham.TenSP, ThuongHieu.TenTH, MauSac.TenMS, SanPham.SoLuong, ChiTietSanPham.GiaTien\n"
//                    + "FROM   HoaDon INNER JOIN\n"
//                    + "             NhanVien ON HoaDon.IDNhanVien = NhanVien.IDNhanVien INNER JOIN\n"
//                    + "             HoaDonChiTiet ON HoaDon.IDHoaDon = HoaDonChiTiet.IDHoaDon INNER JOIN\n"
//                    + "             ChiTietSanPham INNER JOIN\n"
//                    + "             SanPham ON ChiTietSanPham.IDSanPham = SanPham.IDSanPham ON HoaDonChiTiet.IDCTSP = ChiTietSanPham.IDCTSP INNER JOIN\n"
//                    + "             MauSac ON ChiTietSanPham.IDMauSac = MauSac.IDMauSac INNER JOIN\n"
//                    + "             ThuongHieu ON ChiTietSanPham.IDThuongHieu = ThuongHieu.IDThuongHieu";
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                Model_SanPham sp = new Model_SanPham(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
//                list.add(sp);
//            }
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//    
//    public List<SanPhamModel> getGioHang(String ma) {
//        List<SanPhamModel> list = new ArrayList<>();
//        try {
//            sql = "SELECT SanPham.MaSP, SanPham.TenSP, SanPham.SoLuong, ChiTietSanPham.GiaTien\n"
//                    + "FROM   ChiTietSanPham INNER JOIN\n"
//                    + "             HoaDonChiTiet ON ChiTietSanPham.IDCTSP = HoaDonChiTiet.IDCTSP INNER JOIN\n"
//                    + "             HoaDon ON HoaDonChiTiet.IDHoaDon = HoaDon.IDHoaDon INNER JOIN\n"
//                    + "             SanPham ON ChiTietSanPham.IDSanPham = SanPham.IDSanPham INNER JOIN\n"
//                    + "NhanVien ON HoaDon.IDNhanVien = NhanVien.IDNhanVien\n"
//                    + "where MaSP = ?";
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, ma);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                SanPhamModel sp = new SanPhamModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
//                list.add(sp);
//            }
//            rs.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//    
//    public int deleteGioHang(String ma) {
//        sql = "delete from xemay where ma = ?";
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, ma);
//            return ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
    
    
}
