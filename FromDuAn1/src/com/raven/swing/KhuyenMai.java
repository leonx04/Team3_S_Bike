
package com.raven.swing;

public class KhuyenMai {
    int ID;
    String MaKM;
    String GiaTriPhanTram;
    int GiaTriTienMat;
    String trangthai;
    String NgayBatDau,NgayKetThuc,ngaytao,nguoitao,nguoisua,ngaysua,nguoixoa;

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNguoitao() {
        return nguoitao;
    }

    public void setNguoitao(String nguoitao) {
        this.nguoitao = nguoitao;
    }

    public String getNguoisua() {
        return nguoisua;
    }

    public void setNguoisua(String nguoisua) {
        this.nguoisua = nguoisua;
    }

    public String getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(String ngaysua) {
        this.ngaysua = ngaysua;
    }

    public String getNguoixoa() {
        return nguoixoa;
    }

    public void setNguoixoa(String nguoixoa) {
        this.nguoixoa = nguoixoa;
    }

    public KhuyenMai() {
    }

    public KhuyenMai(int ID, String MaKM, String GiaTriPhanTram, int GiaTriTienMat, String trangthai, String NgayBatDau, String NgayKetThuc, String ngaytao, String nguoitao, String nguoisua, String ngaysua, String nguoixoa) {
        this.ID = ID;
        this.MaKM = MaKM;
        this.GiaTriPhanTram = GiaTriPhanTram;
        this.GiaTriTienMat = GiaTriTienMat;
        this.trangthai = trangthai;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.ngaytao = ngaytao;
        this.nguoitao = nguoitao;
        this.nguoisua = nguoisua;
        this.ngaysua = ngaysua;
        this.nguoixoa = nguoixoa;
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

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
  
}
