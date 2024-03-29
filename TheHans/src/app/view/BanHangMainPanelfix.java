/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.view;

import app.dto.HoaDonChiTietDTO;
import app.dto.HoaDonDTO;
import app.model.ChatLieu;
import app.model.ChiTietSanPham;
import app.model.HoaDon;
import app.model.HoaDonChiTiet;
import app.model.KhachHang;
import app.model.KhuyenMai;
import app.model.NhanVien;
import app.model.Voucher;
import app.service.HoaDonChiTietService;
import app.service.HoaDonService;
import app.service.KhachHangService;
import app.service.KhuyenMaiService;
import app.service.SanPhamChiTietService;
import app.service.VoucherService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class BanHangMainPanelfix extends javax.swing.JPanel {

    private NhanVien nhanVienBanHang = MainApplicationView.getNhanVienDangNhap();
    SanPhamChiTietService spcts = new SanPhamChiTietService();
    List<ChiTietSanPham> chiTietSanPhams = spcts.getAllSPCT();
    private DefaultTableModel model = new DefaultTableModel(); // model bảng sản hẩm
    private DefaultTableModel modelGioHang = new DefaultTableModel();
    private KhachHangService khachHangService = new KhachHangService();
    private VoucherService voucherService = new VoucherService();

    HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();

    private HoaDonService hoaDonService = new HoaDonService();

    /**
     * Creates new form BanHangMainPanelfix
     */
    public BanHangMainPanelfix() {
        initComponents();
        txt_maNV.setText(nhanVienBanHang.getHoTen());
        loadToTableSPCT(spcts.getAllSPCT());
        modelGioHang = (DefaultTableModel) tbl_giohang.getModel();
        cbo_hinhthuc.removeAllItems();
        cbo_hinhthuc.addItem("Tiền Mặt");
        cbo_hinhthuc.addItem("Chuyển Khoản");

//        modelGioHang.addTableModelListener(new TableModelListener() {
//            @Override
//            public void tableChanged(TableModelEvent e) {
//                if (e.getType() == TableModelEvent.INSERT) {
//                    calculateTotal();
//                }
//            }
//        });
    }

//    private void calculateTotal() {
//        int rowCount = tbl_giohang.getRowCount();
//        if (rowCount == 0) {
//            txt_tongtien.setText(String.valueOf(0));
//            return;
//        }
//        double tongTien = 0.0;
//
//        for (int i = 0; i < rowCount; i++) {
//            // Lấy giá trị số lượng từ cột có chỉ số là 7
//            String soLuong = tbl_giohang.getValueAt(i, 8).toString();
//            // Lấy giá trị giá tiền từ cột có chỉ số là 6
//            String giaTien = tbl_giohang.getValueAt(i, 7).toString();
//
//            tongTien = (tongTien + (Integer.parseInt(soLuong) * Double.parseDouble(giaTien)));
//
//        }
//
//        System.out.println(tongTien);
//        txt_tongtien.setText(String.valueOf(tongTien));
//    }
    public void loadToTableSPCT(List<ChiTietSanPham> list) {
        model = (DefaultTableModel) tbl_sanpham.getModel();
        model.setRowCount(0);
        int i = 1;
        System.out.println(list);
        if (list != null) { // Kiểm tra xem danh sách có null hay không
            for (ChiTietSanPham ctsp : list) {
                model.addRow(new Object[]{
                    i++,
                    ctsp.getMaCTSP(),
                    ctsp.getId_SanPham(),
                    ctsp.getId_ChatLieu(),
                    ctsp.getId_Hang(),
                    ctsp.getId_KichCo(),
                    ctsp.getId_MauSac(),
                    ctsp.getGiaBan(),
                    ctsp.getSoLuongCon()
                });
            }
        }
    }

    public void loadToTableGioHang(List<ChiTietSanPham> list) {

        modelGioHang.setRowCount(0);
        int i = 1;
        if (list != null) { // Kiểm tra xem danh sách có null hay không
            for (ChiTietSanPham ctsp : list) {
                modelGioHang.addRow(new Object[]{
                    i++,
                    ctsp.getMaCTSP(),
                    ctsp.getId_SanPham(),
                    ctsp.getId_ChatLieu(),
                    ctsp.getId_Hang(),
                    ctsp.getId_KichCo(),
                    ctsp.getId_MauSac(),
                    ctsp.getGiaBan(),
                    ctsp.getSoLuongTrongGioHang()
                });
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

        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbo_mausac = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbo_chatlieu = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbo_size = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbo_danhmuc = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btn_thanhtoan = new javax.swing.JButton();
        btn_huyHD = new javax.swing.JButton();
        btnThemVoucher = new javax.swing.JButton();
        btn_ThanhToan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoadon = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_maKH = new javax.swing.JTextField();
        txt_tenKH = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        btn_customer = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_maHD = new javax.swing.JTextField();
        txt_voucher = new javax.swing.JTextField();
        txt_tongtien = new javax.swing.JTextField();
        txt_maNV = new javax.swing.JTextField();
        txt_ngaytao = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cbo_hinhthuc = new javax.swing.JComboBox<>();
        txt_tienKhachTra = new javax.swing.JTextField();
        txt_tienthua = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_tiensgg = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_ghichu = new javax.swing.JTextArea();
        txt_tienDuocGiam = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btnTinhTienThua = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_giohang = new javax.swing.JTable();
        btn_xoagh = new javax.swing.JToggleButton();

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã CTSP", "Tên SP", "Chất liệu", "Hãng", "Size", "Màu Sắc", "Giá", "Số lượng"
            }
        ));
        tbl_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanphamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_sanpham);

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        btn_search.setText("Search");

        jLabel1.setText("Màu sắc:");

        cbo_mausac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Chất liệu: ");

        cbo_chatlieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Size:");

        cbo_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Danh mục:");

        cbo_danhmuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txt_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_search)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_danhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_size, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbo_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbo_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbo_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbo_danhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        btn_thanhtoan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_thanhtoan.setText("In Hóa Đơn");

        btn_huyHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_huyHD.setText("Chờ Thanh Toán");
        btn_huyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyHDActionPerformed(evt);
            }
        });

        btnThemVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemVoucher.setText("Áp Voucher");
        btnThemVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVoucherActionPerformed(evt);
            }
        });

        btn_ThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_ThanhToan.setText("Thanh Toán");
        btn_ThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThanhToanActionPerformed(evt);
            }
        });

        tbl_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_hoadon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_huyHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_ThanhToan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_thanhtoan, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(btnThemVoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_ThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_huyHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_thanhtoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel2.setText("Mã KH: ");

        jLabel3.setText("Tên KH: ");

        jLabel4.setText("SDT: ");

        txt_sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sdtActionPerformed(evt);
            }
        });

        btn_customer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/conent/icons8-customer-22.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sdt)
                            .addComponent(txt_tenKH)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_customer)))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(txt_maKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin đơn hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel8.setText("Mã HD:");

        jLabel9.setText("Ngày tạo: ");

        jLabel10.setText("Tên NV:");

        jLabel11.setText("Tổng tiền: ");

        jLabel12.setText("Mã Khuyến Mãi");

        jLabel13.setText("Tiền sau giảm giá:");

        txt_maHD.setEnabled(false);

        txt_voucher.setEnabled(false);
        txt_voucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_voucherActionPerformed(evt);
            }
        });
        txt_voucher.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_voucherPropertyChange(evt);
            }
        });

        txt_tongtien.setEnabled(false);

        txt_maNV.setEnabled(false);

        txt_ngaytao.setEnabled(false);

        jLabel14.setText("Hình thức: ");

        jLabel15.setText("Tiền Khách Trả");

        jLabel17.setText("Tiền thừa: ");

        cbo_hinhthuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản" }));
        cbo_hinhthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_hinhthucActionPerformed(evt);
            }
        });
        cbo_hinhthuc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbo_hinhthucPropertyChange(evt);
            }
        });

        txt_tienthua.setEnabled(false);

        jLabel19.setText("Ghi chú: ");

        txt_tiensgg.setEnabled(false);

        txt_ghichu.setColumns(20);
        txt_ghichu.setRows(5);
        jScrollPane5.setViewportView(txt_ghichu);

        txt_tienDuocGiam.setEnabled(false);
        txt_tienDuocGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tienDuocGiamActionPerformed(evt);
            }
        });
        txt_tienDuocGiam.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_tienDuocGiamPropertyChange(evt);
            }
        });

        jLabel18.setText("Tiền được giảm");

        btnTinhTienThua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTinhTienThua.setText("Tính tiền thừa");
        btnTinhTienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhTienThuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel18))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_maHD, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ngaytao)
                            .addComponent(txt_tienDuocGiam)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_maNV)
                            .addComponent(txt_tongtien)
                            .addComponent(txt_voucher)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(24, 24, 24)
                        .addComponent(txt_tienKhachTra))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel19))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbo_hinhthuc, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_tiensgg)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(47, 47, 47)
                        .addComponent(txt_tienthua, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnTinhTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tienDuocGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tiensgg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_hinhthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_tienKhachTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_tienthua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnTinhTienThua)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        tbl_giohang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã CTSP", "Tên SP", "Chất Liệu", "Hãng ", "Size", "Màu Sắc", "Gía ", "Số Lượng"
            }
        ));
        tbl_giohang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_giohangMouseClicked(evt);
            }
        });
        tbl_giohang.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbl_giohangPropertyChange(evt);
            }
        });
        tbl_giohang.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                tbl_giohangVetoableChange(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_giohang);

        btn_xoagh.setText("Xoá");
        btn_xoagh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaghActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_xoagh)
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_xoagh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void btn_huyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_huyHDActionPerformed

    private void btnThemVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVoucherActionPerformed
        String maVoucher = JOptionPane.showInputDialog(this, "Vui lòng nhập mã khuyến mãi");
        if (maVoucher == null) {
            return;
        }

        if (!maVoucher.isEmpty()) {
            Voucher voucher = voucherService.findKhuyenMaiByMaKhuyenMai(maVoucher);
            tinhTienKhuyenMai(voucher);
        }
        if (txt_tienKhachTra.getText().isEmpty()) {
            return;
        }
        Double tienSauGiamGia = (Double.parseDouble(txt_tiensgg.getText().trim().toString()));
        Double tienKhachTra = Double.parseDouble(txt_tienKhachTra.getText().trim().toString());
        if (tienKhachTra > tienSauGiamGia) {
            Double tienThua = tienKhachTra - tienSauGiamGia;
            txt_tienthua.setText(tienThua.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Tiền khách trả chưa đủ còn thiếu ");
            return;
        }

    }//GEN-LAST:event_btnThemVoucherActionPerformed

    void tinhTienKhuyenMai(Voucher voucher) {
        if (voucher == null) {
            JOptionPane.showMessageDialog(this, "Mã khuyến mãi không hợp lệ");
        } else {
            Double tongTien = 0.0;
            for (ChiTietSanPham chiTietSanPhamTrongGioHang : listChiTietGioHang) {
                tongTien = tongTien + (chiTietSanPhamTrongGioHang.getGiaBan() * chiTietSanPhamTrongGioHang.getSoLuongTrongGioHang());
            }
            txt_voucher.setText(voucher.getMa());

            Double soTienDuocGiam = tongTien * ((double) voucher.getGiatri() / 100);
            txt_tienDuocGiam.setText(soTienDuocGiam.toString());
            Double tienConLai = tongTien - soTienDuocGiam;
            txt_tiensgg.setText(String.valueOf(tienConLai));
        }
    }

    private void txt_sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sdtActionPerformed

    private List<ChiTietSanPham> listChiTietGioHang = new ArrayList<>();

    private void tbl_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanphamMouseClicked
        int selectedRow = tbl_sanpham.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem có hàng nào được chọn không

            String maSP = model.getValueAt(selectedRow, 1).toString();
            String soLuongTonKhoStr = model.getValueAt(selectedRow, 8).toString();
            int soLuongTonKho = Integer.parseInt(soLuongTonKhoStr);

            String soLuongString = JOptionPane.showInputDialog("Số lượng sản phẩm muốn mua");
            int soLuong = 0;

            try {
                soLuong = Integer.parseInt(soLuongString);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Số lượng k hợp lệ");
                return;
            }
            if (soLuong < 1) {
                return;
            }
            if (soLuong > soLuongTonKho) {
                JOptionPane.showMessageDialog(this, "Số lượng không được vượt quá số lượng tồn kho. Vui lòng kiểm tra lại");
                return;
            }
            boolean found = false;
            for (ChiTietSanPham chiTietSanPhamTrongGioHang : listChiTietGioHang) {
                if (chiTietSanPhamTrongGioHang.getMaCTSP().equals(maSP)) {
                    found = true;
                    chiTietSanPhamTrongGioHang.setSoLuongTrongGioHang(chiTietSanPhamTrongGioHang.getSoLuongTrongGioHang() + soLuong);
                    break;
                }
            }
            List<ChiTietSanPham> listChiTietSanPham = spcts.getAllSPCTCoId();
            if (found == false) {
                for (ChiTietSanPham chiTietSanPham : listChiTietSanPham) {
                    if (chiTietSanPham.getMaCTSP().equals(maSP)) {
                        chiTietSanPham.setSoLuongTrongGioHang(soLuong);
                        listChiTietGioHang.add(chiTietSanPham);
                        break;
                    }
                }
            }
            Double tongTien = 0.0;
            for (ChiTietSanPham chiTietSanPhamTrongGioHang : listChiTietGioHang) {
                tongTien = tongTien + (chiTietSanPhamTrongGioHang.getGiaBan() * chiTietSanPhamTrongGioHang.getSoLuongTrongGioHang());
            }
            txt_tongtien.setText(String.valueOf(tongTien));
            String maVoucher = txt_voucher.getText();
            if (maVoucher != null) {
                maVoucher.trim();
            }
            if (!maVoucher.isEmpty()) {
                Voucher voucher = voucherService.findKhuyenMaiByMaKhuyenMai(maVoucher);
                if (voucher != null) {
                    tinhTienKhuyenMai(voucher);
                }
            } else {
                txt_tiensgg.setText(String.valueOf(tongTien));
            }

            loadToTableGioHang(listChiTietGioHang);

        }

    }//GEN-LAST:event_tbl_sanphamMouseClicked

    private void btn_xoaghActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaghActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbl_giohang.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem có hàng nào được chọn không
            DefaultTableModel modelGioHang = (DefaultTableModel) tbl_giohang.getModel();
            String maSP = modelGioHang.getValueAt(selectedRow, 1).toString();
            for (ChiTietSanPham chiTietSanPhamTrongGioHang : listChiTietGioHang) {
                if (chiTietSanPhamTrongGioHang.getMaCTSP().equals(maSP)) {
                    listChiTietGioHang.remove(chiTietSanPhamTrongGioHang);
                    break;
                }
            }
            Double tongTien = 0.0;
            for (ChiTietSanPham chiTietSanPhamTrongGioHang : listChiTietGioHang) {
                tongTien = tongTien + (chiTietSanPhamTrongGioHang.getGiaBan() * chiTietSanPhamTrongGioHang.getSoLuongTrongGioHang());
            }
            txt_tongtien.setText(String.valueOf(tongTien));

            // Có hai trường hợp/. 1 là có khuyến mãi. hai là chưa có khuyến mại á.
            String maVoucher = txt_voucher.getText().toString();
            if (!maVoucher.isEmpty()) {
                Voucher voucher = voucherService.findKhuyenMaiByMaKhuyenMai(maVoucher);
                tinhTienKhuyenMai(voucher);
            } else {
                txt_tiensgg.setText(String.valueOf(tongTien));
            }

            loadToTableGioHang(listChiTietGioHang);

        } else {
            // Hiển thị thông báo nếu không có sản phẩm nào được chọn
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm để xoá.", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaghActionPerformed

    private void btn_ThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThanhToanActionPerformed
        // TODO add your handling code here:
        // Call api tạo 1 hóa đơn. Sau đó chỉnh sửa giá trị
//        Lấy mã chi tiết sản phẩm. 
        String voucher = txt_voucher.getText();
        if (listChiTietGioHang.size() < 1) {
            JOptionPane.showMessageDialog(this, "Chưa có sản phẩm trong giỏ hàng");
            return;
        }

        if (txt_sdt.getText().trim() == "") {
            int chon = JOptionPane.showConfirmDialog(this, "Bạn muốn bỏ qua nhập số điện thoại khách hàng");
            if (chon != 0) {
                return;
            }
        }
        KhachHang khachHang = null;
        if (txt_sdt.getText().trim() != "") {
            // query getKhachHangBySdt;
//            khachHang = khachHangService.findKhachHangBySdt(txt_sdt.getText().trim());
//            if (khachHang == null) {
//                // Trường hợp này thì kệ mịa nó. Đi tạo cho 1 tài khoản bằng số điện thoại còn lại mặc kệ
//                // tạo xong thì find 
//                khachHang = khachHangService.findKhachHangBySdt(txt_sdt.getText().trim());
//            }
        }
        
        // Tính toán tổng số tiền trong giỏ hàng . 
        Double tienSauGiamGia = (Double.parseDouble(txt_tiensgg.getText().trim().toString()));
        Double tienKhachTra = Double.parseDouble(txt_tienKhachTra.getText().trim().toString());

        if (tienKhachTra < tienSauGiamGia) {
            JOptionPane.showMessageDialog(this, "Số tiền khách trả không đủ");
            return;
        }
        // Tính tiền thừa
        Double tienThuaCuaKhach = tienKhachTra - tienSauGiamGia;
        txt_tienthua.setText(tienThuaCuaKhach.toString());

        HoaDon hoaDon = new HoaDon();
        hoaDon.setIdKhachHang(1); // Truyền vào id khách hàng
        hoaDon.setIdNhanVien(nhanVienBanHang.getId());
        hoaDon.setGhiChu(txt_ghichu.getText().trim());
        hoaDon.setTienKhachTra(Double.parseDouble(txt_tienKhachTra.getText()));
        hoaDon.setTienThuaLai(Double.parseDouble(txt_tienthua.getText()));
        hoaDon.setThanhTien(Double.parseDouble(txt_tongtien.getText()));
        hoaDon.setTienSauGiamGia(Double.parseDouble(txt_tiensgg.getText()));
        if (!voucher.trim().isEmpty()) {
            Voucher voucherItem = voucherService.findKhuyenMaiByMaKhuyenMai(voucher);
           
            hoaDon.setIdVoucher(voucherItem.getId());
        }
        if (cbo_hinhthuc.getSelectedItem().toString().equalsIgnoreCase("Tiền Mặt")) {
            hoaDon.setHinhThucThanhToan("TIEN_MAT");
        } else {
            hoaDon.setHinhThucThanhToan("CHUYEN_KHOAN");
        }
        UUID uuid = UUID.randomUUID();
        String maHoaDon = uuid.toString();
        hoaDon.setMaHoaDon(maHoaDon);
        // Tạo ra hóa đơn chi tiết. 
        String maHoaDonSauKhiTao = hoaDonService.taoHoaDon(hoaDon);

        if (maHoaDonSauKhiTao == null) {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn không thành công. Vui lòng kiểm tra lại");
            return;
        }
        HoaDonDTO hoaDonSauKhiTao = hoaDonService.findHoaDonByMaHoaDon(maHoaDon);
              
        List<HoaDonChiTiet> hoaDonChiTietList = new ArrayList<>();
        // Duyệt mảng lấy giá và số lượng
        for (ChiTietSanPham chiTietSanPham : listChiTietGioHang) {
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setDonGia(chiTietSanPham.getGiaBan());
            hoaDonChiTiet.setId_CTSP(chiTietSanPham.getId());
            hoaDonChiTiet.setIdHoaDon(hoaDonSauKhiTao.getHoaDonId());
            hoaDonChiTiet.setSoLuong(chiTietSanPham.getSoLuongTrongGioHang());
            hoaDonChiTietList.add(hoaDonChiTiet);
        }
        
        System.out.println(hoaDonChiTietList);
        int kq =  hoaDonChiTietService.taoHoaDonChiTietByListHoaDonChiTiet(hoaDonChiTietList);
        if (kq > 0) {
            JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
        }else {
             JOptionPane.showMessageDialog(this, "Tạo hóa đơn không thành công");
        }

    }//GEN-LAST:event_btn_ThanhToanActionPerformed

    private void tbl_giohangPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbl_giohangPropertyChange


    }//GEN-LAST:event_tbl_giohangPropertyChange

    private void tbl_giohangVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_tbl_giohangVetoableChange

    }//GEN-LAST:event_tbl_giohangVetoableChange

    private void txt_voucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_voucherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_voucherActionPerformed

    private void txt_voucherPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_voucherPropertyChange
//            Lấy mã voucher từ database. 

    }//GEN-LAST:event_txt_voucherPropertyChange

    private void txt_tienDuocGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tienDuocGiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tienDuocGiamActionPerformed

    private void txt_tienDuocGiamPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_tienDuocGiamPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tienDuocGiamPropertyChange

    private void cbo_hinhthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_hinhthucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_hinhthucActionPerformed

    private void cbo_hinhthucPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbo_hinhthucPropertyChange

    }//GEN-LAST:event_cbo_hinhthucPropertyChange

    private void btnTinhTienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhTienThuaActionPerformed

        if (txt_tienKhachTra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền khách trả");

            return;
        }
        Double tienSauGiamGia = (Double.parseDouble(txt_tiensgg.getText().trim().toString()));
        Double tienKhachTra = Double.parseDouble(txt_tienKhachTra.getText().trim().toString());
        if (tienKhachTra > tienSauGiamGia) {
            Double tienThua = tienKhachTra - tienSauGiamGia;
            txt_tienthua.setText(tienThua.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Tiền khách trả chưa đủ còn thiếu ");
            return;
        }
    }//GEN-LAST:event_btnTinhTienThuaActionPerformed

    private void tbl_giohangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_giohangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_giohangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemVoucher;
    private javax.swing.JButton btnTinhTienThua;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton btn_customer;
    private javax.swing.JButton btn_huyHD;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JToggleButton btn_xoagh;
    private javax.swing.JComboBox<String> cbo_chatlieu;
    private javax.swing.JComboBox<String> cbo_danhmuc;
    private javax.swing.JComboBox<String> cbo_hinhthuc;
    private javax.swing.JComboBox<String> cbo_mausac;
    private javax.swing.JComboBox<String> cbo_size;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tbl_giohang;
    private javax.swing.JTable tbl_hoadon;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextArea txt_ghichu;
    private javax.swing.JTextField txt_maHD;
    private javax.swing.JTextField txt_maKH;
    private javax.swing.JTextField txt_maNV;
    private javax.swing.JTextField txt_ngaytao;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_tenKH;
    private javax.swing.JTextField txt_tienDuocGiam;
    private javax.swing.JTextField txt_tienKhachTra;
    private javax.swing.JTextField txt_tiensgg;
    private javax.swing.JTextField txt_tienthua;
    private javax.swing.JTextField txt_tongtien;
    private javax.swing.JTextField txt_voucher;
    // End of variables declaration//GEN-END:variables
}
