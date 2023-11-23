/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.KhachHang;

import com.raven.connectDB.QuanLyKhachHang;
import com.raven.model.Model_KhachHang;
import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author VanHieu
 */
public class KhachHangView extends javax.swing.JPanel {

    /**
     * Creates new form KhachHangView
     */
    QuanLyKhachHang qlKhachHang = new QuanLyKhachHang();
    List<QuanLyKhachHang> service = new ArrayList<>();
    DefaultTableModel mol = new DefaultTableModel();
    List<Model_KhachHang> listKH = new ArrayList<>();
    int index = -1;
    String maKH = "";
    
    public KhachHangView() {
        initComponents();
        fillTable();
        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
//                timKiem(); // Gọi hàm tìm kiếm khi có thay đổi trong ô tìm kiếm
            }
        });
    }
//private void timKiem(){
//           String searchtenNV = txt_timKiem.getText().trim();
//        DefaultTableModel searchModel = new DefaultTableModel();
//        searchModel = (DefaultTableModel) tbl_KhachHang.getModel();
//        searchModel.setRowCount(0);
//
//        for (Model_KhachHang kh : listKH) {
//            if (kh.getTenKH().toLowerCase().contains(searchtenNV.toLowerCase())) {
//                searchModel.addRow(new Object[]{
//                    kh.getId(),
//                    kh.getMakh(),
//                    kh.getTenKH(),
//                    kh.getSdt(),
//                    kh.getEmail(),
//                    kh.getDiachi(),
//                    kh.getNgaysinh(),
//                    kh.getTrangthai()
//                }
//                );
//
//            }
//        }
//        tbl_KhachHang.setModel(searchModel);
//
//}
    void fillTable() {
        mol = (DefaultTableModel) tbl_KhachHang.getModel();
        mol.setRowCount(0);
        for (Model_KhachHang kh : qlKhachHang.getAll()) {
            Object dataRow[] = new Object[8];
            dataRow[0] = kh.getId();
            dataRow[1] = kh.getMakh();
            dataRow[2] = kh.getTenKH();
            dataRow[3] = kh.getSdt();
            dataRow[4] = kh.getEmail();
            dataRow[5] = kh.getDiachi();
            dataRow[6] = kh.getNgaysinh();
            dataRow[7] = kh.getTrangthai();
            mol.addRow(dataRow);

        }
    }

    public void showData(int index) {
        Model_KhachHang kh = qlKhachHang.getAll().get(index);
        txt_Id.setText(Integer.toString(kh.getId()));
        txt_MaKhachHang.setText(kh.getMakh());
        txt_tenKhachHang.setText(kh.getTenKH());
        txt_soDienThoai.setText(kh.getSdt());
        txt_email.setText(kh.getEmail());
        txt_diaChi.setText(kh.getDiachi());
        txt_ngaySinh.setText(kh.getNgaysinh());
        txt_trangThai.setText(kh.getTrangthai());

    }

    Model_KhachHang readForm() {

        String makh = txt_MaKhachHang.getText().replaceAll("\\s", "");
        String tenkh = txt_tenKhachHang.getText();
        String sodt = txt_soDienThoai.getText();
        String email = txt_email.getText();
        String diachi = txt_diaChi.getText();
        String ngaySinh = txt_ngaySinh.getText();
        String trangThai = txt_trangThai.getText();
        return new Model_KhachHang(makh, tenkh, sodt, email, diachi, ngaySinh, trangThai);
    }

    public boolean checkValidate() {
        if (txt_MaKhachHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã không được để trống");
            return false;
        }
        if (qlKhachHang.isMaKhachHangDuplicated(txt_MaKhachHang.getText())){
            JOptionPane.showMessageDialog(this, "Mã Đã Tồn Tại");
            return false;
        }
        
        if (txt_tenKhachHang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return false;
        }
        if (txt_diaChi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "địa chỉ không được để trống");
            return false;
        }
        if (txt_email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống");
            return false;
        }
        if (!txt_email.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
            return false;
        }
        if (txt_soDienThoai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại rỗng");
            return false;
        } else {
            if (!txt_soDienThoai.getText().trim().matches("^(\\\\+?84|0)(3[2-9]|5[2689]|7[06789]|8[1-9]|9[0-9])([0-9]{7})$")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại sai định dạng");
                return false;
            }
        }
        if (txt_trangThai.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "trạng thái trống");
        }
        return true;
    }

    public void cleanForm() {
        txt_timKiem.setText("");
        txt_MaKhachHang.setText("");
        txt_tenKhachHang.setText("");
        txt_diaChi.setText("");
        txt_email.setText("");
        txt_ngaySinh.setText("");
        txt_soDienThoai.setText("");
        txt_trangThai.setText("");
        txt_Id.setText("");
    }

    private void filter(String query){
        TableRowSorter<DefaultTableModel> tr = new
        TableRowSorter<DefaultTableModel>(mol);
        tbl_KhachHang.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KhachHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_MaKhachHang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_tenKhachHang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_soDienThoai = new javax.swing.JTextField();
        txt_trangThai = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_diaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_ngaySinh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tbl_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Email", "Địa Chỉ", "Ngày Sinh", "Trạng Thái"
            }
        ));
        tbl_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachHangMouseClicked(evt);
            }
        });
        tbl_KhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_KhachHangKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KhachHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel9.setText("Trạng Thái");

        jLabel2.setText("ID");

        txt_Id.setEditable(false);

        jLabel3.setText("Mã Khách Hàng");

        jLabel4.setText("Tên Khách Hàng");

        jLabel5.setText("Số Điện Thoại");

        jLabel6.setText("Email");

        jLabel7.setText("Địa Chỉ");

        jLabel8.setText("Ngày Sinh");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tìm Kiếm khách hàng");

        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });
        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_Them.setBackground(new java.awt.Color(204, 255, 255));
        btn_Them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/plus.png"))); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Update.setBackground(new java.awt.Color(204, 255, 255));
        btn_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/diskette.png"))); // NOI18N
        btn_Update.setText("Sửa");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(204, 255, 255));
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/delete.png"))); // NOI18N
        btn_delete.setText("Xóa");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(204, 255, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/circular.png"))); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_reset)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btn_Them)
                .addGap(18, 18, 18)
                .addComponent(btn_Update)
                .addGap(18, 18, 18)
                .addComponent(btn_delete)
                .addGap(18, 18, 18)
                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_MaKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tenKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soDienThoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(140, 140, 140)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(71, 71, 71))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_email)
                            .addComponent(txt_diaChi)
                            .addComponent(txt_ngaySinh)
                            .addComponent(txt_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_ngaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
//        Model_KhachHang kh = this.readForm();
//        if (qlKhachHang.addNV(kh) > 0) {
//            JOptionPane.showMessageDialog(this, "thêm thành công");
//            fillTable();
//        } else {
//            JOptionPane.showMessageDialog(this, "thêm thất bại");
//        }

        int luachon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thêm");
        if (luachon == 0) {
            if (checkValidate()) {
                Model_KhachHang kh = this.readForm();
                if (qlKhachHang.checkTrungMa(kh.getMakh()) != null) {
                    JOptionPane.showMessageDialog(this, "Ma trung khong them duoc");
                } else {
                    if (qlKhachHang.addNV(kh) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        fillTable();
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                        cleanForm();
                        return;
                    }
                }
            }

        }
        if (luachon == 1) {
            return;
        }
        if (luachon == 2) {
            cleanForm();
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void tbl_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachHangMouseClicked
        // TODO add your handling code here:
        index = tbl_KhachHang.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tbl_KhachHangMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        index = tbl_KhachHang.getSelectedRow();
        //        int MaKH = Integer.parseInt( tbl_KhachHang.getValueAt(index, 1).toString());
        String MaKH = tbl_KhachHang.getValueAt(index, 1).toString();
        if (qlKhachHang.delete(MaKH) < 0) {
            JOptionPane.showConfirmDialog(this, "bạn có muốn xóa không ? ");
            return;
        } else {
            JOptionPane.showConfirmDialog(this, "bạn có muốn xóa không ? ");
            JOptionPane.showMessageDialog(this, "xóa thành công");
            fillTable();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        // TODO add your handling code here:
        int index = tbl_KhachHang.getSelectedRow();
        String MaKH = tbl_KhachHang.getValueAt(index, 1).toString();
        Model_KhachHang kh = this.readForm();
        if (qlKhachHang.update(kh, MaKH) > 0) {
            JOptionPane.showMessageDialog(this, "Đã Sửa");
            fillTable();
        } else {
            JOptionPane.showMessageDialog(this, "sửa thất bại");
        }
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void tbl_KhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_KhachHangKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_tbl_KhachHangKeyReleased

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        cleanForm();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_timKiemActionPerformed

    private void txt_timKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyReleased
        // TODO add your handling code here:
        String query = txt_timKiem.getText();
        filter(query);
    }//GEN-LAST:event_txt_timKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_reset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_KhachHang;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_MaKhachHang;
    private javax.swing.JTextField txt_diaChi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_ngaySinh;
    private javax.swing.JTextField txt_soDienThoai;
    private javax.swing.JTextField txt_tenKhachHang;
    private javax.swing.JTextField txt_timKiem;
    private javax.swing.JTextField txt_trangThai;
    // End of variables declaration//GEN-END:variables
}
