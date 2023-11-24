/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.view;

import com.raven.repository.KhuyenMai_repository;
import com.raven.swing.KhuyenMai;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class From_KhuyenMai extends javax.swing.JPanel {

    public From_KhuyenMai() {
        initComponents();
        tbModel = (DefaultTableModel) tbKhuyenMaiTatCa.getModel();
        loadDataTATCA();
        tbModelhetHan = (DefaultTableModel) tbKhuyenMaiHetHan.getModel();
        loadDataHetHan();
        tbModelConhan = (DefaultTableModel) tbKhuyenMaiConHan.getModel();
        loadDataConHan();
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchByMaNV();
            }
             
        });
  
    }
    List<KhuyenMai> listKhuyenMaiTatCa = new ArrayList<>();
    List<KhuyenMai> listKhuyenMaiConHan = new ArrayList<>();
    List<KhuyenMai> listKhuyenMaiHetHan = new ArrayList<>();
    DefaultTableModel tbModel = new DefaultTableModel();
    KhuyenMai_repository repo = new KhuyenMai_repository();
    DefaultTableModel tbModelhetHan = new DefaultTableModel();
    DefaultTableModel tbModelConhan = new DefaultTableModel();

    private void searchByMaNV() {
        String searchtenNV = txtTimKiem.getText().trim();
        DefaultTableModel searchModel = new DefaultTableModel();
        DefaultTableModel searchModel1 = new DefaultTableModel();
        DefaultTableModel searchModel2 = new DefaultTableModel();
        searchModel = (DefaultTableModel) tbKhuyenMaiTatCa.getModel();
        searchModel1 = (DefaultTableModel) tbKhuyenMaiHetHan.getModel();
        searchModel2 = (DefaultTableModel) tbKhuyenMaiConHan.getModel();
        searchModel.setRowCount(0);
        searchModel1.setRowCount(0);
        searchModel2.setRowCount(0);

        for (KhuyenMai km : listKhuyenMaiTatCa) {
            if (km.getTenKM().toLowerCase().contains(searchtenNV.toLowerCase())) {
                searchModel.addRow(new Object[]{
                    km.getMaKM(),
                    km.getTenKM(),
                    km.getSoLuong(),
                    km.getHinhThuc(),
                    km.getMucGiamGia(),
                    km.getThoiGianBatDau(),
                    km.getThoiGianKetThuc(),
                    km.getTrangThai()
                });
            }
        }
        for (KhuyenMai km : listKhuyenMaiHetHan) {
            if (km.getTenKM().toLowerCase().contains(searchtenNV.toLowerCase())) {
                searchModel1.addRow(new Object[]{
                    km.getMaKM(),
                    km.getTenKM(),
                    km.getSoLuong(),
                    km.getHinhThuc(),
                    km.getMucGiamGia(),
                    km.getThoiGianBatDau(),
                    km.getThoiGianKetThuc(),
                    km.getTrangThai()
                });
            }
        }
        for (KhuyenMai km : listKhuyenMaiConHan) {
            if (km.getTenKM().toLowerCase().contains(searchtenNV.toLowerCase())) {
                searchModel2.addRow(new Object[]{
                    km.getMaKM(),
                    km.getTenKM(),
                    km.getSoLuong(),
                    km.getHinhThuc(),
                    km.getMucGiamGia(),
                    km.getThoiGianBatDau(),
                    km.getThoiGianKetThuc(),
                    km.getTrangThai()
                });
            }
        }
        tbKhuyenMaiTatCa.setModel(searchModel);
        tbKhuyenMaiHetHan.setModel(searchModel1);
        tbKhuyenMaiConHan.setModel(searchModel2);
    }

    void loadDataTATCA() {
        tbModel.setRowCount(0);
        listKhuyenMaiTatCa = repo.getAllKM();
        for (KhuyenMai km : listKhuyenMaiTatCa) {
            tbModel.addRow(new Object[]{
                //                km.getID(),
                km.getMaKM(),
                km.getTenKM(),
                km.getSoLuong(),
                km.getHinhThuc(),
                km.getMucGiamGia(),
                km.getThoiGianBatDau(),
                km.getThoiGianKetThuc(),
                km.getTrangThai()

            });
        }
    }

    void loadDataConHan() {
        tbModelConhan.setRowCount(0);
        listKhuyenMaiConHan = repo.getAllKMconHan();
        for (KhuyenMai km : listKhuyenMaiConHan) {
            tbModelConhan.addRow(new Object[]{
                //                km.getID(),
                km.getMaKM(),
                km.getTenKM(),
                km.getSoLuong(),
                km.getHinhThuc(),
                km.getMucGiamGia(),
                km.getThoiGianBatDau(),
                km.getThoiGianKetThuc(),
                km.getTrangThai()

            });
        }
    }

    void loadDataHetHan() {
        tbModelhetHan.setRowCount(0);
        listKhuyenMaiHetHan = repo.getAllKMHetHan();
        for (KhuyenMai km : listKhuyenMaiHetHan) {
            tbModelhetHan.addRow(new Object[]{
                //                km.getID(),
                km.getMaKM(),
                km.getTenKM(),
                km.getSoLuong(),
                km.getHinhThuc(),
                km.getMucGiamGia(),
                km.getThoiGianBatDau(),
                km.getThoiGianKetThuc(),
                km.getTrangThai()

            });
        }
    }

    KhuyenMai getFroṃ() {
        String MaKM = txtMa.getText();
        String TenKM = txtTenKM.getText();
        int SoLuong = Integer.parseInt(txtSoLuong.getText());
        int MucGiamGia = Integer.parseInt(txtMucGiamGia.getText());
        String hinhThuc;
        if (rdoTheoPT.isSelected()) {
            hinhThuc = "Theo%";
        } else {
            hinhThuc = "Tiền";
        }
        String TrangThai;
        if (rdoConHan.isSelected()) {
            TrangThai = "Còn Hạn";
        } else {
            TrangThai = "Hết Hạn";
        }
        String Mota = txtMoTa.getText();
        Date NgayBatDau = DateThoiGianBatDau.getDate();
        Date NgayThoiGianKetThuc = DateThoiGianKetThuc.getDate();
        String NguoiTao = txtNguoiTao.getText();
        Date NgayTao = DateNgayTao.getDate();
        String NguoiSua = txtNguoiSua.getText();
        Date NgaySua = DateNgaySua.getDate();
        String NguoiXoa = txtNguoiXoa.getText();
        return new KhuyenMai(MaKM, TenKM, SoLuong, hinhThuc, MucGiamGia, NgayBatDau, NgayThoiGianKetThuc, Mota, TrangThai, NgayTao, NguoiTao, NgaySua, NguoiSua, NguoiXoa);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        panelBorder1 = new com.raven.swing.PanelBorder();
        panelBorder4 = new com.raven.swing.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenKM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoTheoPT = new javax.swing.JRadioButton();
        rdoSoTien = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMucGiamGia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        DateThoiGianKetThuc = new com.toedter.calendar.JDateChooser();
        DateThoiGianBatDau = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtNguoiSua = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNguoiXoa = new javax.swing.JTextField();
        DateNgayTao = new com.toedter.calendar.JDateChooser();
        DateNgaySua = new com.toedter.calendar.JDateChooser();
        btnAdd = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        rdoHetHan = new javax.swing.JRadioButton();
        rdoConHan = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhuyenMaiTatCa = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbKhuyenMaiHetHan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbKhuyenMaiConHan = new javax.swing.JTable();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        panelBorder1.setBackground(new java.awt.Color(249, 249, 249));

        panelBorder4.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelBorder4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã khuyến mãi");
        panelBorder4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 61, 100, -1));
        panelBorder4.add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 170, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên khuyến  mãi");
        panelBorder4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 101, 120, -1));
        panelBorder4.add(txtTenKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số lượng ");
        panelBorder4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 83, -1));
        panelBorder4.add(txtSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 170, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Hình thức");
        panelBorder4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 83, -1));

        buttonGroup1.add(rdoTheoPT);
        rdoTheoPT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoTheoPT.setText("Theo%");
        rdoTheoPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTheoPTActionPerformed(evt);
            }
        });
        panelBorder4.add(rdoTheoPT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        buttonGroup1.add(rdoSoTien);
        rdoSoTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoSoTien.setText("Tiền");
        rdoSoTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSoTienActionPerformed(evt);
            }
        });
        panelBorder4.add(rdoSoTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        panelBorder4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 118, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Mức giảm giá");
        panelBorder4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 94, -1));
        panelBorder4.add(txtMucGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 170, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Thời gian bắt đầu");
        panelBorder4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 120, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Thời gian kết thúc");
        panelBorder4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 120, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Mô tả");
        panelBorder4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 70, -1));
        panelBorder4.add(txtMoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 160, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Trạng thái");
        panelBorder4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 80, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Ngày tạo");
        panelBorder4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 80, -1));
        panelBorder4.add(DateThoiGianKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 170, -1));

        DateThoiGianBatDau.setToolTipText("");
        panelBorder4.add(DateThoiGianBatDau, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 170, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Người tạo");
        panelBorder4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 80, -1));
        panelBorder4.add(txtNguoiTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 160, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Ngày sửa");
        panelBorder4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 60, 70, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Người sửa");
        panelBorder4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 100, 80, -1));
        panelBorder4.add(txtNguoiSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 100, 150, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Người xóa");
        panelBorder4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 140, 70, -1));
        panelBorder4.add(txtNguoiXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 140, 150, -1));
        panelBorder4.add(DateNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 160, -1));
        panelBorder4.add(DateNgaySua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, -1, -1));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panelBorder4.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 190, 80, 40));

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/update.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        panelBorder4.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 190, 80, 40));

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        panelBorder4.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 190, 80, 40));

        buttonGroup2.add(rdoHetHan);
        rdoHetHan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoHetHan.setText("Hết hạn");
        rdoHetHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHetHanActionPerformed(evt);
            }
        });
        panelBorder4.add(rdoHetHan, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, -1, -1));

        buttonGroup2.add(rdoConHan);
        rdoConHan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoConHan.setText("Còn Hạn");
        rdoConHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoConHanActionPerformed(evt);
            }
        });
        panelBorder4.add(rdoConHan, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Tìm kiếm"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 18, 1240, -1));

        panelBorder4.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 1270, 50));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbKhuyenMaiTatCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mại", "Tên Khuyến mại", "Số lượng ", "Hình thức", "Mức Giảm Giá", "Ngày kết thúc", "Ngày bắt đầu", "Trạng Thái"
            }
        ));
        tbKhuyenMaiTatCa.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbKhuyenMaiTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhuyenMaiTatCaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhuyenMaiTatCa);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tất cả", jPanel1);

        tbKhuyenMaiHetHan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mại", "Tên Khuyến mại", "Số lượng ", "Hình thức", "Mức Giảm Giá", "Ngày kết thúc", "Ngày bắt đầu", "Trạng Thái"
            }
        ));
        tbKhuyenMaiHetHan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhuyenMaiHetHanMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbKhuyenMaiHetHan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hết Hạn", jPanel2);

        tbKhuyenMaiConHan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mại", "Tên Khuyến mại", "Số lượng ", "Hình thức", "Mức Giảm Giá", "Ngày kết thúc", "Ngày bắt đầu", "Trạng Thái"
            }
        ));
        tbKhuyenMaiConHan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhuyenMaiConHanMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbKhuyenMaiConHan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Còn Hạn", jPanel3);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, 1301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(panelBorder4, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoTheoPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTheoPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoTheoPTActionPerformed

    private void rdoSoTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSoTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoSoTienActionPerformed

    private void rdoHetHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHetHanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoHetHanActionPerformed

    private void rdoConHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoConHanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoConHanActionPerformed

    private void tbKhuyenMaiTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuyenMaiTatCaMouseClicked
        int row = tbKhuyenMaiTatCa.getSelectedRow();
        if (row < 0) {
            return;
        }
        KhuyenMai km = listKhuyenMaiTatCa.get(row);
        txtMa.setText(km.getMaKM());
        txtTenKM.setText(km.getTenKM());
        txtMucGiamGia.setText(String.valueOf(km.getMucGiamGia()));
        txtSoLuong.setText(String.valueOf(km.getSoLuong()));
        if (km.getHinhThuc().equals("Theo%")) {
            rdoTheoPT.setSelected(true);
        } else if (km.getHinhThuc().equals("Tiền")) {
            rdoSoTien.setSelected(true);
        }
        DateThoiGianBatDau.setDate(km.getThoiGianBatDau());
        DateThoiGianKetThuc.setDate(km.getThoiGianKetThuc());
        txtMoTa.setText(km.getMoTa());
        if (km.getTrangThai().equals("Còn Hạn")) {
            rdoConHan.setSelected(true);
        } else if (km.getTrangThai().equals("Hết Hạn")) {
            rdoHetHan.setSelected(true);
        }
        DateNgayTao.setDate(km.getCreateAt());
        txtNguoiTao.setText(km.getCreateBy());
        DateNgaySua.setDate(km.getUpdateAt());
        txtNguoiSua.setText(km.getUpdateBy());
        txtNguoiXoa.setText(km.getDeletedBy());


    }//GEN-LAST:event_tbKhuyenMaiTatCaMouseClicked

    private void tbKhuyenMaiHetHanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuyenMaiHetHanMouseClicked
        int row = tbKhuyenMaiHetHan.getSelectedRow();
        if (row < 0) {
            return;
        }
        KhuyenMai km = listKhuyenMaiHetHan.get(row);
        txtMa.setText(km.getMaKM());
        txtTenKM.setText(km.getTenKM());
        txtMucGiamGia.setText(String.valueOf(km.getMucGiamGia()));
        txtSoLuong.setText(String.valueOf(km.getSoLuong()));
        if (km.getHinhThuc().equals("Theo%")) {
            rdoTheoPT.setSelected(true);
        } else if (km.getHinhThuc().equals("Tiền")) {
            rdoSoTien.setSelected(true);
        }
        DateThoiGianBatDau.setDate(km.getThoiGianBatDau());
        DateThoiGianKetThuc.setDate(km.getThoiGianKetThuc());
        txtMoTa.setText(km.getMoTa());
        if (km.getTrangThai().equals("Còn Hạn")) {
            rdoConHan.setSelected(true);
        } else if (km.getTrangThai().equals("Hết Hạn")) {
            rdoHetHan.setSelected(true);
        }
        DateNgayTao.setDate(km.getCreateAt());
        txtNguoiTao.setText(km.getCreateBy());
        DateNgaySua.setDate(km.getUpdateAt());
        txtNguoiSua.setText(km.getUpdateBy());
        txtNguoiXoa.setText(km.getDeletedBy());

    }//GEN-LAST:event_tbKhuyenMaiHetHanMouseClicked

    private void tbKhuyenMaiConHanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuyenMaiConHanMouseClicked
        int row = tbKhuyenMaiConHan.getSelectedRow();
        if (row < 0) {
            return;
        }
        KhuyenMai km = listKhuyenMaiConHan.get(row);
        txtMa.setText(km.getMaKM());
        txtTenKM.setText(km.getTenKM());
        txtMucGiamGia.setText(String.valueOf(km.getMucGiamGia()));
        txtSoLuong.setText(String.valueOf(km.getSoLuong()));
        if (km.getHinhThuc().equals("Theo%")) {
            rdoTheoPT.setSelected(true);
        } else if (km.getHinhThuc().equals("Tiền")) {
            rdoSoTien.setSelected(true);
        }
        DateThoiGianBatDau.setDate(km.getThoiGianBatDau());
        DateThoiGianKetThuc.setDate(km.getThoiGianKetThuc());
        txtMoTa.setText(km.getMoTa());
        if (km.getTrangThai().equals("Còn Hạn")) {
            rdoConHan.setSelected(true);
        } else if (km.getTrangThai().equals("Hết Hạn")) {
            rdoHetHan.setSelected(true);
        }
        DateNgayTao.setDate(km.getCreateAt());
        txtNguoiTao.setText(km.getCreateBy());
        DateNgaySua.setDate(km.getUpdateAt());
        txtNguoiSua.setText(km.getUpdateBy());
        txtNguoiXoa.setText(km.getDeletedBy());

    }//GEN-LAST:event_tbKhuyenMaiConHanMouseClicked
    public void Clear() {
        txtMa.setText("");
        txtMoTa.setText("");
        txtMucGiamGia.setText("");
        txtNguoiSua.setText("");
        txtNguoiTao.setText("");
        txtNguoiXoa.setText("");
        txtSoLuong.setText("");
        txtTenKM.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();

    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        KhuyenMai km = getFroṃ();
        if (repo.Add(km)) {
            loadDataTATCA();
            Clear();
            JOptionPane.showMessageDialog(this, "Đã lưu");
        } else {
            JOptionPane.showMessageDialog(this, "Lưu không thành công");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tbKhuyenMaiTatCa.getSelectedRow();
        if(row < 0) return;

        KhuyenMai km = getFroṃ();
        String MaKM = listKhuyenMaiTatCa.get(row).getMaKM();
        km.setMaKM(MaKM);
        
        if(repo.update(km)){
            loadDataTATCA();
            Clear();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        }else{
            JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
                int row = tbKhuyenMaiTatCa.getSelectedRow();
        if(row < 0){
            return;
        }
        
        int cauhoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không ? ", "Hỏi",
                JOptionPane.YES_NO_OPTION);
        if (cauhoi == JOptionPane.NO_OPTION) {
            return;
        }
        
        String MaKM = listKhuyenMaiTatCa.get(row).getMaKM();
        if(repo.deleteById(MaKM)){
            loadDataTATCA();
            Clear();
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        }else{
            JOptionPane.showMessageDialog(this, "Xóa không thành công");
        }
       
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateNgaySua;
    private com.toedter.calendar.JDateChooser DateNgayTao;
    private com.toedter.calendar.JDateChooser DateThoiGianBatDau;
    private com.toedter.calendar.JDateChooser DateThoiGianKetThuc;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.raven.swing.PanelBorder panelBorder1;
    private com.raven.swing.PanelBorder panelBorder4;
    private javax.swing.JRadioButton rdoConHan;
    private javax.swing.JRadioButton rdoHetHan;
    private javax.swing.JRadioButton rdoSoTien;
    private javax.swing.JRadioButton rdoTheoPT;
    private javax.swing.JTable tbKhuyenMaiConHan;
    private javax.swing.JTable tbKhuyenMaiHetHan;
    private javax.swing.JTable tbKhuyenMaiTatCa;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtMucGiamGia;
    private javax.swing.JTextField txtNguoiSua;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtNguoiXoa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
