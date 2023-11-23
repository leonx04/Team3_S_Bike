/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.view;

import com.raven.model.HoaDon_Model;
import com.raven.model.LichSuHD_Model;
import com.raven.repository.HoaDon_reponsitory;
import com.raven.repository.LichSuHD_responsitory;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Thu Phuong
 */
public class Bill_Jpanel extends javax.swing.JPanel {

    private DefaultTableModel mol = new DefaultTableModel();
    private HoaDon_reponsitory repo = new HoaDon_reponsitory();
    private LichSuHD_responsitory repoLSHD = new LichSuHD_responsitory();
    private int index = -1;
    int i = 1;
    JTabbedPane pane = new JTabbedPane();
    List<HoaDon_Model> list = new ArrayList<>();

    public Bill_Jpanel() {
        initComponents();
        init();
    }

    private void init() {
//        int rowcount = tblHoaDon.getRowCount();
//        for(int i=0; i<rowcount; i++){
//            tblHoaDon.setValueAt(i+1, i, 1);
//        }
        this.fillTableHD(repo.getAllHD());
        //this.fillTableLSHD(repoLSHD.getAllHD());
    }

    void fillTableHD(List<HoaDon_Model> list) {
        mol = (DefaultTableModel) tblHoaDon.getModel();
        mol.setRowCount(0);
        HoaDon_Model hd = list.get(list.size() - 1);
        for (HoaDon_Model x : list) {
            mol.addRow(new Object[]{
                i++, x.getMaHD(), x.getNgayTao(), x.getNgayThanhToan(), x.getTongTien(), x.getLoaiHD(), x.getMaNV(), x.getTenKH(), x.getTenNN(), x.getSDT(), x.getTrangThai()
            });
        }
    }

    public void search(String str) {
        mol = (DefaultTableModel) tblHoaDon.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(mol);
        tblHoaDon.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void findTrangThai(String trangTha) {
        mol = (DefaultTableModel) tblHoaDon.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(mol);
        tblHoaDon.setRowSorter(trs);
        if (trangTha != "Tất cả") {
            trs.setRowFilter(RowFilter.regexFilter(trangTha));
        } else {
            tblHoaDon.setRowSorter(trs);
        }
    }

    public void findDate() {
        try {
            mol = (DefaultTableModel) tblHoaDon.getModel();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = df.format(dcDau.getDate());
            String date2 = df.format(dcCuoi.getDate());
            repo.getAllDate(date1, date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findGia(int t1, int t2) {
        try {
            mol = (DefaultTableModel) tblHoaDon.getModel();
            t1 = Integer.parseInt(txtGiaKhoang.getText());
            t2 = Integer.parseInt(txtGiaDen.getText());
            repo.getAllGia(t1, t2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillTableLSHD(List<HoaDon_Model> list) {
        mol = (DefaultTableModel) tblLichSuHoaDon.getModel();
        mol.setRowCount(0);
        HoaDon_Model lshd = list.get(list.size() - 1);
        for (HoaDon_Model x : list) {
            mol.addRow(new Object[]{
                i++, x.getNgayTao(), x.getMaNV(), x.getTenNV(), x.getHanhDong()
            });
        }
    }

    void edit() {
        String maHD = (String) tblHoaDon.getValueAt(index, 1).toString();
        HoaDon_Model hd = (HoaDon_Model) repo.selectById(maHD);
        if (hd != null) {
            this.setForm(hd);
            tabs.setSelectedIndex(0);
        }
        //tabs.setSelectedIndex(0);
    }

    void setForm(HoaDon_Model hd) {
        List<HoaDon_Model> list = repo.selectAll();
        for (HoaDon_Model mod : list) {
            if (mod.getMaHD().equals(mod.getMaHD())) {
                txtMaHD.setText(mod.getMaHD());
                txtMaNV.setText(mod.getMaNV());
                txtKH.setText(mod.getTenKH());
                txtNguoiNhan.setText(mod.getTenNN());
                txtSDT.setText(mod.getSDT());
                txtDiaChi.setText(mod.getDiaChi());
                cboTrangThai.setSelectedItem(mod.getTrangThai());
                txtTienGiamGia.setText(String.valueOf(mod.getMucGG()));
                txtTongTien.setText(String.valueOf(mod.getTongTien()));
                txtTienShip.setText(String.valueOf(mod.getPhiVC()));
                txtNgayTao.setText(String.valueOf(mod.getNgayTao()));
                return;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiemHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cboTrangThaiHoaDon = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtGiaDen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGiaKhoang = new javax.swing.JTextField();
        btnLoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnInHoaDon = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        dcDau = new com.toedter.calendar.JDateChooser();
        dcCuoi = new com.toedter.calendar.JDateChooser();
        btnTim = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblLichSuHoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        btnTraHang = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtNguoiNhan = new javax.swing.JTextField();
        cboTrangThai = new javax.swing.JComboBox<>();
        txtTienGiamGia = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienShip = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtNguoiSua = new javax.swing.JTextField();
        txtNgaySuaCuoi = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        tabs.setBackground(new java.awt.Color(255, 255, 255));
        tabs.setPreferredSize(new java.awt.Dimension(900, 938));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));

        jLabel1.setText("Tìm kiếm hóa đơn");

        txtTimKiemHD.setForeground(new java.awt.Color(204, 204, 204));
        txtTimKiemHD.setText("Nhập mã hóa đơn");
        txtTimKiemHD.setToolTipText("");
        txtTimKiemHD.setName(""); // NOI18N
        txtTimKiemHD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemHDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemHDFocusLost(evt);
            }
        });
        txtTimKiemHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemHDKeyReleased(evt);
            }
        });

        jLabel2.setText("Trạng thái hóa đơn");

        cboTrangThaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã thanh toán", "Chua thanh toán", " " }));
        cboTrangThaiHoaDon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTrangThaiHoaDonItemStateChanged(evt);
            }
        });

        jLabel4.setText("Giá khoảng");

        jLabel5.setText("đến");

        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HD", "Ngày tạo", "Ngày thanh toán", "Tổng tiền", "Loại HD", "Mã NV", "Tên KH", "Tên NN", "SDT", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblHoaDonMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        btnInHoaDon.setText("In hóa đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        jButton8.setText("Xuất danh sách");

        jButton9.setText("Tạo hóa đơn");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        btnTim.setText("TÌm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cboTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(dcDau, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(dcCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtGiaKhoang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtGiaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnLoc)
                                .addComponent(btnTim))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton9)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnInHoaDon)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8)
                        .addGap(39, 39, 39)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtTimKiemHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dcDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTim)
                        .addComponent(jButton9)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaKhoang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(btnInHoaDon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn chi tiết"));

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã ", "Tên sản phẩm", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lịch sử hóa đơn"));

        tblLichSuHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Ngày", "Mã NV", "Tên NV", "Hành động"
            }
        ));
        jScrollPane6.setViewportView(tblLichSuHoaDon);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(430, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(232, Short.MAX_VALUE))
        );

        tabs.addTab("Hóa đơn", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm")));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Thương hiệu", "Màu sắc", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane4.setViewportView(tblSanPham);

        btnTraHang.setText("Trả hàng");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btnTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));

        jLabel6.setText("Mã HD");

        jLabel7.setText("Mã NV");

        jLabel8.setText("Người đặt");

        jLabel9.setText("Người nhận");

        jLabel10.setText("SDT");

        jLabel11.setText("Địa chỉ");

        jLabel12.setText("Trạng thái");

        jLabel14.setText("Tiền giảm giá");

        jLabel15.setText("Tổng tiền");

        jLabel17.setText("Tiền ship");

        jLabel18.setText("Ngày tạo");

        jLabel19.setText("Người sửa");

        jLabel20.setText("Ngày sửa cuối");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chua thanh toán", " " }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18)
                        .addComponent(jLabel17))
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgaySuaCuoi, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(txtNguoiSua)
                    .addComponent(txtTienShip)
                    .addComponent(txtTongTien)
                    .addComponent(txtTienGiamGia)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(txtKH)
                            .addComponent(txtMaNV)
                            .addComponent(txtMaHD)
                            .addComponent(txtNguoiNhan)
                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNgayTao)
                    .addComponent(txtDiaChi))
                .addGap(57, 57, 57))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTienGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTienShip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtNguoiSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtNgaySuaCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
        );

        jLabel3.setText("Tìm kiếm");

        btnSearch.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1089, 1089, 1089)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnSearch)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(255, 255, 255)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Trả hàng", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 1496, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemHDKeyReleased
        // TODO add your handling code here:
        String searchString = txtTimKiemHD.getText();
        search(searchString);
    }//GEN-LAST:event_txtTimKiemHDKeyReleased

    private void cboTrangThaiHoaDonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTrangThaiHoaDonItemStateChanged
        // TODO add your handling code here:
        String trangThai = cboTrangThaiHoaDon.getSelectedItem().toString();
        findTrangThai(trangThai);
    }//GEN-LAST:event_cboTrangThaiHoaDonItemStateChanged

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        try {
            mol = (DefaultTableModel) tblHoaDon.getModel();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = df.format(dcDau.getDate());
            String date2 = df.format(dcCuoi.getDate());
            repo.getAllDate(date1, date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        int t1 = Integer.parseInt(txtGiaKhoang.getText());
        int t2 = Integer.parseInt(txtGiaDen.getText());
        this.findGia(t1, t2);
    }//GEN-LAST:event_btnLocActionPerformed

    private void tblHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tblHoaDon.getSelectedRow();
            String maNV = (String) tblHoaDon.getValueAt(index, 6).toString();
            this.fillTableLSHD(repo.getAllLichSuHD(maNV));
            this.edit();
        }
    }//GEN-LAST:event_tblHoaDonMousePressed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
//         TODO add your handling code here:
//        this.index = tblHoaDon.getSelectedRow();
//            this.edit();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtTimKiemHDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemHDFocusGained
        // TODO add your handling code here:
        if (txtTimKiemHD.getText().equals("Nhập mã hóa đơn")) {
            txtTimKiemHD.setText("");
            txtTimKiemHD.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_txtTimKiemHDFocusGained

    private void txtTimKiemHDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemHDFocusLost
        // TODO add your handling code here:
        if (txtTimKiemHD.getText().equals("Nhập mã hóa đơn")) {
            txtTimKiemHD.setText("");
            txtTimKiemHD.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtTimKiemHDFocusLost

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        // TODO add your handling code here:
        String path = "";
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = file.showSaveDialog(this);
        if(x== JFileChooser.APPROVE_OPTION){
            path = file.getSelectedFile().getPath();
        }
        
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnTraHang;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JComboBox<String> cboTrangThaiHoaDon;
    private com.toedter.calendar.JDateChooser dcCuoi;
    private com.toedter.calendar.JDateChooser dcDau;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tblLichSuHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGiaDen;
    private javax.swing.JTextField txtGiaKhoang;
    private javax.swing.JTextField txtKH;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgaySuaCuoi;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNguoiNhan;
    private javax.swing.JTextField txtNguoiSua;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTienGiamGia;
    private javax.swing.JTextField txtTienShip;
    private javax.swing.JTextField txtTimKiemHD;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

}
