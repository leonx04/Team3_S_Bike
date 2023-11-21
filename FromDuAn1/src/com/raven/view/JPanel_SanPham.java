package com.raven.view;

import com.raven.model.Model_BanhXe;
import com.raven.model.Model_ChiTietSanPham;
import com.raven.model.Model_GhiDong;
import com.raven.model.Model_HeThongTruyenDong;
import com.raven.model.Model_HinhAnhXe;
import com.raven.model.Model_KhungXe;
import com.raven.model.Model_LopXe;
import com.raven.model.Model_PhanhXe;
import com.raven.model.Model_SanPham;
import com.raven.model.Model_Thuonghieu;
import com.raven.repository.BanhXe_repository;
import com.raven.repository.ChiTietSanPham_repository;
import com.raven.repository.GhiDong_repository;
import com.raven.repository.HeThongTruyenDong_repository;
import com.raven.repository.HinhAnh_repository;
import com.raven.repository.KhungXe_repository;
import com.raven.repository.LopXe_repository;
import com.raven.repository.PhanhXe_repository;
import com.raven.repository.SanPham_responsitory;

import com.raven.repository.ThuongHieu_repository;
import com.raven.swing.XImage;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JPanel_SanPham extends javax.swing.JPanel {

    private DefaultTableModel model = new DefaultTableModel();
    private SanPham_responsitory sp_rs = new SanPham_responsitory();
    private ChiTietSanPham_repository ctsp = new ChiTietSanPham_repository();
    private ThuongHieu_repository rsTH = new ThuongHieu_repository();
    private BanhXe_repository rsBX = new BanhXe_repository();
    private GhiDong_repository rsGD = new GhiDong_repository();
    private KhungXe_repository rsKX = new KhungXe_repository();
    private LopXe_repository rsLX = new LopXe_repository();
    private HeThongTruyenDong_repository rsHTTD = new HeThongTruyenDong_repository();
    private PhanhXe_repository rsPX = new PhanhXe_repository();
    private HinhAnh_repository rsHA = new HinhAnh_repository();
    private int index = -1;
    JFileChooser fileChooser = new JFileChooser();
    /**
     * Creates new form NewJPanel
     */
    public JPanel_SanPham() {
        initComponents();
        this.fillTable1(sp_rs.getALLSP());
        this.fillTable2(ctsp.getALLCTSP());
        Cbo_ThuongHieu();
        Cbo_BanhXe();
        Cbo_GhiDong();
        Cbo_KhungXe();
        Cbo_LipXe();
        Cbo_LopXe();
        Cbo_PhanhXe();
    }

    void fillTable1(List<Model_SanPham> list) {
        model = (DefaultTableModel) tblSanPham.getModel();
        model.setRowCount(0);
        for (Model_SanPham s : list) {
            model.addRow(s.toData());
        }
    }

    void fillTable2(List<Model_ChiTietSanPham> list) {
        model = (DefaultTableModel) tblCTSP.getModel();
        model.setRowCount(0);
        for (Model_ChiTietSanPham ctsp : list) {
            model.addRow(ctsp.toData2());
        }
    }

    void ShowData1(int index) {

        String maSP = tblSanPham.getValueAt(index, 1).toString().trim();
        String tenSP = tblSanPham.getValueAt(index, 2).toString().trim();
        String maHex = tblSanPham.getValueAt(index, 3).toString().trim();
        String model = tblSanPham.getValueAt(index, 4).toString().trim();
        int soLuong = Integer.parseInt(tblSanPham.getValueAt(index, 5).toString().trim());
        String trangThai = tblSanPham.getValueAt(index, 6).toString().trim();

        txtMaSP.setText(maSP);
        txtTenSP.setText(tenSP);
        txtMaHex.setText(maHex);
        txtModel.setText(model);
        txtSoLuong.setText(String.valueOf(soLuong));

        if (trangThai.equals("Hoạt động")) {
            rdoConHang.setSelected(true);
        } else {
            rdoHetHang.setSelected(true);
        }

    }

    Model_SanPham read() {
        Model_SanPham sp = new Model_SanPham();
        sp.setMaSP(txtMaSP.getText());
        sp.setTenSP(txtTenSP.getText());
        sp.setModel(txtModel.getText());
        sp.setMaCode(txtMaHex.getText());
        sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        if (rdoConHang.isSelected()) {
            sp.setTrangThai("Hoạt động");
        } else {
            sp.setTrangThai("Ngừng bán");
        }
        return sp;
    }

    Model_ChiTietSanPham read2() {
        Model_ChiTietSanPham ct = new Model_ChiTietSanPham();
        ct.setMaCTSP(txtMaCTSP.getText());
        ct.setMauSac(txtMauSac.getText());
        ct.setGiaTien(new BigDecimal(txtGiaTien.getText()));
        Model_Thuonghieu th = rsTH.getTenThuongHieu(cboThuongHieu.getSelectedItem().toString());

        Model_GhiDong gd = rsGD.getTenGhiDong(cboGhiDong.getSelectedItem().toString());

        Model_HeThongTruyenDong httd = rsHTTD.getTenLip(cboLipXe.getSelectedItem().toString());

        Model_KhungXe kx = rsKX.getTenKhungXe(cboKhungXe.getSelectedItem().toString());

        Model_LopXe lx = rsLX.getFilTenLopXe(cboLopXe.getSelectedItem().toString());

        Model_PhanhXe px = rsPX.getFillTenPhanhXe(cboPhanhXe.getSelectedItem().toString());

        Model_BanhXe bx = rsBX.getfillTenBanhXe(cboBanhXe.getSelectedItem().toString());

        Model_HinhAnhXe ha = rsHA.getTenHinhAnh(lblHinhAnh.getText().toString());

        return ct;
    }

    void showData2(int index) {
        String maCTSP = tblCTSP.getValueAt(index, 1).toString().trim();
        String mauSac = tblCTSP.getValueAt(index, 2).toString().trim();
        String giaTien = tblCTSP.getValueAt(index, 3).toString().trim();
        String thuonghieu = tblCTSP.getValueAt(index, 4).toString().trim();
        String ghiDong = tblCTSP.getValueAt(index, 5).toString().trim();
        String loaiLip = tblCTSP.getValueAt(index, 6).toString().trim();
        String khungXe = tblCTSP.getValueAt(index, 7).toString().trim();
        String lopXe = tblCTSP.getValueAt(index, 8).toString().trim();
        String phanhXe = tblCTSP.getValueAt(index, 9).toString().trim();
        String banhXe = tblCTSP.getValueAt(index, 10).toString().trim();
        String HinhAnh = tblCTSP.getValueAt(index, 11).toString().trim();

        txtMaCTSP.setText(maCTSP);
        txtMauSac.setText(mauSac);
        txtGiaTien.setText(giaTien);
        cboThuongHieu.setSelectedItem(thuonghieu);
        cboGhiDong.setSelectedItem(ghiDong);
        cboLipXe.setSelectedItem(ghiDong);
        cboKhungXe.setSelectedItem(khungXe);
        cboLopXe.setSelectedItem(lopXe);
        cboPhanhXe.setSelectedItem(phanhXe);
        cboBanhXe.setSelectedItem(banhXe);
        lblHinhAnh.setText(HinhAnh);

    }

    void clear1() {
        txtMaSP.setText(null);
        txtMaHex.setText(null);
        txtModel.setText(null);
        txtSoLuong.setText(null);
        txtTenSP.setText(null);

    }

    void Cbo_ThuongHieu() {

        List<Model_Thuonghieu> listTH = rsTH.getAllTH();
        String[] cbo = new String[listTH.size()];
        for (int i = 0; i < listTH.size(); i++) {
            cbo[i] = listTH.get(i).getTenThuongHieu();
        }
        cboThuongHieu.setModel(new DefaultComboBoxModel<>(cbo));
    }

    void Cbo_BanhXe() {
        List<Model_BanhXe> listBX = rsBX.getAllBX();
        String[] cbo = new String[listBX.size()];
        for (int i = 0; i < listBX.size(); i++) {
            cbo[i] = listBX.get(i).getTenBanhXe();
        }
        cboBanhXe.setModel(new DefaultComboBoxModel<>(cbo));
    }

    void Cbo_GhiDong() {
        List<Model_GhiDong> listGD = rsGD.getAllGD();
        String[] cbo = new String[listGD.size()];
        for (int i = 0; i < listGD.size(); i++) {
            cbo[i] = listGD.get(i).getLoaiGD();
        }
        cboGhiDong.setModel(new DefaultComboBoxModel<>(cbo));
    }

    void Cbo_KhungXe() {
        List<Model_KhungXe> listKH = rsKX.getAllKX();
        String[] cbo = new String[listKH.size()];
        for (int i = 0; i < listKH.size(); i++) {
            cbo[i] = listKH.get(i).getTenKhungXe();
        }
        cboKhungXe.setModel(new DefaultComboBoxModel<>(cbo));
    }

    void Cbo_LipXe() {
        List<Model_HeThongTruyenDong> listHTTD = rsHTTD.getAllHTTD();
        String[] cbo = new String[listHTTD.size()];
        for (int i = 0; i < listHTTD.size(); i++) {
            cbo[i] = listHTTD.get(i).getLoaiLip();
        }
        cboLipXe.setModel(new DefaultComboBoxModel<>(cbo));
    }

    void Cbo_LopXe() {
        List<Model_LopXe> listLX = rsLX.getAllLX();
        String[] cbo = new String[listLX.size()];
        for (int i = 0; i < listLX.size(); i++) {
            cbo[i] = listLX.get(i).getTenLX();
        }
        cboLopXe.setModel(new DefaultComboBoxModel<>(cbo));
    }

    void Cbo_PhanhXe() {
        List<Model_PhanhXe> listPX = rsPX.getAllPX();
        String[] cbo = new String[listPX.size()];
        for (int i = 0; i < listPX.size(); i++) {
            cbo[i] = listPX.get(i).getTenPhanhXe();
        }
        cboPhanhXe.setModel(new DefaultComboBoxModel<>(cbo));
    }

    void openThuongHieu() {
        new ThuongHieu_JFrame().setVisible(true);
    }

    void openBanhXe() {
        new BanhXe_JFrame().setVisible(true);
    }

    void openLopXe() {
        new LopXe_JFrame().setVisible(true);
    }

    void openKhungXe() {
        new KhungXe_JFrame().setVisible(true);
    }

    void openHTTD() {
        new HeThongTruyenDong_JFrame().setVisible(true);
    }

    void openGhiDong() {
        new GhiDong_JFrame().setVisible(true);
    }

    void openPhanhXe() {
        new PhanhXe_JFrame().setVisible(true);
    }
    
    void chonAnh(){
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            XImage.save(file); // lưu hình vào thư mục logs
            ImageIcon icon = XImage.read(file.getName()); // đọc hình từ logos
            lblHinhAnh.setIcon(icon);
            lblHinhAnh.setToolTipText(file.getName()); // giữ tên hình trong tooltip
        }
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel17 = new javax.swing.JLabel();
        tabSP = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaHex = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        rdoConHang = new javax.swing.JRadioButton();
        rdoHetHang = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTSP = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtMaCTSP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMauSac = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cboThuongHieu = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cboGhiDong = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboLipXe = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cboKhungXe = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cboLopXe = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cboPhanhXe = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cboBanhXe = new javax.swing.JComboBox<>();
        btnAddTH = new javax.swing.JButton();
        btnAddGD = new javax.swing.JButton();
        btnAddLX = new javax.swing.JButton();
        btnAddKhungXe = new javax.swing.JButton();
        btnAddLopXe = new javax.swing.JButton();
        btnAddPhanhXe = new javax.swing.JButton();
        btnAddBanhXe = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnAddCTSP = new javax.swing.JButton();
        btnUpdateCTSP = new javax.swing.JButton();
        btnClearCTSP = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtMaTT = new javax.swing.JTextField();
        txtTenTT = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTT = new javax.swing.JTable();

        jLabel17.setText("jLabel17");

        setBackground(new java.awt.Color(249, 249, 249));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã Sản Phẩm");

        txtMaSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên Sản Phẩm");

        txtTenSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã Hex");

        txtMaHex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAdd.setText("Thêm sản phẩm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDelete.setText("Xóa ");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClearForm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClearForm.setText("Làm mới");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addGap(27, 27, 27)
                .addComponent(btnUpdate)
                .addGap(27, 27, 27)
                .addComponent(btnDelete)
                .addGap(30, 30, 30)
                .addComponent(btnClearForm)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Số lượng");

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Trạng thái");

        buttonGroup1.add(rdoConHang);
        rdoConHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoConHang.setText("Còn hàng");

        buttonGroup1.add(rdoHetHang);
        rdoHetHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoHetHang.setText("Hết hàng");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Model");

        txtModel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel18)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHex, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdoConHang)
                        .addGap(127, 127, 127)
                        .addComponent(rdoHetHang)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel28))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txtMaHex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel29))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoConHang)
                            .addComponent(rdoHetHang))))
                .addGap(2, 2, 2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Mã hex", "Model", "Số Lượng", "Trạng thái"
            }
        ));
        tblSanPham.setGridColor(new java.awt.Color(255, 255, 255));
        tblSanPham.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/search.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tìm kiếm sản phẩm");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))))
                .addGap(31, 31, 31))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabSP.addTab("Sản phẩm", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1331, 847));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tblCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã CTSP", "Màu sắc", "Giá tiền", "Thương hiệu", "Ghi đông", "Líp xe", "Khung xe", "Lốp xe", "Phanh xe", "Bánh xe", "Hình ảnh"
            }
        ));
        tblCTSP.setGridColor(new java.awt.Color(0, 0, 0));
        tblCTSP.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tblCTSP.setSelectionForeground(new java.awt.Color(204, 204, 204));
        tblCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCTSP);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.setBackground(new java.awt.Color(204, 204, 255));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Mã Chi tiết sản phẩm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Màu sắc");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Giá tiền");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Thương hiệu");

        cboThuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuongHieuActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Ghi đông");

        cboGhiDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboGhiDong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboGhiDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGhiDongActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Líp xe");

        cboLipXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboLipXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboLipXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLipXeActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Khung xe");

        cboKhungXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboKhungXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboKhungXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhungXeActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Lốp xe");

        cboLopXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboLopXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboLopXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLopXeActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hình ảnh sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblHinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        lblHinhAnh.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        lblHinhAnh.setForeground(new java.awt.Color(153, 153, 255));
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setToolTipText("");
        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhAnhMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHinhAnhMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Phanh xe");

        cboPhanhXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboPhanhXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboPhanhXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhanhXeActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Bánh xe");

        cboBanhXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboBanhXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboBanhXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBanhXeActionPerformed(evt);
            }
        });

        btnAddTH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddTH.setText("+");
        btnAddTH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTHActionPerformed(evt);
            }
        });

        btnAddGD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddGD.setText("+");
        btnAddGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGDActionPerformed(evt);
            }
        });

        btnAddLX.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddLX.setText("+");
        btnAddLX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLXActionPerformed(evt);
            }
        });

        btnAddKhungXe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddKhungXe.setText("+");
        btnAddKhungXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKhungXeActionPerformed(evt);
            }
        });

        btnAddLopXe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddLopXe.setText("+");
        btnAddLopXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLopXeActionPerformed(evt);
            }
        });

        btnAddPhanhXe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddPhanhXe.setText("+");
        btnAddPhanhXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPhanhXeActionPerformed(evt);
            }
        });

        btnAddBanhXe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddBanhXe.setText("+");
        btnAddBanhXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBanhXeActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAddCTSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAddCTSP.setText("Thêm");
        btnAddCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCTSPActionPerformed(evt);
            }
        });

        btnUpdateCTSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdateCTSP.setText("Cập nhật");
        btnUpdateCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCTSPActionPerformed(evt);
            }
        });

        btnClearCTSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClearCTSP.setText("Làm mới");
        btnClearCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCTSPActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Xuất File Excel");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddCTSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateCTSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearCTSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnAddCTSP)
                .addGap(31, 31, 31)
                .addComponent(btnUpdateCTSP)
                .addGap(27, 27, 27)
                .addComponent(btnClearCTSP)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThuongHieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboGhiDong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLipXe, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboKhungXe, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLopXe, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPhanhXe, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBanhXe, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddBanhXe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddKhungXe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddLopXe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPhanhXe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddTH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddGD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddLX, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel7))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddTH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddGD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboGhiDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboLipXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11))
                            .addComponent(btnAddLX, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboKhungXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddKhungXe, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboLopXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(btnAddLopXe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboPhanhXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddPhanhXe, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboBanhXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(btnAddBanhXe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(0, 16, Short.MAX_VALUE))))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabSP.addTab("Chi tiết sản phẩm", jPanel2);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Thiết lập thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Mã thuộc tính");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Tên thuộc tính");

        txtMaTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaTT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtTenTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenTT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenTT, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn một thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setText("Thương hiệu");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton2.setText("Ghi đông");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton3.setText("Khung xe");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton4.setText("Líp  xe");

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton5.setText("Lốp xe");

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton6.setText("Phanh xe");

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton7.setText("Bánh xe");

        buttonGroup1.add(jRadioButton8);
        jRadioButton8.setText("Màu sắc");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(156, 156, 156)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton8)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton6))
                .addGap(28, 28, 28)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton5))
                .addGap(37, 37, 37)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton7))
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Thêm ");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Cập nhật");

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Xóa ");

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Làm mới");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton2)
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addGap(28, 28, 28)
                .addComponent(jButton4)
                .addGap(32, 32, 32)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblTT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã thuộc tính", "Tên thuộc tính"
            }
        ));
        jScrollPane3.setViewportView(tblTT);
        if (tblTT.getColumnModel().getColumnCount() > 0) {
            tblTT.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabSP.addTab("Thuộc tính sản phẩm", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabSP)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabSP)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddBanhXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBanhXeActionPerformed
        this.openBanhXe();
    }//GEN-LAST:event_btnAddBanhXeActionPerformed

    private void btnAddGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGDActionPerformed
        this.openGhiDong();
    }//GEN-LAST:event_btnAddGDActionPerformed

    private void btnAddLXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLXActionPerformed
        this.openHTTD();
    }//GEN-LAST:event_btnAddLXActionPerformed

    private void btnAddKhungXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKhungXeActionPerformed
        this.openKhungXe();
    }//GEN-LAST:event_btnAddKhungXeActionPerformed

    private void btnAddLopXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLopXeActionPerformed
        this.openLopXe();
    }//GEN-LAST:event_btnAddLopXeActionPerformed

    private void btnAddPhanhXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPhanhXeActionPerformed
        this.openPhanhXe();
    }//GEN-LAST:event_btnAddPhanhXeActionPerformed

    private void lblHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblHinhAnhMouseClicked

    private void lblHinhAnhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMousePressed
        this.chonAnh();
    }//GEN-LAST:event_lblHinhAnhMousePressed

    private void btnAddTHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddTHActionPerformed
        // TODO add your handling code here:
        this.openThuongHieu();
    }// GEN-LAST:event_btnAddTHActionPerformed

    private void btnAddCTSPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddCTSPActionPerformed

        // String thuonghieu = cboThuongHieu.getSelectedItem().toString();
        // String ghiDong = cboGhiDong.getSelectedItem().toString();
        // String Loailip = cboLipXe.getSelectedItem().toString();
        // String khungxe = cboKhungXe.getSelectedItem().toString();
        // String lopxe = cboLopXe.getSelectedItem().toString();
        // String phanhxe = cboPhanhXe.getSelectedItem().toString();
        // String banhxe = cboBanhXe.getSelectedItem().toString();
        // String hinhanh = lblHinhAnh.getText();
        Model_HeThongTruyenDong loaiLip = new Model_HeThongTruyenDong();
        Model_PhanhXe phanhXe = new Model_PhanhXe();
        Model_BanhXe banhXe = new Model_BanhXe();
        Model_Thuonghieu thuongHieu = new Model_Thuonghieu();
        Model_GhiDong ghiDong = new Model_GhiDong();
        Model_HinhAnhXe hinhAnh = new Model_HinhAnhXe();
        Model_KhungXe khungXe = new Model_KhungXe();
        Model_LopXe lopXe = new Model_LopXe();

        ChiTietSanPham_repository repo = new ChiTietSanPham_repository();
        Model_ChiTietSanPham ct = this.read2();
        ct.setLoaiLip(loaiLip);
        ct.setTenPhanhXe(phanhXe);
        ct.setTenBanhXe(banhXe);
        ct.setGhiDong(ghiDong);
        ct.setHinhAnhXe(hinhAnh);
        ct.setTenKhungXe(khungXe);
        ct.setTenLopXe(lopXe);
        ct.setThuongHieu(thuongHieu);

        if (repo.insertSP(ct) > 0) {

            fillTable2(repo.getALLCTSP());

            JOptionPane.showMessageDialog(this, "Thêm thành công!");

        } else {

            JOptionPane.showMessageDialog(this, "Thêm thất bại!");

        }

    }// GEN-LAST:event_btnAddCTSPActionPerformed

    private void btnUpdateCTSPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateCTSPActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnUpdateCTSPActionPerformed

    private void btnClearCTSPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClearCTSPActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnClearCTSPActionPerformed

    private void cboBanhXeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboBanhXeActionPerformed

    }// GEN-LAST:event_cboBanhXeActionPerformed

    private void cboPhanhXeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboPhanhXeActionPerformed

    }// GEN-LAST:event_cboPhanhXeActionPerformed

    private void cboLopXeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboLopXeActionPerformed

    }// GEN-LAST:event_cboLopXeActionPerformed

    private void cboKhungXeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboKhungXeActionPerformed

    }// GEN-LAST:event_cboKhungXeActionPerformed

    private void cboLipXeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboLipXeActionPerformed

    }// GEN-LAST:event_cboLipXeActionPerformed

    private void cboGhiDongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboGhiDongActionPerformed

    }// GEN-LAST:event_cboGhiDongActionPerformed

    private void cboThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cboThuongHieuActionPerformed

    }// GEN-LAST:event_cboThuongHieuActionPerformed

    private void tblCTSPMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblCTSPMouseClicked

        index = tblCTSP.getSelectedRow();
        this.showData2(index);
    }// GEN-LAST:event_tblCTSPMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblSanPhamMouseClicked

        index = tblSanPham.getSelectedRow();
        this.ShowData1(index);
    }// GEN-LAST:event_tblSanPhamMouseClicked

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClearFormActionPerformed

        this.clear1();
    }// GEN-LAST:event_btnClearFormActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
        Model_SanPham sp = this.read();
        String MaSP = tblSanPham.getValueAt(index, 1).toString();
        SanPham_responsitory repoSP = new SanPham_responsitory();
        if (repoSP.delete(MaSP) > 0) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            fillTable1(repoSP.getALLSP());
            this.clear1();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }

    }// GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateActionPerformed
        Model_SanPham sp = this.read();
        SanPham_responsitory repoSP = new SanPham_responsitory();
        int index = tblSanPham.getSelectedRow();
        if (repoSP.update(sp, sp.getMaSP()) > 0) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            fillTable1(repoSP.getALLSP());
            this.clear1();
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }

    }// GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
        Model_SanPham sp = this.read();
        SanPham_responsitory repoSP = new SanPham_responsitory();
        if (repoSP.insert(sp) > 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            fillTable1(repoSP.getALLSP());
            this.clear1();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }// GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddBanhXe;
    private javax.swing.JButton btnAddCTSP;
    private javax.swing.JButton btnAddGD;
    private javax.swing.JButton btnAddKhungXe;
    private javax.swing.JButton btnAddLX;
    private javax.swing.JButton btnAddLopXe;
    private javax.swing.JButton btnAddPhanhXe;
    private javax.swing.JButton btnAddTH;
    private javax.swing.JButton btnClearCTSP;
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateCTSP;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboBanhXe;
    private javax.swing.JComboBox<String> cboGhiDong;
    private javax.swing.JComboBox<String> cboKhungXe;
    private javax.swing.JComboBox<String> cboLipXe;
    private javax.swing.JComboBox<String> cboLopXe;
    private javax.swing.JComboBox<String> cboPhanhXe;
    private javax.swing.JComboBox<String> cboThuongHieu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JRadioButton rdoConHang;
    private javax.swing.JRadioButton rdoHetHang;
    private javax.swing.JTabbedPane tabSP;
    private javax.swing.JTable tblCTSP;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblTT;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaCTSP;
    private javax.swing.JTextField txtMaHex;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaTT;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenTT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
