/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author dungn
 */
public class Model_LopXe {
    public int ID;
    public String MaLX;
    public String TenLX;

    public Model_LopXe(String MaLX, String TenLX) {
        this.ID = ID;
        this.MaLX = MaLX;
        this.TenLX = TenLX;
    }

    public Model_LopXe() {
    }

    
    public int getID() {
        return ID;
    }

    public String getMaLX() {
        return MaLX;
    }

    public String getTenLX() {
        return TenLX;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMaLX(String MaLX) {
        this.MaLX = MaLX;
    }

    public void setTenLX(String TenLX) {
        this.TenLX = TenLX;
    }

    @Override
    public String toString() {
        return "Model_LopXe{" + "ID=" + ID + ", MaLX=" + MaLX + ", TenLX=" + TenLX + '}';
    }


    
}
