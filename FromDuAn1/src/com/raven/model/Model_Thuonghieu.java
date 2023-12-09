/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

/**
 *
 * @author dungn
 */
public class Model_Thuonghieu {

    private int id;
    private String ma;
    private String tenThuongHieu;

    public Model_Thuonghieu() {
    }

    public Model_Thuonghieu(int id, String ma, String tenThuongHieu) {
        this.id = id;
        this.ma = ma;
        this.tenThuongHieu = tenThuongHieu;
    }

    public Model_Thuonghieu(String ma, String tenThuongHieu) {
        this.ma = ma;
        this.tenThuongHieu = tenThuongHieu;
    }

    public int getId() {
        return id;
    }

    public String getMa() {
        return ma;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    @Override
    public String toString() {
        return "Model_Thuonghieu{" + "id=" + id + ", ma=" + ma + ", tenThuongHieu=" + tenThuongHieu + '}';
    }

    public Object[] toData() {
        return new Object[]{
            this.id, this.ma, this.tenThuongHieu
        };
    }

}
