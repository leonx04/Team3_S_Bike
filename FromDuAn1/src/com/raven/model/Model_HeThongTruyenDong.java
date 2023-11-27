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

    public int IDHTTD;
    public String MaHTTD;
    public String LoaiLip;

    public Model_HeThongTruyenDong() {
    }

    public Model_HeThongTruyenDong(int IDHTTD, String MaHTTD, String LoaiLip) {
        this.IDHTTD = IDHTTD;
        this.MaHTTD = MaHTTD;
        this.LoaiLip = LoaiLip;
    }

    public Model_HeThongTruyenDong(String MaHTTD, String LoaiLip) {
        this.MaHTTD = MaHTTD;
        this.LoaiLip = LoaiLip;
    }

    public int getIDHTTD() {
        return IDHTTD;
    }

    public String getMaHTTD() {
        return MaHTTD;
    }

    public String getLoaiLip() {
        return LoaiLip;
    }

    public void setIDHTTD(int IDHTTD) {
        this.IDHTTD = IDHTTD;
    }

    public void setMaHTTD(String MaHTTD) {
        this.MaHTTD = MaHTTD;
    }

    public void setLoaiLip(String LoaiLip) {
        this.LoaiLip = LoaiLip;
    }

    
    public Object[] toData() {
        return new Object[]{
            this.IDHTTD, this.MaHTTD, this.LoaiLip
        };
    }

    @Override
    public String toString() {
        return "Model_HeThongTruyenDong{" + "IDHTTD=" + IDHTTD + ", MaHTTD=" + MaHTTD + ", LoaiLip=" + LoaiLip + '}';
    }
    
    
}
