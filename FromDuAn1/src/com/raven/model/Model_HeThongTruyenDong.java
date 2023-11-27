/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author dungn
 */
public class Model_HeThongTruyenDong {

    public int ID;
    public String MaHTTD;
    public String LoaiLip;

    public Model_HeThongTruyenDong() {
    }

    public Model_HeThongTruyenDong(int ID, String MaHTTD, String LoaiLip) {
        this.ID = ID;
        this.MaHTTD = MaHTTD;
        this.LoaiLip = LoaiLip;
    }

    public Model_HeThongTruyenDong(String MaHTTD, String LoaiLip) {

        this.MaHTTD = MaHTTD;
        this.LoaiLip = LoaiLip;
    }

    public int getID() {
        return ID;
    }

    public String getMaHTTD() {
        return MaHTTD;
    }

    public String getLoaiLip() {
        return LoaiLip;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMaHTTD(String MaHTTD) {
        this.MaHTTD = MaHTTD;
    }

    public void setLoaiLip(String LoaiLip) {
        this.LoaiLip = LoaiLip;
    }

    @Override
    public String toString() {
        return "Model_HeThongTruyenDong{" + "ID=" + ID + ", MaHTTD=" + MaHTTD + ", LoaiLip=" + LoaiLip + '}';
    }

    public Object[] toData() {
        return new Object[]{
            this.ID, this.MaHTTD, this.LoaiLip
        };
    }
}
