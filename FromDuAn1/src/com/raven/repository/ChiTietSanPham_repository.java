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
import com.raven.model.Model_HinhAnhXe;
import com.raven.model.Model_KhungXe;
import com.raven.model.Model_LopXe;
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
        sql = "SELECT    ChiTietSanPham.ID, ChiTietSanPham.MaCTSP, ChiTietSanPham.MauSac, ChiTietSanPham.GiaTien, ThuongHieu.TenThuongHieu, GhiDong.LoaiGhiDong, HeThongTruyenDong.LoaiLip, KhungXe.TenKhungXe, LopXe.TenLopXe, \n"
                + "                         PhanhXe.TenPhanhXe, BanhXe.TenBanhXe, HinhAnhXe.HinhAnh\n"
                + "FROM            SanPham INNER JOIN\n"
                + "                         ChiTietSanPham ON SanPham.ID = ChiTietSanPham.IDSanPham INNER JOIN\n"
                + "                         ThuongHieu ON ChiTietSanPham.IDThuongHieu = ThuongHieu.ID INNER JOIN\n"
                + "                         GhiDong ON ChiTietSanPham.IDGhiDong = GhiDong.ID INNER JOIN\n"
                + "                         HeThongTruyenDong ON ChiTietSanPham.IDHeThongTruyenDong = HeThongTruyenDong.ID INNER JOIN\n"
                + "                         KhungXe ON ChiTietSanPham.IDKhungXe = KhungXe.ID INNER JOIN\n"
                + "                         LopXe ON ChiTietSanPham.IDLopXe = LopXe.ID INNER JOIN\n"
                + "                         PhanhXe ON ChiTietSanPham.IDPhanhXe = PhanhXe.ID INNER JOIN\n"
                + "                         BanhXe ON ChiTietSanPham.IDBanhXe = BanhXe.ID INNER JOIN\n"
                + "                         HinhAnhXe ON ChiTietSanPham.IDHinhAnhXe = HinhAnhXe.ID";
        List<Model_ChiTietSanPham> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Model_Thuonghieu mdTH = new Model_Thuonghieu(null, rs.getString(5));
                Model_GhiDong mdGD = new Model_GhiDong(null, rs.getString(6));
                Model_HeThongTruyenDong mdHTTD = new Model_HeThongTruyenDong(null, rs.getString(7));
                Model_KhungXe mdKX = new Model_KhungXe(null, rs.getString(8));
                Model_LopXe mdLX = new Model_LopXe(null, rs.getString(9));
                Model_PhanhXe mdPX = new Model_PhanhXe(null, rs.getString(10));
                Model_BanhXe mdBX = new Model_BanhXe(null, rs.getString(11));
                Model_HinhAnhXe mdHA = new Model_HinhAnhXe(null, rs.getString(12));
                Model_ChiTietSanPham md_ctsp = new Model_ChiTietSanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBigDecimal(4),
                        mdTH,
                        mdGD,
                        mdHTTD,
                        mdKX,
                        mdLX,
                        mdPX,
                        mdBX,
                        mdHA);
                list.add(md_ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertSP(Model_ChiTietSanPham ma) {
        sql = "INSERT INTO ChiTietSanPham\n"
                + "(MaCTSP, MauSac, GiaTien, IDThuongHieu, IDGhiDong,IDHeThongTruyenDong, IDKhungXe, IDLopXe, IDPhanhXe, IDBanhXe, IDHinhAnhXe)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
//            int idBX = rsBX.getID(ma.getTenBanhXe().getTenBanhXe());
//            int idThuongHieu = rsTH.getID(ma.getThuongHieu().getTenThuongHieu());
//            int idPhanhXe = rsPX.getID(ma.getTenPhanhXe().getTenPhanhXe());
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma.getMaCTSP());
            ps.setObject(2, ma.getMauSac());
            ps.setObject(3, ma.getGiaTien());
            ps.setObject(4, ma.getThuongHieu().getTenThuongHieu());
            ps.setObject(5, ma.getGhiDong().getID());
            ps.setObject(6, ma.getLoaiLip().getID());
            ps.setObject(7, ma.getTenKhungXe().getID());
            ps.setObject(8, ma.getTenLopXe().getID());
            ps.setObject(9, ma.getTenPhanhXe().getID());
            ps.setObject(10, ma.getTenBanhXe().getTenBanhXe());
            ps.setObject(11, ma.getHinhAnhXe().getID());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
}
