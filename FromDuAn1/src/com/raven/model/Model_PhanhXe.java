package com.raven.model;

public class Model_PhanhXe {

    private int ID;
    private String MaPX;
    private String TenPhanhXe;

    public Model_PhanhXe() {
    }

    public Model_PhanhXe(String MaPX, String TenPhanhXe) {
        this.MaPX = MaPX;
        this.TenPhanhXe = TenPhanhXe;
    }

    public Model_PhanhXe(int ID, String MaPX, String TenPhanhXe) {
        this.ID = ID;
        this.MaPX = MaPX;
        this.TenPhanhXe = TenPhanhXe;
    }

    public Object[] toData() {
        return new Object[]{
            this.ID, this.MaPX, this.TenPhanhXe
        };
    }

    public int getID() {
        return ID;
    }

    public String getMaPX() {
        return MaPX;
    }

    public String getTenPhanhXe() {
        return TenPhanhXe;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMaPX(String MaPX) {
        this.MaPX = MaPX;
    }

    public void setTenPhanhXe(String TenPhanhXe) {
        this.TenPhanhXe = TenPhanhXe;
    }

    @Override
    public String toString() {
        return "Model_PhanhXe{" + "ID=" + ID + ", MaPX=" + MaPX + ", TenPhanhXe=" + TenPhanhXe + '}';
    }
}
