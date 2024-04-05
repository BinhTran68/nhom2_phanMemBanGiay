package app.view;

import app.model.ChatLieu;
import app.model.ChiTietSanPham;
import app.model.Hang;
import app.model.KichCo;
import app.model.MauSac;
import app.model.SanPham;
import app.service.ChiTietSanPhamService;
import app.service.SanPhamService;
import app.service.ThuocTinhService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class SanPhamMainPanel extends javax.swing.JPanel {

    int index = -1;
    ThuocTinhService tts = new ThuocTinhService();
    SanPhamService sps = new SanPhamService();
    ChiTietSanPhamService ctspsv = new ChiTietSanPhamService();
    List<String> listLoaiThuocTinh = new ArrayList<>();

    public SanPhamMainPanel() {
        initComponents();
        fillToTableChatLieu(tts.getAllChatLieu());
        fillToTableSanPham(sps.getAllSanPham());
        fillToTableCTSP(ctspsv.getAllCTSP());
        cboLoaiThuocTinh();
        addCbo(listLoaiThuocTinh, cboLoaiThuocTinh);
        addCbo(ctspsv.getTenChatLieu(), cboChatLieu);
        addCbo(ctspsv.getTenHang(), cboHang);
        addCbo(ctspsv.getTenKichCo(), cboKichCo);
        addCbo(ctspsv.getTenMauSac(), cboMauSac);
        addCbo(ctspsv.getTenSanPham(), cboTenSP);
        rdoConBan.setSelected(false);
        rdoHetHang.setSelected(false);

    }

    private void moiCTSP() {
        txtMaSPCT.setText("");
        txtDonGia.setText("");
        txtSoLuong.setText("");
        txtMoTa.setText("");
        fillToTableCTSP(ctspsv.getAllCTSP());
        addCbo(ctspsv.getTenChatLieu(), cboChatLieu);
        addCbo(ctspsv.getTenHang(), cboHang);
        addCbo(ctspsv.getTenKichCo(), cboKichCo);
        addCbo(ctspsv.getTenMauSac(), cboMauSac);
        addCbo(ctspsv.getTenSanPham(), cboTenSP);
        rdoConBan.setSelected(false);
        rdoHetHang.setSelected(false);
        fillToTableCTSP(ctspsv.getAllCTSP());
    }

    private void cboLoaiThuocTinh() {
        listLoaiThuocTinh.add("Chất Liệu");
        listLoaiThuocTinh.add("Hãng");
        listLoaiThuocTinh.add("Kích Cỡ");
        listLoaiThuocTinh.add("Màu Sắc");
    }

    private void addCbo(List<String> list, JComboBox md) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        for (String string : list) {
            dcbm.addElement(string);
        }
        md.setModel(dcbm);
    }

    private void fillToTableSanPham(List<SanPham> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblSanPham.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (SanPham sp : list) {
            dtm.addRow(new Object[]{
                i++,
                sp.getMaSP(),
                sp.getTen(),
                sp.getTrangThaiXoa(),
                sp.getNgayTao(),
                sp.getNgaySuaCuoi()
            });
        }
    }

    private void fillToTableCTSP(List<ChiTietSanPham> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblCTSP.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (ChiTietSanPham ctsp : list) {
            dtm.addRow(new Object[]{
                i++,
                ctsp.getMaCTSP(),
                ctsp.getId_SanPham(),
                ctsp.getGiaBan(),
                ctsp.getSoLuongCon(),
                ctsp.getId_MauSac(),
                ctsp.getId_KichCo(),
                ctsp.getId_Hang(),
                ctsp.getId_ChatLieu(),
                ctsp.getNgayTao(),
                ctsp.getNgaySuaCuoi(),
                ctsp.getTrangThaiXoa(),
                ctsp.getMota(),
                ctsp.getMaVach()});

        }
    }

    private void fillToTableChatLieu(List<ChatLieu> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (ChatLieu chatLieu : list) {
            dtm.addRow(new Object[]{
                i++,
                chatLieu.getMaChatLieu(),
                chatLieu.getTen(),
                chatLieu.getTrangThaiXoa(),
                chatLieu.getNgayTao(),
                chatLieu.getNgaySuaCuoi()
            });
        }
    }

    private void fillToTableHang(List<Hang> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (Hang h : list) {
            dtm.addRow(new Object[]{
                i++,
                h.getMaHang(),
                h.getTen(),
                h.getTrangThaiXoa(),
                h.getNgayTao(),
                h.getNgaySuaCuoi()
            });
        }
    }

    private void fillToTableKichCo(List<KichCo> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (KichCo kc : list) {
            dtm.addRow(new Object[]{
                i++,
                kc.getMaKichCo(),
                kc.getTen(),
                kc.getTrangThaiXoa(),
                kc.getNgayTao(),
                kc.getNgaySuaCuoi()
            });
        }
    }

    private void fillToTableMauSac(List<MauSac> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblThuocTinh.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (MauSac ms : list) {
            dtm.addRow(new Object[]{
                i++,
                ms.getMaMauSac(),
                ms.getTen(),
                ms.getTrangThaiXoa(),
                ms.getNgayTao(),
                ms.getNgaySuaCuoi()
            });
        }
    }

    private void hienThuocTinhLenFrom(int index) {
        txtMaThuocTinh.setText(tblThuocTinh.getValueAt(index, 1).toString());
        txtTenThuocTinh.setText(tblThuocTinh.getValueAt(index, 2).toString());
        if (tblThuocTinh.getValueAt(index, 3).toString().equals("1")) {
            rdoConHang.setSelected(true);
        } else {
            rdoHet.setSelected(true);
        }
    }

    private void hienSPLenFrom(int index) {
        txtMaSanPham.setText(tblSanPham.getValueAt(index, 1).toString());
        txtTenSanPham.setText(tblSanPham.getValueAt(index, 2).toString());
        if (tblSanPham.getValueAt(index, 3).toString().equals("1")) {
            rdoDangBan.setSelected(true);
        } else {
            rdoNgungBan.setSelected(true);
        }
    }

    private void hienCTSPLenForm(int index) throws IOException {
        qr.setIcon(null);
        txtMaSPCT.setText(tblCTSP.getValueAt(index, 1).toString());
        txtDonGia.setText(tblCTSP.getValueAt(index, 3).toString());
        txtSoLuong.setText(tblCTSP.getValueAt(index, 4).toString());
        cboChatLieu.setSelectedItem(tblCTSP.getValueAt(index, 8));
        cboHang.setSelectedItem(tblCTSP.getValueAt(index, 7));
        cboKichCo.setSelectedItem(tblCTSP.getValueAt(index, 6));
        cboMauSac.setSelectedItem(tblCTSP.getValueAt(index, 5));
        cboTenSP.setSelectedItem(tblCTSP.getValueAt(index, 2));

        if (tblCTSP.getValueAt(index, 11).toString().equals("1")) {
            rdoConBan.setSelected(true);
        } else {
            rdoHetHang.setSelected(true);
        }
        txtMoTa.setText(tblCTSP.getValueAt(index, 12).toString());
        Object values = tblCTSP.getValueAt(index, 13);
        if (values != null) {
            values.toString();
            File qrCodeFile = new File((String) values);
            BufferedImage img = ImageIO.read(qrCodeFile);
            Image hinhSua = img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
            qr.setText("");

            qr.setIcon(new ImageIcon(hinhSua));
        } else {
            qr.setText("chưa có qr");
        }

    }

    private ChatLieu readFormChatLieu() {
        String ma = txtMaThuocTinh.getText();
        String ten = txtTenThuocTinh.getText();
        int trangThai;
        if (rdoConHang.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        return new ChatLieu(ma, ten, trangThai);
    }

    private Hang readFormHang() {
        String ma = txtMaThuocTinh.getText();
        String ten = txtTenThuocTinh.getText();

        int trangThai;
        if (rdoConHang.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        return new Hang(ma, ten, trangThai);
    }

    private KichCo readFormKichCo() {
        String ma = txtMaThuocTinh.getText();
        String ten = txtTenThuocTinh.getText();
       
        int trangThai;
        if (rdoConHang.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        return new KichCo(ma, ten, trangThai);
    }

    private SanPham readFormSanPham() {
        String ma = txtMaSanPham.getText();
        String ten = txtTenSanPham.getText();
        int trangThai;
        if (rdoDangBan.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        return new SanPham(ma, ten, trangThai);
    }

    private MauSac readFormMauSac() {
        String ma = txtMaThuocTinh.getText();
        String ten = txtTenThuocTinh.getText();
      
        int trangThai;
        if (rdoConHang.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        return new MauSac(ma, ten, trangThai);
    }

    private ChiTietSanPham readCTSP() {

        String maCTSP = txtMaSPCT.getText();
        String id_SanPham = String.valueOf(ctspsv.getIDSanPham(cboTenSP.getSelectedItem().toString()));
        double giaBan = Double.parseDouble(txtDonGia.getText());
        int soLuongCon = Integer.parseInt(txtSoLuong.getText());
        String id_MauSac = String.valueOf(ctspsv.getIDMauSac(cboMauSac.getSelectedItem().toString()));
        String id_KichCo = String.valueOf(ctspsv.getIDKichCo(cboKichCo.getSelectedItem().toString()));
        String id_Hang = String.valueOf(ctspsv.getIDHang(cboHang.getSelectedItem().toString()));
        String id_ChatLieu = String.valueOf(ctspsv.getIDChatLieu(cboChatLieu.getSelectedItem().toString()));
        int trangThaiXoa;
        if (rdoConBan.isSelected()) {
            trangThaiXoa = 1;
        } else {
            trangThaiXoa = 0;
        }
        String mota = txtMoTa.getText();
        String maVach = null;
        ChiTietSanPham ctsp = new ChiTietSanPham(maCTSP, id_SanPham, giaBan, soLuongCon, id_MauSac, id_KichCo, id_Hang, id_ChatLieu, trangThaiXoa, mota, maVach);
        System.out.println("" + ctsp.toString());
        return ctsp;
    }

    private void themThuocTinh() {
        String thuocTinhDangChon = cboLoaiThuocTinh.getSelectedItem().toString();
        switch (thuocTinhDangChon) {
            case "Chất Liệu":
                int check1 = JOptionPane.showConfirmDialog(this, "bạn muốn thêm chất liệu không");
                String ma = txtMaThuocTinh.getText().trim();
                String ten = txtTenThuocTinh.getText().trim();
                if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", ma)) {
                    JOptionPane.showMessageDialog(this, "mã chất liệu là chữ ko dấu ít hơn 20 kí tự");
                    return;
                }
                if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ ]{1,30}$", ten)) {
                    JOptionPane.showMessageDialog(this, "tên chất liệu là chữ ít hơn 30 kí tự");
                    return;
                }
                if (tts.kiemTraTrungMaChatLieu(ma)) {
                    JOptionPane.showMessageDialog(this, "trùng mã");
                    return;
                }
                if (tts.kiemTraTrungTenChatLieu(ten)) {
                    JOptionPane.showMessageDialog(this, "trùng tên");
                    return;
                }
                if (check1 == JOptionPane.YES_OPTION) {
                    if (tts.addChatLieu(readFormChatLieu()) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm Chất Liệu Thành Công");
                        fillToTableChatLieu(tts.getAllChatLieu());
                        addCbo(ctspsv.getTenChatLieu(), cboChatLieu);
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm Chất Liệu Thất bại");
                    }
                }

                break;
            case "Hãng":
                int check2 = JOptionPane.showConfirmDialog(this, "bạn muốn thêm Hãng không");
                String ma1 = txtMaThuocTinh.getText().trim();
                String ten1 = txtTenThuocTinh.getText().trim();
                if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", ma1)) {
                    JOptionPane.showMessageDialog(this, "mã hãng là chữ ko dấu ít hơn 20 kí tự");
                    return;
                }
                if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ ]{1,30}$", ten1)) {
                    JOptionPane.showMessageDialog(this, "tên hãng là chữ ít hơn 30 kí tự");
                    return;
                }
                if (tts.kiemTraTrungMaHang(ma1)) {
                    JOptionPane.showMessageDialog(this, "trùng mã");
                    return;
                }
                if (tts.kiemTraTrungTenHang(ten1)) {
                    JOptionPane.showMessageDialog(this, "trùng tên");
                    return;
                }
                if (check2 == JOptionPane.YES_OPTION) {
                    if (tts.addHang(readFormHang()) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm Hãng Thành Công");
                        fillToTableHang(tts.getAllHang());
                        addCbo(ctspsv.getTenHang(), cboHang);
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm Hãng Thất bại");
                    }
                }

                break;
            case "Kích Cỡ":
                int check3 = JOptionPane.showConfirmDialog(this, "bạn muốn thêm kích cỡ không");
                String ma2 = txtMaThuocTinh.getText().trim();
                String ten2 = txtTenThuocTinh.getText().trim();
                if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", ma2)) {
                    JOptionPane.showMessageDialog(this, "mã kích cỡ là chữ ko dấu ít hơn 20 kí tự");
                    return;
                }
                if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ ]{1,30}$", ten2)) {
                    JOptionPane.showMessageDialog(this, "tên kích cỡ là chữ ít hơn 30 kí tự");
                    return;
                }
                if (tts.kiemTraTrungMaKichCo(ma2)) {
                    JOptionPane.showMessageDialog(this, "trùng mã");
                    return;
                }
                if (tts.kiemTraTrungTenKichCo(ten2)) {
                    JOptionPane.showMessageDialog(this, "trùng tên");
                    return;
                }
                if (check3 == JOptionPane.YES_OPTION) {
                    if (tts.addKichCo(readFormKichCo()) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm Kích Cỡ Thành Công");
                        fillToTableKichCo(tts.getAllKichCo());
                        addCbo(ctspsv.getTenKichCo(), cboKichCo);
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm Kích cỡ Thất bại");
                    }
                }

                break;
            case "Màu Sắc":
                int check4 = JOptionPane.showConfirmDialog(this, "bạn muốn thêm Màu sắc không");
                String ma3 = txtMaThuocTinh.getText().trim();
                String ten3 = txtTenThuocTinh.getText().trim();
                if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", ma3)) {
                    JOptionPane.showMessageDialog(this, "mã màu sắc là chữ ko dấu ít hơn 20 kí tự");
                    return;
                }
                if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ .-_0-9]{1,30}$", ten3)) {
                    JOptionPane.showMessageDialog(this, "tên màu sắc là chữ ít hơn 30 kí tự");
                    return;
                }
                if (tts.kiemTraTrungMaMauSac(ma3)) {
                    JOptionPane.showMessageDialog(this, "trùng mã");
                    return;
                }
                if (tts.kiemTraTrungTenMauSac(ten3)) {
                    JOptionPane.showMessageDialog(this, "trùng tên");
                    return;
                }
                if (check4 == JOptionPane.YES_OPTION) {
                    if (tts.addMauSac(readFormMauSac()) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm Màu Sắc Thành Công");
                        fillToTableMauSac(tts.getAllMauSac());
                        addCbo(ctspsv.getTenMauSac(), cboMauSac);
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm Màu Sắc Thất bại");
                    }
                }

                break;

            default:
                throw new AssertionError();
        }
    }

    private void themSanPham() {
        int check1 = JOptionPane.showConfirmDialog(this, "bạn muốn thêm sản phẩm không");
        String ma = txtMaSanPham.getText().trim();
        String ten = txtTenSanPham.getText().trim();
        if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", ma)) {
            JOptionPane.showMessageDialog(this, "mã sp là chữ ko dấu ít hơn 20 kí tự");
            return;
        }
        if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ 0-9._-]{1,30}$", ten)) {
            JOptionPane.showMessageDialog(this, "tên sp là chữ ít hơn 30 kí tự");
            return;
        }
        if (sps.kiemTraTrungMaSP(ma)) {
            JOptionPane.showMessageDialog(this, "trùng mã");
            return;
        }
        if (sps.kiemTraTrungtenSP(ten)) {
            JOptionPane.showMessageDialog(this, "trùng tên");
            return;
        }
        if (check1 == JOptionPane.YES_OPTION) {
            if (sps.themSanPham(readFormSanPham()) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm  Sản Phẩm Thành Công");
                fillToTableSanPham(sps.getAllSanPham());
                addCbo(ctspsv.getTenSanPham(), cboTenSP);
            } else {
                JOptionPane.showMessageDialog(this, "Thêm Sản Phẩm Thất bại");
            }
        }
    }

    private void themCTSP() {
        int check1 = JOptionPane.showConfirmDialog(this, "bạn muốn thêm CTSP không");
        String maCTSP = txtMaSPCT.getText().trim();
        String donGia = txtDonGia.getText().trim();
        String soLuong = txtSoLuong.getText().trim();
        String moTa = txtMoTa.getText().trim();
        if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", maCTSP)) {
            JOptionPane.showMessageDialog(this, "mã CTSP là chữ ko dấu ít hơn 20 kí tự");
            return;
        }
        if (!kiemTraChuoi("^[0-9. ]{1,30}$", donGia)) {
            JOptionPane.showMessageDialog(this, "đơn giá là số ít hơn 30 kí tự");
            return;
        }
        if (!kiemTraChuoi("^[0-9 ]{1,20}$", soLuong)) {
            JOptionPane.showMessageDialog(this, "số lượng phải là số ít hơn 7 kí tự");
            return;
        }
        if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ ._-0-9]{1,200}$", moTa)) {
            JOptionPane.showMessageDialog(this, "mô tả ít hơn 200 kí tự");
            return;
        }
        if (ctspsv.kiemTraTrungMaCTSP(maCTSP)) {
            JOptionPane.showMessageDialog(this, "trùng mã");
            return;
        }

        if (check1 == JOptionPane.YES_OPTION) {
            if (ctspsv.themCTSP(readCTSP()) > 0) {
                JOptionPane.showMessageDialog(this, "Thêm  CTSP Thành Công");
                fillToTableCTSP(ctspsv.getAllCTSP());
                if (ctspsv.capNhatLichSuGia(ctspsv.getIDCTSP(txtMaSPCT.getText()), Double.parseDouble(txtDonGia.getText()), Double.parseDouble(txtDonGia.getText())) > 0) {
                    System.out.println("ghi lich su gia thanh cong");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Thêm CTSP Thất bại");
            }
        }
    }

    private void suaThuocTinh() {
        String thuocTinhDangChon = cboLoaiThuocTinh.getSelectedItem().toString();
        index = tblThuocTinh.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng để sửa");
            return;
        }
        switch (thuocTinhDangChon) {
            case "Chất Liệu":
                int check1 = JOptionPane.showConfirmDialog(this, "bạn muốn sửa chất liệu không");
                String ma = txtMaThuocTinh.getText().trim();
                String ten = txtTenThuocTinh.getText().trim();
                if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", ma)) {
                    JOptionPane.showMessageDialog(this, "mã chất liệu là chữ ko dấu ít hơn 20 kí tự");
                    return;
                }
                if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ ._-]{1,30}$", ten)) {
                    JOptionPane.showMessageDialog(this, "tên chất liệu là chữ ít hơn 30 kí tự");
                    return;
                }
                if (!ma.equalsIgnoreCase(tblThuocTinh.getValueAt(index, 1).toString())) {
                    if (tts.kiemTraTrungMaChatLieu(ma)) {
                        JOptionPane.showMessageDialog(this, "trùng mã");
                        return;
                    }
                }
                if (!ten.equalsIgnoreCase(tblThuocTinh.getValueAt(index, 2).toString())) {
                    if (tts.kiemTraTrungTenChatLieu(ten)) {
                        JOptionPane.showMessageDialog(this, "trùng tên");
                        return;
                    }
                }
                if (check1 == JOptionPane.YES_OPTION) {
                    if (tts.suaChatLieu(readFormChatLieu(), tblThuocTinh.getValueAt(index, 1).toString()) > 0) {
                        JOptionPane.showMessageDialog(this, "Sửa Chất Liệu Thành Công");
                        fillToTableChatLieu(tts.getAllChatLieu());
                        addCbo(ctspsv.getTenChatLieu(), cboChatLieu);
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa Chất Liệu Thất bại");
                    }
                }

                break;
            case "Hãng":
                int check2 = JOptionPane.showConfirmDialog(this, "bạn muốn sửa Hãng không");
                String ma2 = txtMaThuocTinh.getText().trim();
                String ten2 = txtTenThuocTinh.getText().trim();
                if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", ma2)) {
                    JOptionPane.showMessageDialog(this, "mã hãng là chữ ko dấu ít hơn 20 kí tự");
                    return;
                }
                if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ 0-9._]{1,30}$", ten2)) {
                    JOptionPane.showMessageDialog(this, "tên hãng là chữ ít hơn 30 kí tự");
                    return;
                }

                if (!ma2.equalsIgnoreCase(tblThuocTinh.getValueAt(index, 1).toString())) {
                    if (tts.kiemTraTrungMaHang(ma2)) {
                        JOptionPane.showMessageDialog(this, "trùng mã");
                        return;
                    }
                }
                if (!ten2.equalsIgnoreCase(tblThuocTinh.getValueAt(index, 2).toString())) {
                    if (tts.kiemTraTrungTenHang(ten2)) {
                        JOptionPane.showMessageDialog(this, "trùng tên");
                        return;
                    }
                }
                if (check2 == JOptionPane.YES_OPTION) {
                    if (tts.suaHang(readFormHang(), tblThuocTinh.getValueAt(index, 1).toString()) > 0) {
                        JOptionPane.showMessageDialog(this, "Sửa  Hãng Thành Công");
                        fillToTableHang(tts.getAllHang());
                        addCbo(ctspsv.getTenHang(), cboHang);
                    } else {
                        JOptionPane.showMessageDialog(this, "sửa Hãng Thất bại");
                    }
                }

                break;
            case "Kích Cỡ":
                int check3 = JOptionPane.showConfirmDialog(this, "bạn muốn sửa kích cỡ không");
                String ma3 = txtMaThuocTinh.getText().trim();
                String ten3 = txtTenThuocTinh.getText().trim();
                if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", ma3)) {
                    JOptionPane.showMessageDialog(this, "mã kích cỡ là chữ ko dấu ít hơn 20 kí tự");
                    return;
                }
                if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ ._-]{1,30}$", ten3)) {
                    JOptionPane.showMessageDialog(this, "tên kích cỡ là chữ ít hơn 30 kí tự");
                    return;
                }
                if (!ma3.equalsIgnoreCase(tblThuocTinh.getValueAt(index, 1).toString())) {
                    if (tts.kiemTraTrungMaKichCo(ma3)) {
                        JOptionPane.showMessageDialog(this, "trùng mã");
                        return;
                    }
                }
                if (!ten3.equalsIgnoreCase(tblThuocTinh.getValueAt(index, 2).toString())) {
                    if (tts.kiemTraTrungTenKichCo(ten3)) {
                        JOptionPane.showMessageDialog(this, "trùng tên");
                        return;
                    }
                }
                if (check3 == JOptionPane.YES_OPTION) {
                    if (tts.suaKichCo(readFormKichCo(), tblThuocTinh.getValueAt(index, 1).toString()) > 0) {
                        JOptionPane.showMessageDialog(this, "Sửa Kích Cỡ Thành Công");
                        fillToTableKichCo(tts.getAllKichCo());
                        addCbo(ctspsv.getTenKichCo(), cboKichCo);
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa Kích cỡ Thất bại");
                    }
                }

                break;
            case "Màu Sắc":
                int check4 = JOptionPane.showConfirmDialog(this, "bạn muốn sửa Màu sắc không");
                String ma4 = txtMaThuocTinh.getText().trim();
                String ten4 = txtTenThuocTinh.getText().trim();
                if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", ma4)) {
                    JOptionPane.showMessageDialog(this, "mã màu sắc là chữ ko dấu ít hơn 20 kí tự");
                    return;
                }
                if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ 0-9]{1,30}$", ten4)) {
                    JOptionPane.showMessageDialog(this, "tên màu sắc là chữ ít hơn 30 kí tự");
                    return;
                }
                if (!ma4.equalsIgnoreCase(tblThuocTinh.getValueAt(index, 1).toString())) {
                    if (tts.kiemTraTrungMaMauSac(ma4)) {
                        JOptionPane.showMessageDialog(this, "trùng mã");
                        return;
                    }
                }
                if (!ten4.equalsIgnoreCase(tblThuocTinh.getValueAt(index, 2).toString())) {
                    if (tts.kiemTraTrungTenMauSac(ten4)) {
                        JOptionPane.showMessageDialog(this, "trùng tên");
                        return;
                    }
                }
                if (check4 == JOptionPane.YES_OPTION) {
                    if (tts.suaMauSac(readFormMauSac(), tblThuocTinh.getValueAt(index, 1).toString()) > 0) {
                        JOptionPane.showMessageDialog(this, "Sửa Màu Sắc Thành Công");
                        fillToTableMauSac(tts.getAllMauSac());
                        addCbo(ctspsv.getTenMauSac(), cboMauSac);
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa Màu Sắc Thất bại");
                    }
                }

                break;

            default:
                throw new AssertionError();
        }
    }

    private void suaSanPham() {
        index = tblSanPham.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng để sửa");
            return;
        }

        int check1 = JOptionPane.showConfirmDialog(this, "bạn muốn sửa Sản Phẩm không");

        String ma = txtMaSanPham.getText().trim();
        String ten = txtTenSanPham.getText().trim();
        if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", ma)) {
            JOptionPane.showMessageDialog(this, "mã sp là chữ ko dấu ít hơn 20 kí tự");
            return;
        }
        if (!kiemTraChuoi("[a-zA-ZÀ-ỹ0-9 ._-]{1,30}", ten)) {
            JOptionPane.showMessageDialog(this, "tên sp là chữ ít hơn 30 kí tự");
            return;
        }
        if (!ma.equalsIgnoreCase(tblSanPham.getValueAt(index, 1).toString())) {
            if (sps.kiemTraTrungMaSP(ma)) {
                JOptionPane.showMessageDialog(this, "trùng mã");
                return;
            }
        }
        if (!ten.equalsIgnoreCase(tblSanPham.getValueAt(index, 2).toString())) {
            if (sps.kiemTraTrungtenSP(ten)) {
                JOptionPane.showMessageDialog(this, "trùng tên");
                return;
            }
        }
        if (check1 == JOptionPane.YES_OPTION) {
            if (sps.suaSanPham(readFormSanPham(), tblSanPham.getValueAt(index, 1).toString()) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa Sản Phẩm Thành Công");
                fillToTableSanPham(sps.getAllSanPham());
                addCbo(ctspsv.getTenSanPham(), cboTenSP);
            } else {
                JOptionPane.showMessageDialog(this, "Sửa Sản Phẩm Thất bại");
            }
        }
    }

    private void suaCTSP() {
        index = tblCTSP.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng để sửa");
            return;
        }

        int check1 = JOptionPane.showConfirmDialog(this, "bạn muốn sửa CTSP không");
        String maCTSP = txtMaSPCT.getText().trim();
        String donGia = txtDonGia.getText().trim();
        String soLuong = txtSoLuong.getText().trim();
        String moTa = txtMoTa.getText().trim();
        if (!kiemTraChuoi("^[a-zA-Z0-9 ]{1,20}$", maCTSP)) {
            JOptionPane.showMessageDialog(this, "mã CTSP là chữ ko dấu ít hơn 20 kí tự");
            return;
        }
        if (!kiemTraChuoi("^[0-9. ]{1,30}$", donGia)) {
            JOptionPane.showMessageDialog(this, "đơn giá là số ít hơn 30 kí tự");
            return;
        }
        if (!kiemTraChuoi("^[0-9 ]{1,20}$", soLuong)) {
            JOptionPane.showMessageDialog(this, "số lượng phải là số ít hơn 7 kí tự");
            return;
        }
        if (!kiemTraChuoi("^[a-zA-ZÀ-ỹ ]{1,200}$", moTa)) {
            JOptionPane.showMessageDialog(this, "mô tả ít hơn 200 kí tự");
            return;
        }
        if (!maCTSP.equals(tblCTSP.getValueAt(index, 1))) {
            if (ctspsv.kiemTraTrungMaCTSP(maCTSP)) {
                JOptionPane.showMessageDialog(this, "trùng mã");
                return;
            }
        }

        if (check1 == JOptionPane.YES_OPTION) {
            if (ctspsv.suaCTSP(readCTSP(), tblCTSP.getValueAt(index, 1).toString()) > 0) {
                JOptionPane.showMessageDialog(this, "Sửa CTSP Thành Công");
                if (!tblCTSP.getValueAt(index, 3).toString().equals(txtDonGia.getText())) {
                    if (ctspsv.capNhatLichSuGia(ctspsv.getIDCTSP(txtMaSPCT.getText()), (double) tblCTSP.getValueAt(index, 3), Double.parseDouble(txtDonGia.getText())) > 0) {
                        System.out.println("ghi lich su gia thanh cong");
                    } else {
                        System.out.println("that bai");
                    }
                }

                fillToTableCTSP(ctspsv.getAllCTSP());

            } else {
                JOptionPane.showMessageDialog(this, "Sửa CTSP Thất bại");
            }
        }
    }

    private String taoQR() {

        String data = txtMaSPCT.getText();
        String filePath = "img\\" + txtMaSPCT.getText() + "QR.png";
        int width = 400;
        int height = 400;

        try {
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

            BitMatrix matrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height);

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int rgb = matrix.get(x, y) ? 0xE56E00 : 0xFFFFFF;
                    image.setRGB(x, y, rgb);
                }
            }

            File qrCodeFile = new File(filePath);
            ImageIO.write(image, "png", qrCodeFile);

            BufferedImage img = ImageIO.read(qrCodeFile);
            Image hinhSua = img.getScaledInstance(170, 170, Image.SCALE_SMOOTH);
            qr.setText("");
            qr.setIcon(new ImageIcon(hinhSua));

            System.out.println("QR Code đã được tạo thành công.");
            return filePath;
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return "eror";
    }

    private boolean kiemTraChuoi(String chuoiChinhQuy, String ChuoiKiemTra) {
        if (ChuoiKiemTra.equals("")) {
            JOptionPane.showMessageDialog(this, "không được để trống ô nhập");
        }
        if (ChuoiKiemTra.matches(chuoiChinhQuy)) {
            return true;
        } else {
            return false;
        }
    }

    private int xuatExcel() {
        // Định dạng ngày giờ thành chuỗi theo ý muốn
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy_hhmmss");
        String formattedDate = currentDate.format(formatter);

        String filePath = "excelTTCTSP\\TTCTSP_" + formattedDate + ".xlsx";

        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");

            // Lấy dữ liệu từ bảng
            TableModel tableModel = tblCTSP.getModel();
            int rowCount = tableModel.getRowCount();
            int columnCount = tableModel.getColumnCount();

            // Tạo header
            Row headerRow = sheet.createRow(0);
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                Cell headerCell = headerRow.createCell(columnIndex);
                headerCell.setCellValue(tableModel.getColumnName(columnIndex));
            }

            // Đổ dữ liệu vào từng dòng
            for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                Row row = sheet.createRow(rowIndex + 1);
                for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                    Cell cell = row.createCell(columnIndex);
                    Object value = tableModel.getValueAt(rowIndex, columnIndex);
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    }

                }
            }

            // Tự động điều chỉnh cỡ cột cho phù hợp với nội dung
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                sheet.autoSizeColumn(columnIndex);
            }

            // Lưu workbook xuống file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            // Đóng workbook
            workbook.close();

            System.out.println("xuất excel thành công :" + filePath);
            return 1;
        } catch (IOException e) {
            System.out.println("Export failed: " + e.getMessage());
            return 0;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        trangThaiSP = new javax.swing.ButtonGroup();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        rdoDangBan = new javax.swing.JRadioButton();
        rdoNgungBan = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTimKiemSP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        cboTimKiemSP = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboKichCo = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();
        cboMauSac = new javax.swing.JComboBox<>();
        cboHang = new javax.swing.JComboBox<>();
        cboTenSP = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtMaSPCT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        rdoConBan = new javax.swing.JRadioButton();
        rdoHetHang = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        qr = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCTSP = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        rdoConBan1 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cboHang1 = new javax.swing.JComboBox<>();
        cboMauSac1 = new javax.swing.JComboBox<>();
        cboChatLieu1 = new javax.swing.JComboBox<>();
        cboKichCo1 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        rdoHetHang1 = new javax.swing.JRadioButton();
        myButton3 = new swing.MyButton();
        myButton4 = new swing.MyButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtMaThuocTinh = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTenThuocTinh = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cboLoaiThuocTinh = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        rdoConHang = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        rdoHet = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThuocTinh = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1300, 790));
        setRequestFocusEnabled(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 750));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin Sản Phẩm"));
        jPanel7.setToolTipText("");

        jLabel1.setText("Mã Sản Phẩm");

        jLabel2.setText("Tên Sản Phẩm");

        jLabel18.setText("Trạng Thái");

        trangThaiSP.add(rdoDangBan);
        rdoDangBan.setText("Đang bán");

        trangThaiSP.add(rdoNgungBan);
        rdoNgungBan.setText("Ngừng Bán");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(97, 97, 97)
                        .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel18))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(rdoDangBan)
                                .addGap(38, 38, 38)
                                .addComponent(rdoNgungBan)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTenSanPham))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(rdoDangBan)
                    .addComponent(rdoNgungBan))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Thêm Sản Phẩm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa Sản Phẩm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Làm Mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh Sách Sản Phẩm"));

        jLabel3.setText("Tìm kiếm");

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Trạng Thái Bán", "Ngày Tạo", "Ngày Sửa Cuối"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jButton13.setText("Tìm kiếm");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        cboTimKiemSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MaSP", "Ten" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(cboTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jButton13)
                        .addGap(53, 53, 53)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13)
                    .addComponent(cboTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Sản Phẩm", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông Tin sản Phẩm"));
        jPanel4.setPreferredSize(new java.awt.Dimension(1290, 235));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Mã SPCT");

        jLabel5.setText("Đơn Giá");

        jLabel6.setText("Số Lượng");

        jLabel7.setText("Tên Sản Phẩm");

        jLabel8.setText("Màu sắc");

        jLabel9.setText("Hãng");

        jLabel10.setText("Kích Cỡ");

        jLabel11.setText("Chất Liệu");

        cboKichCo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboTenSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        jLabel13.setText("Trạng Thái");

        buttonGroup1.add(rdoConBan);
        rdoConBan.setText("Còn bán");
        rdoConBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoConBanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHetHang);
        rdoHetHang.setText("Ngưng bán");

        jLabel19.setText("Mô tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane4.setViewportView(txtMoTa);

        qr.setText("qr");
        qr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel19))
                .addGap(42, 42, 42)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboTenSP, 0, 301, Short.MAX_VALUE)
                    .addComponent(txtMaSPCT)
                    .addComponent(txtSoLuong)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addGap(71, 71, 71)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoConBan)
                        .addGap(18, 18, 18)
                        .addComponent(rdoHetHang)
                        .addGap(297, 297, 297))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboKichCo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(qr, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(cboKichCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(qr, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(rdoConBan)
                            .addComponent(rdoHetHang)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton4.setText("Thêm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Sửa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Thêm/Sửa Qr");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("Mới");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Xuất file Excel");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh Sách Sản Phẩm Chi Tiết"));

        jLabel12.setText("Tìm Kiếm theo mã");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        tblCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã CTSP", "Tên Sản Phẩm", "Đơn Giá", "Số Lượng", "Màu Sắc", "Kích Cỡ", "Hãng", "Chất Liệu", "Ngày Tạo", "Ngày Sửa Cuối", "Trạng Thái", "Mô Tả", "Mã Vạch"
            }
        ));
        tblCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTSPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCTSP);
        if (tblCTSP.getColumnModel().getColumnCount() > 0) {
            tblCTSP.getColumnModel().getColumn(0).setMaxWidth(50);
            tblCTSP.getColumnModel().getColumn(1).setMaxWidth(70);
            tblCTSP.getColumnModel().getColumn(4).setMaxWidth(70);
            tblCTSP.getColumnModel().getColumn(5).setMaxWidth(70);
            tblCTSP.getColumnModel().getColumn(6).setMaxWidth(70);
            tblCTSP.getColumnModel().getColumn(7).setMaxWidth(70);
            tblCTSP.getColumnModel().getColumn(8).setMaxWidth(70);
            tblCTSP.getColumnModel().getColumn(11).setMaxWidth(50);
        }

        jLabel20.setText("Kích Cỡ");

        buttonGroup1.add(rdoConBan1);
        rdoConBan1.setText("Còn bán");

        jLabel21.setText("Hãng");

        jLabel22.setText("Trạng Thái: ");

        jLabel23.setText("Màu sắc");

        cboHang1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMauSac1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboChatLieu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboKichCo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboKichCo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKichCo1ActionPerformed(evt);
            }
        });

        jLabel24.setText("Chất Liệu");

        buttonGroup1.add(rdoHetHang1);
        rdoHetHang1.setText("Ngưng bán");

        myButton3.setText("Tìm");

        myButton4.setText("Lọc");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboKichCo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboMauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboChatLieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoHetHang1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoConBan1)
                                .addGap(184, 184, 184)
                                .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1258, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(myButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cboHang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cboKichCo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cboMauSac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(cboChatLieu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(rdoHetHang1)
                    .addComponent(rdoConBan1)
                    .addComponent(myButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1304, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Sản Phẩm Chi Tiết", jPanel2);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thiết Lập Thuộc Tính"));

        jLabel14.setText("Mã ");

        txtMaThuocTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaThuocTinhActionPerformed(evt);
            }
        });

        jLabel15.setText("Tên Thuộc Tính Chi tiết");

        jLabel16.setText("Loại Thuộc Tính");

        cboLoaiThuocTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLoaiThuocTinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiThuocTinhItemStateChanged(evt);
            }
        });

        jButton11.setText("Sửa");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Thêm");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoConHang);
        rdoConHang.setText("Còn ");

        jLabel17.setText("Trạng Thái");

        buttonGroup2.add(rdoHet);
        rdoHet.setText("Hết hàng");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(rdoConHang)
                        .addGap(18, 18, 18)
                        .addComponent(rdoHet)
                        .addContainerGap(819, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaThuocTinh)
                            .addComponent(txtTenThuocTinh)
                            .addComponent(cboLoaiThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cboLoaiThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtMaThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtTenThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoConHang)
                    .addComponent(jLabel17)
                    .addComponent(rdoHet))
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh Sách Loại Thuộc Tính"));

        tblThuocTinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Thuộc Tính", "Tên Thuộc Tính", "Trạng Thái", "Ngày Tạo", "Ngày Sửa Cuối"
            }
        ));
        tblThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuocTinhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblThuocTinh);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Thuộc Tính Sản Phẩm", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void rdoConBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoConBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoConBanActionPerformed

    private void txtMaThuocTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaThuocTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaThuocTinhActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        suaThuocTinh();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        themThuocTinh();

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void tblThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuocTinhMouseClicked
        // TODO add your handling code here:
        index = tblThuocTinh.getSelectedRow();
        hienThuocTinhLenFrom(index);
    }//GEN-LAST:event_tblThuocTinhMouseClicked

    private void cboLoaiThuocTinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiThuocTinhItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String selectedValue = (String) cboLoaiThuocTinh.getSelectedItem();
            System.out.println("Đã chọn: " + selectedValue);
            // Thực hiện các hành động tương ứng với giá trị đã chọn
            switch (selectedValue) {
                case "Màu Sắc":
                    fillToTableMauSac(tts.getAllMauSac());
                    txtMaThuocTinh.setText("");
                    txtTenThuocTinh.setText("");
                    break;
                case "Kích Cỡ":
                    fillToTableKichCo(tts.getAllKichCo());
                    txtMaThuocTinh.setText("");
                    txtTenThuocTinh.setText("");
                    break;
                case "Hãng":
                    fillToTableHang(tts.getAllHang());
                    txtMaThuocTinh.setText("");
                    txtTenThuocTinh.setText("");
                    break;
                case "Chất Liệu":
                    fillToTableChatLieu(tts.getAllChatLieu());
                    txtMaThuocTinh.setText("");
                    txtTenThuocTinh.setText("");
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_cboLoaiThuocTinhItemStateChanged

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        // TODO add your handling code here:
        index = tblSanPham.getSelectedRow();
        hienSPLenFrom(index);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        themSanPham();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        suaSanPham();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtMaSanPham.setText("");
        txtTenSanPham.setText("");
        rdoDangBan.setSelected(false);
        rdoNgungBan.setSelected(false);
        fillToTableSanPham(sps.getAllSanPham());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if (cboTimKiemSP.getSelectedItem().equals("MaSP")) {
            fillToTableSanPham(sps.timKiemSanPhamTheoMa(txtTimKiemSP.getText()));
        } else if (cboTimKiemSP.getSelectedItem().equals("Ten")) {
            fillToTableSanPham(sps.timKiemSanPhamTheoTen(txtTimKiemSP.getText()));
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void tblCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTSPMouseClicked
        // TODO add your handling code here:
        index = tblCTSP.getSelectedRow();
        try {
            hienCTSPLenForm(index);
        } catch (IOException ex) {

        }
    }//GEN-LAST:event_tblCTSPMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        themCTSP();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        if (xuatExcel() == 1) {
            JOptionPane.showMessageDialog(this, "xuất file thành công");
        } else {
            JOptionPane.showMessageDialog(this, "lỗi xuất file");

        }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        suaCTSP();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        moiCTSP();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        index = tblCTSP.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "bạn chưa chọn dòng để sửa");
            return;
        }

        int check1 = JOptionPane.showConfirmDialog(this, "bạn muốn sửa Sản Phẩm không");
        if (check1 == JOptionPane.NO_OPTION) {
            return;
        }
        ctspsv.themSuaQR(taoQR(), txtMaSPCT.getText());
        fillToTableCTSP(ctspsv.getAllCTSP());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cboKichCo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKichCo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboKichCo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboChatLieu1;
    private javax.swing.JComboBox<String> cboHang;
    private javax.swing.JComboBox<String> cboHang1;
    private javax.swing.JComboBox<String> cboKichCo;
    private javax.swing.JComboBox<String> cboKichCo1;
    private javax.swing.JComboBox<String> cboLoaiThuocTinh;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboMauSac1;
    private javax.swing.JComboBox<String> cboTenSP;
    private javax.swing.JComboBox<String> cboTimKiemSP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextField jTextField4;
    private swing.MyButton myButton3;
    private swing.MyButton myButton4;
    private javax.swing.JLabel qr;
    private javax.swing.JRadioButton rdoConBan;
    private javax.swing.JRadioButton rdoConBan1;
    private javax.swing.JRadioButton rdoConHang;
    private javax.swing.JRadioButton rdoDangBan;
    private javax.swing.JRadioButton rdoHet;
    private javax.swing.JRadioButton rdoHetHang;
    private javax.swing.JRadioButton rdoHetHang1;
    private javax.swing.JRadioButton rdoNgungBan;
    private javax.swing.JTable tblCTSP;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblThuocTinh;
    private javax.swing.ButtonGroup trangThaiSP;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaSPCT;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMaThuocTinh;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTenThuocTinh;
    private javax.swing.JTextField txtTimKiemSP;
    // End of variables declaration//GEN-END:variables
}
