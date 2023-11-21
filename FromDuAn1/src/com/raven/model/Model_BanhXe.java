/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author dungn
 */
public class Model_BanhXe {
    public int ID;
    public String MaBX;
    public String TenBanhXe;

    public Model_BanhXe() {
    }

    
    public Model_BanhXe(String MaBX, String TenBanhXe) {
        this.ID = ID;
        this.MaBX = MaBX;
        this.TenBanhXe = TenBanhXe;
    }

    public Model_BanhXe(int ID, String MaBX, String TenBanhXe) {
        this.ID = ID;
        this.MaBX = MaBX;
        this.TenBanhXe = TenBanhXe;
    }
    public int getID() {
        return ID;
    }

    public String getMaBX() {
        return MaBX;
    }

    public String getTenBanhXe() {
        return TenBanhXe;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMaBX(String MaBX) {
        this.MaBX = MaBX;
    }

    public void setTenBanhXe(String TenBanhXe) {
        this.TenBanhXe = TenBanhXe;
    }

    @Override
    public String toString() {
        return "Model_BanhXe{" + "ID=" + ID + ", MaBX=" + MaBX + ", TenBanhXe=" + TenBanhXe + '}';
    }

    


    
}
