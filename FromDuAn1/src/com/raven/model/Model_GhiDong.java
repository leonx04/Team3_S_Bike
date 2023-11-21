/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author dungn
 */
public class Model_GhiDong {

    public Model_GhiDong() {
    }

    public int ID;
    public String MaGD;
    public String LoaiGD;

    public Model_GhiDong(String MaGD, String LoaiGD) {
        this.ID = ID;
        this.MaGD = MaGD;
        this.LoaiGD = LoaiGD;
    }

    public Object[] toData() {
        return new Object[]{
            this.MaGD, this.LoaiGD
        };
    }

    public int getID() {
        return ID;
    }

    public String getMaGD() {
        return MaGD;
    }

    public String getLoaiGD() {
        return LoaiGD;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMaGD(String MaGD) {
        this.MaGD = MaGD;
    }

    public void setLoaiGD(String LoaiGD) {
        this.LoaiGD = LoaiGD;
    }

    @Override
    public String toString() {
        return "Model_GhiDong{" + "ID=" + ID + ", MaGD=" + MaGD + ", LoaiGD=" + LoaiGD + '}';
    }

}
