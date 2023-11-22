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
           ResultSet rs = stm.executeQuery("SELECT ID,MaKM,GiaTriPhanTram,GiaTriTienMat,TrangThai FROM KhuyenMai");
           while (rs.next()) {               
               int ID = rs.getInt(1);
               String MaKM = rs.getString(2);
               String GiaTriPhanTram = rs.getString(3);
               int GiaTriTienMat = rs.getInt(4);
               boolean trangthai = rs.getBoolean(5);
               lst.add(new KhuyenMai(ID, MaKM, GiaTriPhanTram, GiaTriTienMat, trangthai));
               
           }
           rs.close();
       } catch (Exception e) {
       e.printStackTrace();
       }
       return lst;
   } 
}
