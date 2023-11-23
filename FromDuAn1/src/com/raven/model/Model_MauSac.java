/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author dungn
 */
public class Model_MauSac {

    public long ID;
    public String MaMS;
    public String TenMS;

    public Model_MauSac() {
    }

    public Model_MauSac(String MaMS, String TenMS) {
        this.MaMS = MaMS;
        this.TenMS = TenMS;
    }

    public Model_MauSac(int ID, String MaMS, String TenMS) {
        this.ID = ID;
        this.MaMS = MaMS;
        this.TenMS = TenMS;
    }

    public long getID() {
        return ID;
    }

    public String getMaMS() {
        return MaMS;
    }

    public String getTenMS() {
        return TenMS;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setMaMS(String MaMS) {
        this.MaMS = MaMS;
    }

    public void setTenMS(String TenMS) {
        this.TenMS = TenMS;
    }

    @Override
    public String toString() {
        return "Model_MauSac{" + "ID=" + ID + ", MaMS=" + MaMS + ", TenMS=" + TenMS + '}';
    }

    public Object[] toData() {
        return new Object[] { this.ID, this.MaMS, this.TenMS
        };
    }
}
