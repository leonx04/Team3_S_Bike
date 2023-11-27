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
import com.raven.model.Model_SanPham;
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
        sql = "SELECT        ChiTietSanPham.IDCTSP, ChiTietSanPham.MaCTSP, ChiTietSanPham.HinhAnh, ChiTietSanPham.SoLuong, ChiTietSanPham.GiaTien, ThuongHieu.TenTH, MauSac.TenMS, GhiDong.TenGD, KhungXe.TenKX, \n"
                + "                         HeThongTruyenDong.TenHTTD, LopXe.TenLX, PhanhXe.TenPX, BanhXe.TenBX, SanPham.TenSP\n"
                + "FROM            ChiTietSanPham INNER JOIN\n"
                + "                         ThuongHieu ON ChiTietSanPham.IDThuongHieu = ThuongHieu.IDThuongHieu INNER JOIN\n"
                + "                         MauSac ON ChiTietSanPham.IDMauSac = MauSac.IDMauSac INNER JOIN\n"
                + "                         GhiDong ON ChiTietSanPham.IDGhiDong = GhiDong.IDGhiDong INNER JOIN\n"
                + "                         HeThongTruyenDong ON ChiTietSanPham.IDHeThongTruyenDong = HeThongTruyenDong.IDHeThongTruyenDong INNER JOIN\n"
                + "                         KhungXe ON ChiTietSanPham.IDKhungXe = KhungXe.IDKhungXe INNER JOIN\n"
                + "                         LopXe ON ChiTietSanPham.IDLopXe = LopXe.IDLopXe INNER JOIN\n"
                + "                         PhanhXe ON ChiTietSanPham.IDPhanhXe = PhanhXe.IDPhanhXe INNER JOIN\n"
                + "                         BanhXe ON ChiTietSanPham.IDBanhXe = BanhXe.IDBanhXe INNER JOIN\n"
                + "                         SanPham ON ChiTietSanPham.IDSanPham = SanPham.IDSanPham"
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
                Model_HeThongTruyenDong mdHTTD = new Model_HeThongTruyenDong(1,null, rs.getString(9));
                Model_KhungXe mdKX = new Model_KhungXe(null, rs.getString(10));
                Model_LopXe mdLX = new Model_LopXe(null, rs.getString(11));
                Model_PhanhXe mdPX = new Model_PhanhXe(null, rs.getString(12));
                Model_BanhXe mdBX = new Model_BanhXe(null, rs.getString(13));
                Model_SanPham mdSP = new Model_SanPham(null, rs.getString(14));
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
                        mdBX,
                        mdSP);
                list.add(md_ctsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertCTSP(Model_ChiTietSanPham ctSP) {
        String sql = "INSERT INTO ChiTietSanPham (MaCTSP, HinhAnh, SoLuong, GiaTien, TrangThai, IDThuongHieu, IDMauSac, IDGhiDong, IDHeThongTruyenDong, IDKhungXe, IDLopXe, IDPhanhXe, IDBanhXe, IDSanPham, Create_by, Update_at, Update_by, Deleted_by, Create_at) \n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setObject(1, ctSP.getMaCTSP());
            ps.setObject(2, ctSP.getHinhAnhXe());
            ps.setObject(3, ctSP.getSoLuong());
            ps.setObject(4, ctSP.getGiaTien());
            ps.setObject(5, ctSP.getThuongHieu().getId());
            ps.setObject(6, ctSP.getMauSac().getID());
            ps.setObject(7, ctSP.getGhiDong().getID());
            System.out.println("loi la " + ctSP.getGhiDong().getID());
            ps.setObject(8, ctSP.getLoaiLip().getIDHTTD());
            ps.setObject(9, ctSP.getTenKhungXe().getID());
            ps.setObject(10, ctSP.getTenLopXe().getID());
            ps.setObject(11, ctSP.getTenPhanhXe().getID());
            ps.setObject(12, ctSP.getTenBanhXe().getID());
            ps.setObject(13, ctSP.getSanPham().getID());
            ps.setObject(14, "DUNGNX");
            ps.setTimestamp(15, new Timestamp(System.currentTimeMillis()));
            ps.setObject(16, "DUNGNX");
            ps.setObject(17, "");
            ps.setTimestamp(18, new Timestamp(System.currentTimeMillis()));

            // Execute the INSERT statement and return the number of affected rows
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteSP(String maCTSP) {
        String sql = "DELETE FROM ChiTietSanPham WHERE MaCTSP = ?";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maCTSP);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
