/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.connectDB.JdbcHelper;
import com.raven.model.HoaDon_Model;
import com.raven.model.SanPhamModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Thu Phuong
 */
public class HoaDon_reponsitory extends HoaDonInteface<HoaDon_Model, Integer> {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<HoaDon_Model> getAllHD() {
        List<HoaDon_Model> list = new ArrayList<>();
        try {
            sql = "SELECT HoaDon.MaHD, HoaDon.NgayDatHang, HoaDon.NgayGuiHang, HoaDon.TongTien, HinhThucThanhToan.TenHTTT, NhanVien.MaNV, KhachHang.TenKH, HoaDon.TenNguoiNhan, HoaDon.SDTNguoiNhanHang, HoaDon.TrangThai\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             HinhThucThanhToan ON HoaDon.IDHinhThucThanhToan = HinhThucThanhToan.IDHinhThucThanhToan INNER JOIN\n"
                    + "             KhachHang ON HoaDon.IDKhachHang = KhachHang.IDKhachHang INNER JOIN\n"
                    + "             NhanVien ON HoaDon.IDNhanVien = NhanVien.IDNhanVien";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_Model hd = new HoaDon_Model(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                list.add(hd);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HoaDon_Model> getAllDate(String d1, String d2) {
        List<HoaDon_Model> list = new ArrayList<>();
        try {
            sql = "SELECT HoaDon.MaHD, HoaDon.NgayDatHang, HoaDon.NgayNhanHang, HoaDon.TongTien, HinhThucThanhToan.TenHTTT, NhanVien.MaNV, KhachHang.TenKH, HoaDon.TenNguoiNhan, HoaDon.SDTNguoiNhanHang, HoaDon.TrangThai\n"
                    + "FROM   HinhThucThanhToan INNER JOIN\n"
                    + "             HoaDon ON HinhThucThanhToan.IDHinhThucThanhToan = HoaDon.IDHinhThucThanhToan INNER JOIN\n"
                    + "             KhachHang ON HoaDon.IDKhachHang = KhachHang.IDKhachHang INNER JOIN\n"
                    + "             NhanVien ON HoaDon.IDNhanVien = NhanVien.IDNhanVien\n"
                    + "			 where HoaDon.NgayDatHang between ? and ?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, d1);
            ps.setObject(2, d2);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_Model hd = new HoaDon_Model(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                list.add(hd);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HoaDon_Model> getAllGia(int t1, int t2) {
        List<HoaDon_Model> list = new ArrayList<>();
        try {
            sql = "SELECT HoaDon.MaHD, HoaDon.NgayDatHang, HoaDon.NgayNhanHang, HoaDon.TongTien, HinhThucThanhToan.TenHTTT, NhanVien.MaNV, KhachHang.TenKH, HoaDon.TenNguoiNhan, HoaDon.SDTNguoiNhanHang, HoaDon.TrangThai\n"
                    + "FROM   HinhThucThanhToan INNER JOIN\n"
                    + "             HoaDon ON HinhThucThanhToan.IDHinhThucThanhToan = HoaDon.IDHinhThucThanhToan INNER JOIN\n"
                    + "             KhachHang ON HoaDon.IDKhachHang = KhachHang.IDKhachHang INNER JOIN\n"
                    + "             NhanVien ON HoaDon.IDNhanVien = NhanVien.IDNhanVien\n"
                    + "			 where HoaDon.TongTien between ? and ?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, t1);
            ps.setObject(2, t2);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_Model hd = new HoaDon_Model(rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                list.add(hd);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HoaDon_Model> getAllLichSuHD(String maNV) {
        List<HoaDon_Model> list = new ArrayList<>();
        try {
            sql = "SELECT HoaDon.create_at, NhanVien.maNV, NhanVien.tenNV, LichSuGiaoDich.hanhDong\n"
                    + "FROM   hoaDon INNER JOIN\n"
                    + "             LichSuGiaoDich ON HoaDon.IDHoaDon = LichSuGiaoDich.IDHoaDon INNER JOIN\n"
                    + "             NhanVien ON HoaDon.IDNhanVien = NhanVien.IDNhanVien\n"
                    + "where maNV like ?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maNV);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon_Model hd = new HoaDon_Model(rs.getDate(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(hd);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SanPhamModel> getAllHoaDonChiTiet(String ma) {
        List<SanPhamModel> list = new ArrayList<>();
        try {
            sql = "SELECT SanPham.MaSP, SanPham.TenSP, SanPham.SoLuong, ChiTietSanPham.GiaTien\n"
                    + "FROM   ChiTietSanPham INNER JOIN\n"
                    + "             HoaDonChiTiet ON ChiTietSanPham.IDCTSP = HoaDonChiTiet.IDCTSP INNER JOIN\n"
                    + "             HoaDon ON HoaDonChiTiet.IDHoaDon = HoaDon.IDHoaDon INNER JOIN\n"
                    + "             SanPham ON ChiTietSanPham.IDSanPham = SanPham.IDSanPham INNER JOIN\n"
                    + "NhanVien ON HoaDon.IDNhanVien = NhanVien.IDNhanVien\n"
                    + "where maNV = ?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamModel sp = new SanPhamModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                list.add(sp);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SanPhamModel> getSanPham(String ma) {
        List<SanPhamModel> list = new ArrayList<>();
        try {
            sql = "SELECT SanPham.MaSP, SanPham.TenSP, ThuongHieu.TenTH, MauSac.TenMS, SanPham.SoLuong, ChiTietSanPham.GiaTien\n"
                    + "FROM   HoaDon INNER JOIN\n"
                    + "             NhanVien ON HoaDon.IDNhanVien = NhanVien.IDNhanVien INNER JOIN\n"
                    + "             HoaDonChiTiet ON HoaDon.IDHoaDon = HoaDonChiTiet.IDHoaDon INNER JOIN\n"
                    + "             ChiTietSanPham INNER JOIN\n"
                    + "             SanPham ON ChiTietSanPham.IDSanPham = SanPham.IDSanPham ON HoaDonChiTiet.IDCTSP = ChiTietSanPham.IDCTSP INNER JOIN\n"
                    + "             MauSac ON ChiTietSanPham.IDMauSac = MauSac.IDMauSac INNER JOIN\n"
                    + "             ThuongHieu ON ChiTietSanPham.IDThuongHieu = ThuongHieu.IDThuongHieu\n"
                    + "			 where maNV = ?";
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamModel sp = new SanPhamModel(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                list.add(sp);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected List<HoaDon_Model> selectBySql(String sql, Object... args) {
        List<HoaDon_Model> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    HoaDon_Model entity = new HoaDon_Model();
                    entity.setMaHD(rs.getString("maHD"));
                    entity.setMaNV(rs.getString("MaNV"));
                    entity.setTenKH(rs.getString("TenKH"));
                    entity.setTenNN(rs.getString("TenNguoiNhan"));
                    entity.setSDT(rs.getString("SDTNguoiNhanHang"));
                    entity.setDiaChi(rs.getString("DiaChiNhanHang"));
                    entity.setTrangThai(rs.getString("TrangThai"));
                    entity.setMucGG(rs.getInt("MucGiamGia"));
                    entity.setTongTien(rs.getInt("TongTien"));
                    entity.setPhiVC(rs.getInt("PhiVanChuyen"));
                    entity.setNgayTao(rs.getDate("Create_at"));
                    entity.setNgaySua(rs.getDate("Update_at"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

    @Override
    public HoaDon_Model selectById(String maHD) {
        String sql = "SELECT HoaDon.MaHD, NhanVien.MaNV, KhachHang.TenKH, HoaDon.TenNguoiNhan, HoaDon.SDTNguoiNhanHang, HoaDon.DiaChiNhanHang, HoaDon.TrangThai, KhuyenMai.MucGiamGia, HoaDon.TongTien, HoaDon.PhiVanChuyen, HoaDon.Create_at, HoaDon.Update_by, \n"
                + "             HoaDon.Update_at\n"
                + "FROM   HoaDon INNER JOIN\n"
                + "             KhachHang ON HoaDon.IDKhachHang = KhachHang.IDKhachHang INNER JOIN\n"
                + "             KhuyenMai ON HoaDon.IDKhuyenMai = KhuyenMai.IDKhuyenMai INNER JOIN\n"
                + "             NhanVien ON HoaDon.IDNhanVien = NhanVien.IDNhanVien\n"
                + "			 where HoaDon.MaHD = ?";
        List<HoaDon_Model> list = selectBySql(sql, maHD);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HoaDon_Model> selectAll() {
        String sql = "SELECT HoaDon.MaHD, NhanVien.MaNV, KhachHang.TenKH, HoaDon.TenNguoiNhan, HoaDon.SDTNguoiNhanHang, HoaDon.DiaChiNhanHang, HoaDon.TrangThai, KhuyenMai.MucGiamGia, HoaDon.TongTien, HoaDon.PhiVanChuyen, HoaDon.Create_at, HoaDon.Update_by, \n"
                + "             HoaDon.Update_at\n"
                + "FROM   HoaDon INNER JOIN\n"
                + "             KhachHang ON HoaDon.IDKhachHang = KhachHang.IDKhachHang INNER JOIN\n"
                + "             KhuyenMai ON HoaDon.IDKhuyenMai = KhuyenMai.IDKhuyenMai INNER JOIN\n"
                + "             NhanVien ON HoaDon.IDNhanVien = NhanVien.IDNhanVien\n";
        return selectBySql(sql);
    }

}
