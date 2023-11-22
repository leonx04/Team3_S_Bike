/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.repository;

import com.raven.connectDB.DBConnect;
import com.raven.swing.KhuyenMai;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author MSI
 */
public class KhuyenMai_repository {
   public List<KhuyenMai> getAllKM(){
       List<KhuyenMai>lst = new ArrayList<>();
       try {
           Connection con = DBConnect.getConnection();
           Statement stm = con.createStatement();
           ResultSet rs = stm.executeQuery("SELECT ID,MaKM,GiaTriPhanTram,GiaTriTienMat,TrangThai,NgayKetThuc,NgayBatDau,create_at,create_by,update_at,update_by,Deleted_by FROM KhuyenMai");
           while (rs.next()) {               
               int ID = rs.getInt(1);
               String MaKM = rs.getString(2);
               String GiaTriPhanTram = rs.getString(3);
               int GiaTriTienMat = rs.getInt(4);
               String trangthai = rs.getString(5);
               String ngaybatdau =rs.getString(6);
               String ngayketthuc =rs.getString(7);
               String ngaytao = rs.getString(8);
               String nguoitao = rs.getString(9);
               String nguoisua = rs.getString(10);
               String ngaysua = rs.getString(11);
               String nguoixoa = rs.getString(12);                  
               lst.add(new KhuyenMai(ID, MaKM, GiaTriPhanTram, GiaTriTienMat, trangthai,ngaybatdau,ngayketthuc,ngaysua,ngaytao,nguoisua,nguoitao,nguoixoa));   
           }
           rs.close();
       } catch (Exception e) {
       e.printStackTrace();
       }
       return lst;
   }
   public boolean Delete(String MaKM){
        List<KhuyenMai>lst = new ArrayList<>();
        try {
           Connection con = DBConnect.getConnection();
           String sql ="DELETE FROM KHUYENMAI WHERE MaMK=?";
           PreparedStatement stm = con.prepareCall(sql);
           stm.setString(1, sql);
           stm.executeUpdate();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
   }
}
