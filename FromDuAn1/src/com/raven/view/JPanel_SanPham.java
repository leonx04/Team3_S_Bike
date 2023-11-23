package com.raven.view;

import com.raven.model.Model_BanhXe;
import com.raven.model.Model_ChiTietSanPham;
import com.raven.model.Model_GhiDong;
import com.raven.model.Model_HeThongTruyenDong;
import com.raven.model.Model_KhungXe;
import com.raven.model.Model_LopXe;
import com.raven.model.Model_MauSac;
import com.raven.model.Model_PhanhXe;
import com.raven.model.Model_SanPham;
import com.raven.model.Model_Thuonghieu;
import com.raven.repository.BanhXe_repository;
import com.raven.repository.ChiTietSanPham_repository;
import com.raven.repository.GhiDong_repository;
import com.raven.repository.HeThongTruyenDong_repository;
import com.raven.repository.KhungXe_repository;
import com.raven.repository.LopXe_repository;
import com.raven.repository.MauSac_repository;
import com.raven.repository.PhanhXe_repository;
import com.raven.repository.SanPham_responsitory;

import com.raven.repository.ThuongHieu_repository;
import com.raven.swing.XImage;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class JPanel_SanPham extends javax.swing.JPanel {

    private DefaultTableModel model1 = new DefaultTableModel();
    private DefaultTableModel model2 = new DefaultTableModel();
    private DefaultTableModel model3 = new DefaultTableModel();
    private SanPham_responsitory sp_rs = new SanPham_responsitory();
    private ChiTietSanPham_repository ctsp = new ChiTietSanPham_repository();
    private ThuongHieu_repository rsTH = new ThuongHieu_repository();
    private BanhXe_repository rsBX = new BanhXe_repository();
    private GhiDong_repository rsGD = new GhiDong_repository();
    private KhungXe_repository rsKX = new KhungXe_repository();
    private LopXe_repository rsLX = new LopXe_repository();
    private HeThongTruyenDong_repository rsHTTD = new HeThongTruyenDong_repository();
    private PhanhXe_repository rsPX = new PhanhXe_repository();
    private MauSac_repository rsMS = new MauSac_repository();
    private int index = -1;
    JFileChooser fileChooser = new JFileChooser();

    /**
     * Creates new form NewJPanel
     */
    public JPanel_SanPham() {
        initComponents();
        this.fillTable1(sp_rs.getALLSP());
        this.fillTable2(ctsp.getALLCTSP());
//        this.fillTable3()

        initTH();
    }

    void fillTable1(List<Model_SanPham> list) {
        model1 = (DefaultTableModel) tblSanPham.getModel();
        model1.setRowCount(0);
        sortSTTColumn();
        for (Model_SanPham s : list) {
            model1.addRow(s.toData());
        }
    }

    void fillTable2(List<Model_ChiTietSanPham> list) {
        model2 = (DefaultTableModel) tblCTSP.getModel();
        model2.setRowCount(0);
        Cbo_ThuongHieu();
        Cbo_BanhXe();
        Cbo_MauSac();
        Cbo_GhiDong();
        Cbo_KhungXe();
        Cbo_LipXe();
        Cbo_LopXe();
        Cbo_PhanhXe();
        sortSTTColumn2();
        for (Model_ChiTietSanPham ctsp : list) {
            model2.addRow(ctsp.toData2());
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

        if (trangThai.equals("Đang hoạt động")) {
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
            sp.setTrangThai("Đang hoạt động");
        } else {
            sp.setTrangThai("Ngừng bán");
        }
        return sp;
    }

    // Trong phương thức read2 của lớp JPanel_SanPham
    Model_ChiTietSanPham read2() {
        Model_ChiTietSanPham ct = new Model_ChiTietSanPham();

        ct.setMaCTSP(txtMaCTSP.getText());
        ct.setHinhAnhXe(lblHinhAnh.getText());
        ct.setSoLuong(Integer.parseInt(txtSoLuongCTSP.getText()));
        ct.setGiaTien(new BigDecimal(txtGiaTien.getText()));

        Model_Thuonghieu th = rsTH.getTenThuongHieu(cboThuongHieu.getSelectedItem().toString());
        ct.setThuongHieu(th);

        String ghiDong = (String) cboGhiDong.getSelectedItem();
        Model_GhiDong gd = rsGD.getTenGhiDong(ghiDong);
        ct.setGhiDong(gd);

        Model_HeThongTruyenDong mdHTTD = rsHTTD.getTenLip(cboLipXe.getSelectedItem().toString());
        ct.setLoaiLip(mdHTTD);
        String khungXe = (String) cboKhungXe.getSelectedItem();
        Model_KhungXe kx = rsKX.getTenKhungXe(khungXe);
        ct.setTenKhungXe(kx);

        String lopXe = (String) cboLopXe.getSelectedItem();
        Model_LopXe lx = rsLX.getFilTenLopXe(lopXe);
        ct.setTenLopXe(lx);

        String phanhXe = (String) cboPhanhXe.getSelectedItem();
        Model_PhanhXe px = rsPX.getFillTenPhanhXe(phanhXe);
        ct.setTenPhanhXe(px);

        String banhXe = (String) cboBanhXe.getSelectedItem();
        Model_BanhXe bx = rsBX.getfillTenBanhXe(banhXe);
        ct.setTenBanhXe(bx);

        String mauSac = (String) cboMauSac.getSelectedItem();
        Model_MauSac ms = rsMS.getFillTenMS(mauSac);
        ct.setMauSac(ms);

        return ct;
    }

    void showData2(int index) {
        String maCTSP = tblCTSP.getValueAt(index, 1).toString().trim();
        String HinhAnh = tblCTSP.getValueAt(index, 2).toString().trim();
        String SoLuong = tblCTSP.getValueAt(index, 3).toString().trim();
        String GiaTien = tblCTSP.getValueAt(index, 4).toString().trim();
        String ThuongHieu = tblCTSP.getValueAt(index, 5).toString().trim();
        String MauSac = tblCTSP.getValueAt(index, 6).toString().trim();
        String GhiDong = tblCTSP.getValueAt(index, 7).toString().trim();
        String HTTD = tblCTSP.getValueAt(index, 8).toString().trim();
        String KhungXe = tblCTSP.getValueAt(index, 9).toString().trim();
        String LopXe = tblCTSP.getValueAt(index, 10).toString().trim();
        String PhanhXe = tblCTSP.getValueAt(index, 11).toString().trim();
        String BanhXe = tblCTSP.getValueAt(index, 12).toString().trim();
        txtMaCTSP.setText(maCTSP);
        txtSoLuongCTSP.setText(SoLuong);
        txtGiaTien.setText(GiaTien);
        cboMauSac.setSelectedItem(MauSac);
        cboThuongHieu.setSelectedItem(ThuongHieu);
        cboGhiDong.setSelectedItem(GhiDong);
        cboLipXe.setSelectedItem(GhiDong);
        cboKhungXe.setSelectedItem(KhungXe);
        cboLopXe.setSelectedItem(LopXe);
        cboPhanhXe.setSelectedItem(PhanhXe);
        cboBanhXe.setSelectedItem(BanhXe);
        lblHinhAnh.setText(HinhAnh);

    }

    void clear1() {
        txtMaSP.setText(null);
        txtMaHex.setText(null);
        txtModel.setText(null);
        txtSoLuong.setText(null);
        txtTenSP.setText(null);

    }

    void clear2() {
        txtMaCTSP.setText(null);
        txtSoLuongCTSP.setText(null);
        txtGiaTien.setText(null);
    }

    void Cbo_MauSac() {
        List<Model_MauSac> listTH = rsMS.getAllMS();
        String[] cbo = new String[listTH.size()];
        for (int i = 0; i < listTH.size(); i++) {
            cbo[i] = listTH.get(i).getTenMS();
        }
        cboMauSac.setModel(new DefaultComboBoxModel<>(cbo));
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

    void openMauSac() {
        new MauSac_JFrame().setVisible(true);

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

    void chonAnh() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.save(file); // lưu hình vào thư mục logs
            ImageIcon icon = XImage.read(file.getName()); // đọc hình từ logos
            lblHinhAnh.setIcon(icon);
            lblHinhAnh.setToolTipText(file.getName()); // giữ tên hình trong tooltip
        }
    }

    public void initTH() {
        sortSTTColumn3();
        fillTH();
    }

    public void fillTH() {
        ThuongHieu_repository THrs = new ThuongHieu_repository();
        rdoThuongHieu.setSelected(true);
        model3 = (DefaultTableModel) this.tblTT.getModel();
        model3.setRowCount(0);
        sortSTTColumn3();
        List<Model_Thuonghieu> TH = THrs.getAllTH();
        for (Model_Thuonghieu Th : TH) {
            model3.addRow(Th.toData());
        }
    }

    public void fillMS() {
        MauSac_repository MSrs = new MauSac_repository();
        model3 = (DefaultTableModel) this.tblTT.getModel();
        model3.setRowCount(0);
        sortSTTColumn3();
        List<Model_MauSac> MS = MSrs.getAllMS();
        for (Model_MauSac ms : MS) {
            model3.addRow(ms.toData());
        }
    }

    public void fillPX() {
        PhanhXe_repository PSrs = new PhanhXe_repository();
        model3 = (DefaultTableModel) this.tblTT.getModel();
        model3.setRowCount(0);
        sortSTTColumn3();
        List<Model_PhanhXe> px = PSrs.getAllPX();
        for (Model_PhanhXe PX : px) {
            model3.addRow(PX.toData());
        }
    }

    public void fillGD() {
        GhiDong_repository GDrs = new GhiDong_repository();
        model3 = (DefaultTableModel) this.tblTT.getModel();
        model3.setRowCount(0);
        sortSTTColumn3();
        List<Model_GhiDong> GD = GDrs.getAllGD();
        for (Model_GhiDong gd : GD) {
            model3.addRow(gd.toData());
        }
    }

    public void fillLX() {
        LopXe_repository LXrs = new LopXe_repository();
        model3 = (DefaultTableModel) this.tblTT.getModel();
        model3.setRowCount(0);
        sortSTTColumn3();
        List<Model_LopXe> LX = LXrs.getAllLX();
        for (Model_LopXe lx : LX) {
            model3.addRow(lx.toData());
        }
    }

    public void fillKX() {
        KhungXe_repository KXrs = new KhungXe_repository();
        model3 = (DefaultTableModel) this.tblTT.getModel();
        model3.setRowCount(0);
        sortSTTColumn3();
        List<Model_KhungXe> KX = KXrs.getAllKX();
        for (Model_KhungXe px : KX) {
            model3.addRow(px.toData());
        }
    }

    public void fillBX() {
        BanhXe_repository BXrs = new BanhXe_repository();
        model3 = (DefaultTableModel) this.tblTT.getModel();
        model3.setRowCount(0);
        sortSTTColumn3();
        List<Model_BanhXe> BX = BXrs.getAllBX();
        for (Model_BanhXe bx : BX) {
            model3.addRow(bx.toData());
        }
    }

    public void fillHTTD() {
        HeThongTruyenDong_repository HTTDrs = new HeThongTruyenDong_repository();
        model3 = (DefaultTableModel) this.tblTT.getModel();
        model3.setRowCount(0);
        sortSTTColumn3();
        List<Model_HeThongTruyenDong> HTTD = HTTDrs.getAllHTTD();
        for (Model_HeThongTruyenDong httd : HTTD) {
            model3.addRow(httd.toData());
        }
    }

    private void filter(String querry) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model1);
        tblSanPham.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(querry));
    }

    private void filterTT(String querry) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model3);
        tblTT.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(querry));
    }

    private void filterCTSP(String querry) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model2);
        tblCTSP.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(querry));
    }

    private boolean checkInputs() {
        if (txtMaSP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm!");
            txtMaSP.requestFocus();
            return false;
        }

        if (txtTenSP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm!");
            txtTenSP.requestFocus();
            return false;
        }

        if (txtMaHex.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hex!");
            txtMaHex.requestFocus();
            return false;
        }

        if (txtModel.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập model!");
            txtModel.requestFocus();
            return false;
        }

        if (txtSoLuong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng!");
            txtSoLuong.requestFocus();
            return false;
        }

        return true;
    }

    public boolean checkTT() {
        if (txtMaTT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã thuộc tính!");
            txtMaTT.requestFocus();
            return false;
        }
        if (txtTenTT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên thuộc tính!");
            txtTenTT.requestFocus();
            return false;
        }
        return true;
    }

    public boolean checkCTSP() {
        if (txtMaCTSP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã chi tiết sản phẩm!");
            txtMaCTSP.requestFocus();
            return false;
        }
        if (txtSoLuongCTSP.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng!");
            txtSoLuongCTSP.requestFocus();
            return false;
        }
        if (txtGiaTien.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá tiền!");
            txtGiaTien.requestFocus();
            return false;
        }

        return true;
    }

    public void sortSTTColumn() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblSanPham.getModel());
        tblSanPham.setRowSorter(sorter);

        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    public void sortSTTColumn2() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblCTSP.getModel());
        tblCTSP.setRowSorter(sorter);

        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    public void sortSTTColumn3() {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblTT.getModel());
        tblTT.setRowSorter(sorter);

        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));

        sorter.setSortKeys(sortKeys);
        sorter.sort();
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
        txtTimKiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTSP = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtMaCTSP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuongCTSP = new javax.swing.JTextField();
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        cboMauSac = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtTimKiemCTSP = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtMaTT = new javax.swing.JTextField();
        txtTenTT = new javax.swing.JTextField();
        txtTimKiemTT = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        rdoThuongHieu = new javax.swing.JRadioButton();
        rdoGhiDong = new javax.swing.JRadioButton();
        rdoLipXe = new javax.swing.JRadioButton();
        rdoLopXe = new javax.swing.JRadioButton();
        rdoPhanhXe = new javax.swing.JRadioButton();
        rdoBanhXe = new javax.swing.JRadioButton();
        rdoMauSac = new javax.swing.JRadioButton();
        rdoKhungXe = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        btnThemTT = new javax.swing.JButton();
        btnUpdateTT = new javax.swing.JButton();
        btnDeleteTT = new javax.swing.JButton();
        btnClearTT = new javax.swing.JButton();
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
        rdoConHang.setText("Đang bán");

        buttonGroup1.add(rdoHetHang);
        rdoHetHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoHetHang.setText("Ngừng bán");

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tblSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Mã hex", "Model", "Số Lượng", "Trạng thái"
            }
        ));
        tblSanPham.setGridColor(new java.awt.Color(204, 204, 204));
        tblSanPham.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tblSanPham.setShowGrid(true);
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
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Nhập thông tin bất kỳ");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Trạng thái");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiem)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel6))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabSP.addTab("Sản phẩm", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1331, 847));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        tblCTSP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã CTSP", "Hình ảnh", "Số lượng", "Giá tiền", "Thương hiệu", "Màu sắc", "Ghi đông", "Líp xe", "Khung xe", "Lốp xe", "Phanh xe", "Bánh xe"
            }
        ));
        tblCTSP.setGridColor(new java.awt.Color(204, 204, 204));
        tblCTSP.setPreferredSize(new java.awt.Dimension(975, 100));
        tblCTSP.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblCTSP.setShowGrid(true);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(204, 204, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(1320, 455));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Mã Chi tiết sản phẩm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Số lượng");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Giá tiền");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Thương hiệu");

        cboThuongHieu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboThuongHieuActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Ghi đông");

        cboGhiDong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboGhiDong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboGhiDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGhiDongActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Líp xe");

        cboLipXe.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboLipXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboLipXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLipXeActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Khung xe");

        cboKhungXe.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboKhungXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboKhungXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhungXeActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Lốp xe");

        cboLopXe.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboLopXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboLopXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLopXeActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hình ảnh sản phẩm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        lblHinhAnh.setBackground(new java.awt.Color(255, 255, 255));
        lblHinhAnh.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lblHinhAnh.setForeground(new java.awt.Color(153, 153, 255));
        lblHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinhAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/image1.png"))); // NOI18N
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

        cboPhanhXe.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboPhanhXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboPhanhXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhanhXeActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Bánh xe");

        cboBanhXe.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboBanhXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tilte 1", "Tilte 2", "Tilte 3", "Tilte 4" }));
        cboBanhXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBanhXeActionPerformed(evt);
            }
        });

        btnAddTH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Thêm hình ảnh");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Xóa hình ảnh");

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
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Màu sắc");

        cboMauSac.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cboMauSacMouseEntered(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setText("+");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Tìm kiếm");

        txtTimKiemCTSP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiemCTSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemCTSPKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiemCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jLabel16)
                    .addComponent(jLabel20))
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaCTSP)
                    .addComponent(txtSoLuongCTSP)
                    .addComponent(txtGiaTien)
                    .addComponent(cboThuongHieu, 0, 216, Short.MAX_VALUE)
                    .addComponent(cboGhiDong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboLipXe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboKhungXe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboLopXe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboPhanhXe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboBanhXe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddBanhXe, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(btnAddKhungXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddLopXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddPhanhXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddTH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddGD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddLX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel7))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtSoLuongCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9))
                            .addComponent(btnAddTH, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 32, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cboBanhXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddBanhXe, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTimKiemCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 1294, Short.MAX_VALUE))
                .addGap(0, 78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        txtTimKiemTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiemTT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTimKiemTT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemTTKeyReleased(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiemTT, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenTT, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(27, 27, 27))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chọn một thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        buttonGroup1.add(rdoThuongHieu);
        rdoThuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoThuongHieu.setText("Thương hiệu");
        rdoThuongHieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoThuongHieuActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoGhiDong);
        rdoGhiDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoGhiDong.setText("Ghi đông");
        rdoGhiDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoGhiDongActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoLipXe);
        rdoLipXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoLipXe.setText("Líp  xe");
        rdoLipXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoLipXeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoLopXe);
        rdoLopXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoLopXe.setText("Lốp xe");
        rdoLopXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoLopXeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoPhanhXe);
        rdoPhanhXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoPhanhXe.setText("Phanh xe");
        rdoPhanhXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPhanhXeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoBanhXe);
        rdoBanhXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoBanhXe.setText("Bánh xe");
        rdoBanhXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoBanhXeActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoMauSac);
        rdoMauSac.setText("Màu sắc");
        rdoMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMauSacActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoKhungXe);
        rdoKhungXe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoKhungXe.setText("Khung xe");
        rdoKhungXe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoKhungXeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoThuongHieu)
                    .addComponent(rdoGhiDong)
                    .addComponent(rdoLipXe)
                    .addComponent(rdoKhungXe))
                .addGap(108, 108, 108)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoMauSac)
                    .addComponent(rdoBanhXe)
                    .addComponent(rdoLopXe)
                    .addComponent(rdoPhanhXe))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoThuongHieu)
                    .addComponent(rdoPhanhXe))
                .addGap(28, 28, 28)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoGhiDong)
                    .addComponent(rdoLopXe))
                .addGap(37, 37, 37)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoBanhXe)
                    .addComponent(rdoKhungXe))
                .addGap(32, 32, 32)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoLipXe)
                    .addComponent(rdoMauSac))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        btnThemTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemTT.setText("Thêm ");
        btnThemTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTTActionPerformed(evt);
            }
        });

        btnUpdateTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUpdateTT.setText("Cập nhật");
        btnUpdateTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTTActionPerformed(evt);
            }
        });

        btnDeleteTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDeleteTT.setText("Xóa ");
        btnDeleteTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTTActionPerformed(evt);
            }
        });

        btnClearTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClearTT.setText("Làm mới");
        btnClearTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateTT, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(btnDeleteTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnThemTT)
                .addGap(30, 30, 30)
                .addComponent(btnUpdateTT)
                .addGap(28, 28, 28)
                .addComponent(btnDeleteTT)
                .addGap(32, 32, 32)
                .addComponent(btnClearTT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách thuộc tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblTT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã thuộc tính", "Tên thuộc tính"
            }
        ));
        tblTT.setShowGrid(true);
        tblTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTMouseClicked(evt);
            }
        });
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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        tabSP.addTab("Thuộc tính sản phẩm", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabSP))
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

    private void rdoThuongHieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoThuongHieuActionPerformed
        fillTH();
    }//GEN-LAST:event_rdoThuongHieuActionPerformed

    private void rdoPhanhXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPhanhXeActionPerformed
        fillPX();
    }//GEN-LAST:event_rdoPhanhXeActionPerformed

    private void rdoGhiDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoGhiDongActionPerformed
        fillGD();
    }//GEN-LAST:event_rdoGhiDongActionPerformed

    private void rdoLopXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLopXeActionPerformed
        fillLX();
    }//GEN-LAST:event_rdoLopXeActionPerformed

    private void rdoKhungXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoKhungXeActionPerformed
        fillKX();
    }//GEN-LAST:event_rdoKhungXeActionPerformed

    private void rdoBanhXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoBanhXeActionPerformed
        fillBX();
    }//GEN-LAST:event_rdoBanhXeActionPerformed

    private void rdoLipXeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLipXeActionPerformed
        fillHTTD();
    }//GEN-LAST:event_rdoLipXeActionPerformed

    private void rdoMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMauSacActionPerformed
        fillMS();
    }//GEN-LAST:event_rdoMauSacActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        String query = txtTimKiem.getText();
        filter(query);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTimKiemTTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemTTKeyReleased
        String query = txtTimKiemTT.getText();
        filterTT(query);
    }//GEN-LAST:event_txtTimKiemTTKeyReleased

    private void tblTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTMouseClicked
        int rowSelected = this.tblTT.getSelectedRow();
        if (model3.getRowCount() > 0 && evt.getClickCount() == 1) {
            txtMaTT.setText(this.tblTT.getValueAt(rowSelected, 1).toString().trim());
            txtTenTT.setText(this.tblTT.getValueAt(rowSelected, 2).toString().trim());

        }
    }//GEN-LAST:event_tblTTMouseClicked

    private void txtTimKiemCTSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemCTSPKeyReleased
        String query = txtTimKiemCTSP.getText();
        filterCTSP(query);
    }//GEN-LAST:event_txtTimKiemCTSPKeyReleased

    private void btnThemTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTTActionPerformed
        String MaTTDT = txtMaTT.getText();
        String TenTTDT = txtTenTT.getText();

        if (!checkTT()) {
            return;
        }
        if (rdoThuongHieu.isSelected()) {
            Model_Thuonghieu th = new Model_Thuonghieu();
            th.setMa(MaTTDT);
            th.setTenThuongHieu(TenTTDT);
            ThuongHieu_repository repo = new ThuongHieu_repository();
            if (repo.InsertTH(th) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillTH();
                Cbo_ThuongHieu();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } else if (rdoBanhXe.isSelected()) {
            Model_BanhXe bx = new Model_BanhXe();
            bx.setMaBX(MaTTDT);
            bx.setTenBanhXe(TenTTDT);
            BanhXe_repository repo = new BanhXe_repository();
            if (repo.InsertBX(bx) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillBX();
                Cbo_BanhXe();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } else if (rdoGhiDong.isSelected()) {
            Model_GhiDong gd = new Model_GhiDong();
            gd.setMaGD(MaTTDT);
            gd.setLoaiGD(TenTTDT);

            GhiDong_repository repo = new GhiDong_repository();
            if (repo.InsertGD(gd) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillGD();
                Cbo_GhiDong();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } else if (rdoMauSac.isSelected()) {
            Model_MauSac ms = new Model_MauSac();
            ms.setMaMS(MaTTDT);
            ms.setTenMS(TenTTDT);
            MauSac_repository repo = new MauSac_repository();
            if (repo.InsertMS(ms) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillMS();
                Cbo_MauSac();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } else if (rdoLopXe.isSelected()) {
            Model_LopXe lx = new Model_LopXe();
            lx.setMaLX(MaTTDT);
            lx.setTenLX(TenTTDT);
            LopXe_repository repo = new LopXe_repository();
            if (repo.InsertLX(lx) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillLX();
                Cbo_LopXe();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } else if (rdoLipXe.isSelected()) {
            Model_HeThongTruyenDong httd = new Model_HeThongTruyenDong();
            httd.setMaHTTD(MaTTDT);
            httd.setLoaiLip(TenTTDT);
            HeThongTruyenDong_repository repo = new HeThongTruyenDong_repository();
            if (repo.InsertHTTD(httd) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillHTTD();
                Cbo_LipXe();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } else if (rdoKhungXe.isSelected()) {

            Model_KhungXe kx = new Model_KhungXe();
            kx.setMaKX(MaTTDT);
            kx.setTenKhungXe(TenTTDT);

            KhungXe_repository repo = new KhungXe_repository();
            if (repo.InsertKX(kx) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillKX();
                Cbo_KhungXe();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } else if (rdoPhanhXe.isSelected()) {
            Model_PhanhXe px = new Model_PhanhXe();
            px.setMaPX(MaTTDT);
            px.setTenPhanhXe(TenTTDT);

            PhanhXe_repository repo = new PhanhXe_repository();
            if (repo.InsertPX(px) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                fillPX();
                Cbo_PhanhXe();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        }
    }//GEN-LAST:event_btnThemTTActionPerformed

    private void btnUpdateTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateTTActionPerformed

    private void btnDeleteTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteTTActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        openMauSac();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cboMauSacMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMauSacMouseEntered
        Cbo_MauSac();
    }//GEN-LAST:event_cboMauSacMouseEntered

    private void btnClearTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTTActionPerformed
        txtMaTT.setText(null);
        txtTenTT.setText(null);
    }//GEN-LAST:event_btnClearTTActionPerformed

    private void btnAddTHActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddTHActionPerformed
        // TODO add your handling code here:
        this.openThuongHieu();
    }// GEN-LAST:event_btnAddTHActionPerformed

    private void btnAddCTSPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddCTSPActionPerformed
        if (!checkCTSP()) {
            return;
        }
        try {
            ChiTietSanPham_repository repo = new ChiTietSanPham_repository();
            Model_ChiTietSanPham ct = read2();

//            // Lấy đối tượng từ combobox
//            ct.setLoaiLip((Model_HeThongTruyenDong) cboLipXe.getSelectedItem());
//            ct.setTenPhanhXe((Model_PhanhXe) cboPhanhXe.getSelectedItem());
//            ct.setTenBanhXe((Model_BanhXe) cboBanhXe.getSelectedItem());
//            ct.setGhiDong((Model_GhiDong) cboGhiDong.getSelectedItem());
//            ct.setTenKhungXe((Model_KhungXe) cboKhungXe.getSelectedItem());
//            ct.setTenLopXe((Model_LopXe) cboLopXe.getSelectedItem());
//            ct.setThuongHieu((Model_Thuonghieu) cboThuongHieu.getSelectedItem());
            if (repo.insertSP(ct) > 0) {
                fillTable2(repo.getALLCTSP());
                JOptionPane.showMessageDialog(this, "Thêm thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại!");
            }
        } catch (Exception e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi!");
        }

    }// GEN-LAST:event_btnAddCTSPActionPerformed

    private void btnUpdateCTSPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdateCTSPActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_btnUpdateCTSPActionPerformed

    private void btnClearCTSPActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnClearCTSPActionPerformed
        clear2();
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

        if (!checkInputs()) {
            return;
        }
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
        if (!checkInputs()) {
            return;
        }
        {
            Model_SanPham sp = this.read();
            SanPham_responsitory repoSP = new SanPham_responsitory();
            if (repoSP.insert(sp) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                sortSTTColumn();
                fillTable1(repoSP.getALLSP());
                this.clear1();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
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
    private javax.swing.JButton btnClearTT;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteTT;
    private javax.swing.JButton btnThemTT;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateCTSP;
    private javax.swing.JButton btnUpdateTT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboBanhXe;
    private javax.swing.JComboBox<String> cboGhiDong;
    private javax.swing.JComboBox<String> cboKhungXe;
    private javax.swing.JComboBox<String> cboLipXe;
    private javax.swing.JComboBox<String> cboLopXe;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboPhanhXe;
    private javax.swing.JComboBox<String> cboThuongHieu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JRadioButton rdoBanhXe;
    private javax.swing.JRadioButton rdoConHang;
    private javax.swing.JRadioButton rdoGhiDong;
    private javax.swing.JRadioButton rdoHetHang;
    private javax.swing.JRadioButton rdoKhungXe;
    private javax.swing.JRadioButton rdoLipXe;
    private javax.swing.JRadioButton rdoLopXe;
    private javax.swing.JRadioButton rdoMauSac;
    private javax.swing.JRadioButton rdoPhanhXe;
    private javax.swing.JRadioButton rdoThuongHieu;
    private javax.swing.JTabbedPane tabSP;
    private javax.swing.JTable tblCTSP;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblTT;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtMaCTSP;
    private javax.swing.JTextField txtMaHex;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaTT;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuongCTSP;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenTT;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemCTSP;
    private javax.swing.JTextField txtTimKiemTT;
    // End of variables declaration//GEN-END:variables
}
