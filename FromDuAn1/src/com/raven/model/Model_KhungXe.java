/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author dungn
 */
public class Model_KhungXe {
    public int ID;
    public String MaKX;
    public String TenKhungXe;

    public Model_KhungXe(String MaKX, String TenKhungXe) {
        this.ID = ID;
        this.MaKX = MaKX;
        this.TenKhungXe = TenKhungXe;
    }

    public Model_KhungXe() {
    }

    
    
    public int getID() {
        return ID;
    }

    public String getMaKX() {
        return MaKX;
    }

    public String getTenKhungXe() {
        return TenKhungXe;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMaKX(String MaKX) {
        this.MaKX = MaKX;
    }

    public void setTenKhungXe(String TenKhungXe) {
        this.TenKhungXe = TenKhungXe;
    }

    @Override
    public String toString() {
        return "Model_KhungXe{" + "ID=" + ID + ", MaKX=" + MaKX + ", TenKhungXe=" + TenKhungXe + '}';
    }


    
}
