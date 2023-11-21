/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author dungn
 */
public class Model_HinhAnhXe {
    public int ID;
    public String MaHA;
    public String HinhAnh;

    public Model_HinhAnhXe() {
    }

    
    public Model_HinhAnhXe(String MaHA, String HinhAnh) {
        this.ID = ID;
        this.MaHA = MaHA;
        this.HinhAnh = HinhAnh;
    }

    public int getID() {
        return ID;
    }

    public String getMaHA() {
        return MaHA;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMaHA(String MaHA) {
        this.MaHA = MaHA;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    @Override
    public String toString() {
        return "Model_HinhAnhXe{" + "ID=" + ID + ", MaHA=" + MaHA + ", HinhAnh=" + HinhAnh + '}';
    }

    
}
