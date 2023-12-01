/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author VanHieu
 */
public class Model_KhachHang {

    private Integer id;
    private String makh;
    private String tenKH;
    private String sdt;
    private String email;
    private String diachi;
    private String ngaysinh;
    private String trangthai;

    public Model_KhachHang() {
    }

    public Model_KhachHang(Integer id, String makh, String tenKH, String sdt, String email, String diachi, String ngaysinh, String trangthai) {
        this.id = id;
        this.makh = makh;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.email = email;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.trangthai = trangthai;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "Model_KhachHang{" + "id=" + id + ", makh=" + makh + ", tenKH=" + tenKH + ", sdt=" + sdt + ", email=" + email + ", diachi=" + diachi + ", ngaysinh=" + ngaysinh + ", trangthai=" + trangthai + '}';
    }

    public Object[] toDatarow() {
        return new Object[]{this.id, this.makh, this.tenKH, this.sdt, this.email, this.diachi, this.ngaysinh, this.trangthai};
    }
}
