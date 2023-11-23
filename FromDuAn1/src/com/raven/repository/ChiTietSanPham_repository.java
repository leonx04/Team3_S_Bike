/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.model.Model_BanhXe;
import com.raven.model.Model_ChiTietSanPham;
import com.raven.model.Model_GhiDong;
import com.raven.model.Model_HeThongTruyenDong;
import com.raven.model.Model_KhungXe;
import com.raven.model.Model_LopXe;
import com.raven.model.Model_MauSac;
import com.raven.model.Model_PhanhXe;
import com.raven.model.Model_Thuonghieu;
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
public class ChiTietSanPham_repository {

    private BanhXe_repository rsBX = new BanhXe_repository();
    private ThuongHieu_repository rsTH = new ThuongHieu_repository();
    private PhanhXe_repository rsPX = new PhanhXe_repository();

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Model_ChiTietSanPham> getALLCTSP() {
        sql = "SELECT        ChiTietSanPham.IDCTSP, ChiTietSanPham.MaCTSP, \n"
                + "ChiTietSanPham.HinhAnh, \n"
                + "ChiTietSanPham.SoLuong,\n"
                + "ChiTietSanPham.GiaTien, \n"
                + "ThuongHieu.TenTH, \n"
                + "MauSac.TenMS, \n"
                + "GhiDong.TenGD, \n"
                + "HeThongTruyenDong.TenHTTD, \n"
                + "KhungXe.TenKX, \n"
                + "LopXe.TenLX, \n"
                + "PhanhXe.TenPX, \n"
                + "BanhXe.TenBX\n"
                + "FROM            ChiTietSanPham INNER JOIN\n"
                + "                         ThuongHieu ON ChiTietSanPham.IDThuongHieu = ThuongHieu.IDThuongHieu INNER JOIN\n"
                + "                         MauSac ON ChiTietSanPham.IDMauSac = MauSac.IDMauSac INNER JOIN\n"
                + "                         GhiDong ON ChiTietSanPham.IDGhiDong = GhiDong.IDGhiDong INNER JOIN\n"
                + "                         HeThongTruyenDong ON ChiTietSanPham.IDHeThongTruyenDong = HeThongTruyenDong.IDHeThongTruyenDong INNER JOIN\n"
                + "                         KhungXe ON ChiTietSanPham.IDKhungXe = KhungXe.IDKhungXe INNER JOIN\n"
                + "                         LopXe ON ChiTietSanPham.IDLopXe = LopXe.IDLopXe INNER JOIN\n"
                + "                         PhanhXe ON ChiTietSanPham.IDPhanhXe = PhanhXe.IDPhanhXe INNER JOIN\n"
                + "                         BanhXe ON ChiTietSanPham.IDBanhXe = BanhXe.IDBanhXe\n"
                + "";
        List<Model_ChiTietSanPham> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_Thuonghieu mdTH = new Model_Thuonghieu(null, rs.getString(6));
                Model_MauSac mdMS = new Model_MauSac(null, rs.getString(7));
                Model_GhiDong mdGD = new Model_GhiDong(null, rs.getString(8));
                Model_HeThongTruyenDong mdHTTD = new Model_HeThongTruyenDong(null, rs.getString(9));
                Model_KhungXe mdKX = new Model_KhungXe(null, rs.getString(10));
                Model_LopXe mdLX = new Model_LopXe(null, rs.getString(11));
                Model_PhanhXe mdPX = new Model_PhanhXe(null, rs.getString(12));
                Model_BanhXe mdBX = new Model_BanhXe(null, rs.getString(13));
                Model_ChiTietSanPham md_ctsp = new Model_ChiTietSanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getBigDecimal(5),
                        mdTH,
                        mdMS,
                        mdGD,
                        mdHTTD,
                        mdKX,
                        mdLX,
                        mdPX,
                        mdBX
                );
                list.add(md_ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertSP(Model_ChiTietSanPham ma) {
        sql = "INSERT INTO ChiTietSanPham "
                + "(MaCTSP, HinhAnh, SoLuong, GiaTien, IDThuongHieu, IDMauSac, IDGhiDong, IDHeThongTruyenDong, IDKhungXe, IDLopXe, IDPhanhXe, IDBanhXe) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma.getMaCTSP());
            ps.setObject(2, ma.getHinhAnhXe());
            ps.setObject(3, ma.getSoLuong());
            ps.setObject(4, ma.getGiaTien());
            ps.setObject(5, ma.getThuongHieu().getId());
            ps.setObject(6, ma.getMauSac().getID());
            ps.setObject(7, ma.getGhiDong().getID());
            System.err.println("đã chạy qua");
            ps.setObject(8, ma.getLoaiLip().getID());
            System.out.println("1"+ma.getLoaiLip().getID());
            ps.setObject(9, ma.getTenKhungXe().getID());
            ps.setObject(10, ma.getTenLopXe().getID());
            ps.setObject(11, ma.getTenPhanhXe().getID());
            ps.setObject(12, ma.getTenBanhXe().getID());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
