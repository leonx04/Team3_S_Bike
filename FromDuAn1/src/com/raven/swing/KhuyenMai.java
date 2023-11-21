
package com.raven.swing;

public class KhuyenMai {
    int ID;
    String MaKM;
    String GiaTriPhanTram;
    int GiaTriTienMat;
    boolean trangthai;

    public KhuyenMai() {
    }

    public KhuyenMai(int ID, String MaKM, String GiaTriPhanTram, int GiaTriTienMat, boolean trangthai) {
        this.ID = ID;
        this.MaKM = MaKM;
        this.GiaTriPhanTram = GiaTriPhanTram;
        this.GiaTriTienMat = GiaTriTienMat;
        this.trangthai = trangthai;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getGiaTriPhanTram() {
        return GiaTriPhanTram;
    }

    public void setGiaTriPhanTram(String GiaTriPhanTram) {
        this.GiaTriPhanTram = GiaTriPhanTram;
    }

    public int getGiaTriTienMat() {
        return GiaTriTienMat;
    }

    public void setGiaTriTienMat(int GiaTriTienMat) {
        this.GiaTriTienMat = GiaTriTienMat;
    }

    public boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }


    
}
