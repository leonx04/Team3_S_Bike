/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.NhanVien;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.raven.model.Model_NhanVien;
import com.raven.service.Service_NhanVien;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author nhdao
 */
public class NhanVien extends javax.swing.JPanel {

    private final Service_NhanVien service = new Service_NhanVien();
    private DefaultTableModel model = new DefaultTableModel();
    private int index = -1;

    // Function to convert date to string
    /**
     * Creates new form NhanVien
     */
    public NhanVien() {
        initComponents();
        //       this.setLocationRelativeTo(null);
        this.fillTable(service.getAll());
    }

    public void fillTable(List<Model_NhanVien> list) {
        model = (DefaultTableModel) tbl_nhanVien.getModel();
        DefaultTableModel dm;
        model.setRowCount(0);
        for (Model_NhanVien s : list) {
            Object[] row = new Object[]{
                s.getMaNV(),
                s.getTenNV(),
                s.getSdt(),
                s.getEmail(),
                s.getCccd(),
                s.getNgaysinh(),
                s.isGioitinh(),
                s.getChucvu(),
                s.getTrangthai()
            };
            model.addRow(row);
        }
    }

    public Model_NhanVien readForm() {
        String ma = txt_maNV.getText();
        String ten = txt_tenNV.getText();
        String sdt = txt_sdt.getText();
        String cccd = txt_cccd.getText();
        String email = txt_email.getText();
        String ngaysinh = txt_ngaysinh.getText();
        boolean gioiTinh = rd_Nam.isSelected() ? true : false;
        String chucvu = cb_chucvu.getSelectedItem().toString();
        String trangthai = cb_trangthai.getSelectedItem().toString();

        return new Model_NhanVien(ma, ten, sdt, cccd, email, ngaysinh, gioiTinh, chucvu, trangthai);

    }

    public boolean checkValidate() {
        if (txt_maNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
            return false;
        }
        if (txt_tenNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return false;
        }
        if (txt_cccd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "email không được để trống");
            return false;
        }
        if (txt_sdt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
            return false;
        }
        if (!txt_email.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
            return false;
        }
        if (txt_sdt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại rỗng");
            return false;
        } else {
            if (!txt_sdt.getText().matches("[0-9]{10}")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng");
                return false;
            }
        }
        return true;
    }
    
    public boolean TESTDATA() {
        if (txt_maNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
            return false;
        }
        if (txt_tenNV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return false;
        }
        if (txt_cccd.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "email không được để trống");
            return false;
        }
        if (txt_sdt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
            return false;
        }
        if (!txt_email.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
            return false;
        }
        if (txt_sdt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại rỗng");
            return false;
        } else {
            if (!txt_sdt.getText().matches("[0-9]{10}")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng");
                return false;
            }
        }
        return true;
    }

    private void showData(int index) {
        Model_NhanVien nv = service.getAll().get(index);
        txt_maNV.setText(nv.getMaNV());
        txt_tenNV.setText(nv.getTenNV());
        txt_sdt.setText(nv.getSdt());
        txt_email.setText(nv.getEmail());
        txt_cccd.setText(nv.getCccd());
        txt_ngaysinh.setText(nv.getNgaysinh());

        rd_Nam.setSelected(nv.isGioitinh());
        if(nv.isGioitinh()!= true){
            rd_Nu.setSelected(true);
        }
     

        cb_chucvu.setSelectedItem(nv.getChucvu());
        cb_trangthai.setSelectedItem(nv.getTrangthai());

    }


    
    private void cleanForm() {
        txt_maNV.setText("");
        txt_tenNV.setText("");
        txt_sdt.setText("");
        txt_email.setText("");
        txt_cccd.setText("");
        txt_ngaysinh.setText("");
        cb_chucvu.setSelectedItem(0);
        cb_trangthai.setSelectedItem(0);
        rd_Nam.setSelected(false);
        rd_Nu.setSelected(false);
    }

    private void filter(String querry){
        TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
        tbl_nhanVien.setRowSorter(tr); 
        tr.setRowFilter(RowFilter.regexFilter(querry));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_maNV = new javax.swing.JTextField();
        txt_tenNV = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_cccd = new javax.swing.JTextField();
        txt_ngaysinh = new javax.swing.JTextField();
        cb_chucvu = new javax.swing.JComboBox<>();
        cb_trangthai = new javax.swing.JComboBox<>();
        rd_Nam = new javax.swing.JRadioButton();
        rd_Nu = new javax.swing.JRadioButton();
        btn_Resest = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_timkiem = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Camera_Panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(102, 102, 102));
        setMaximumSize(new java.awt.Dimension(1550, 847));
        setPreferredSize(new java.awt.Dimension(1550, 847));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_nhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)));
        tbl_nhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhân Viên", "Tên Nhân Viên", "SĐT", "Email", "CCCD", "Ngày sinh", "Giới Tính", "Chức Vụ", "Trạng Thái"
            }
        ));
        tbl_nhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nhanVien);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 402, 1308, 350));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan, java.awt.Color.cyan));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Mã nhân viên");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Tên nhân viên");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Số điện thoại");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Email");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("CCCD");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Ngày sinh");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Giới tính");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Trạng thái");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Chức vụ");

        cb_chucvu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quan ly", "Nhan Vien" }));

        cb_trangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Di lam", "Nghi lam" }));

        buttonGroup1.add(rd_Nam);
        rd_Nam.setText("Nam");
        rd_Nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_NamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_Nu);
        rd_Nu.setText("Nữ");

        btn_Resest.setText("Resest");
        btn_Resest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResestActionPerformed(evt);
            }
        });

        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_Sua.setText("Update");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_tenNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_maNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_cccd, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(txt_ngaysinh)
                    .addComponent(txt_email))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rd_Nam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_Nu))
                            .addComponent(cb_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Sua)
                            .addComponent(btn_Them)
                            .addComponent(btn_Xoa)
                            .addComponent(btn_Resest))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(rd_Nam)
                    .addComponent(rd_Nu)
                    .addComponent(btn_Them))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18)
                            .addComponent(txt_tenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cccd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Sua)
                        .addGap(30, 30, 30)
                        .addComponent(btn_Xoa)
                        .addGap(29, 29, 29)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Resest))
                .addGap(33, 33, 33))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 255))));
        jPanel1.setName(""); // NOI18N

        txt_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timkiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 600, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setText("Thiết lập thông tin ");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel23.setText("Tìm kiếm");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        javax.swing.GroupLayout Camera_PanelLayout = new javax.swing.GroupLayout(Camera_Panel);
        Camera_Panel.setLayout(Camera_PanelLayout);
        Camera_PanelLayout.setHorizontalGroup(
            Camera_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        Camera_PanelLayout.setVerticalGroup(
            Camera_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        add(Camera_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 320, 240));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
  int luachon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm");
    if(luachon==0){
            if (checkValidate()) {
            Model_NhanVien nv = this.readForm();
            if (service.checkTrungMa(nv.getMaNV()) != null) {
                JOptionPane.showMessageDialog(this, "Ma trung khong them duoc");
            } else {
                if (service.addNV(nv) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    fillTable(service.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    cleanForm();
                    return;
                }
            }
        }
            
  }
  if(luachon==1){
      return;
  }
  if(luachon==2){
      cleanForm();
  }


    }//GEN-LAST:event_btn_ThemActionPerformed

    private void rd_NamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_NamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_NamActionPerformed

    private void btn_ResestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResestActionPerformed
        cleanForm();
        txt_maNV.setEditable(true);
    }//GEN-LAST:event_btn_ResestActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
  int luachon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa");
    if(luachon==0){
        index = tbl_nhanVien.getSelectedRow();
        String maNV = tbl_nhanVien.getValueAt(index, 0).toString();
        if (service.deleteNV(maNV) > 0) {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            this.fillTable(service.getAll());
        }
        cleanForm(); 
  }
  if(luachon==1){
      return;
  }
  if(luachon==2){
      cleanForm();
      txt_maNV.setEditable(true);
  }

    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
Model_NhanVien nv = this.readForm(); 
  int luachon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn lưu những gì đã sữa");
    if(luachon==0){
        index = tbl_nhanVien.getSelectedRow();
        String maNV = tbl_nhanVien.getValueAt(index, 0).toString();
        if (service.deleteNV(maNV) > 0) {
            JOptionPane.showMessageDialog(this, "Thất bại");
            return;
        } else {
                                if (service.checkTrungMa(nv.getMaNV()) != null) {
                //JOptionPane.showMessageDialog(this, "Ma trung khong them duoc");
            } else {
                if (service.addNV(nv) > 0) {
                    //JOptionPane.showMessageDialog(this, "Thêm thành công");
                    fillTable(service.getAll());
                } else {
                    //JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    cleanForm();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Thành công");
            this.fillTable(service.getAll());
        }
        

  }
  if(luachon==1){
      txt_maNV.setEditable(true);
      return;      
  }
  if(luachon==2){
      cleanForm();
      txt_maNV.setEditable(true);
  }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void tbl_nhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nhanVienMouseClicked
        index = tbl_nhanVien.getSelectedRow();
        this.showData(index);
        txt_maNV.setEditable(false);
    }//GEN-LAST:event_tbl_nhanVienMouseClicked

    private void txt_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timkiemKeyReleased
        String query = txt_timkiem.getText();
        filter(query);
    }//GEN-LAST:event_txt_timkiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Camera_Panel;
    private javax.swing.JButton btn_Resest;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cb_chucvu;
    private javax.swing.JComboBox<String> cb_trangthai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_Nam;
    private javax.swing.JRadioButton rd_Nu;
    private javax.swing.JTable tbl_nhanVien;
    private javax.swing.JTextField txt_cccd;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_maNV;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenNV;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
