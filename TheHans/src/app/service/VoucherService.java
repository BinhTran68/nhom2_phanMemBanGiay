package app.service;

import app.model.KhuyenMai;
import app.model.Voucher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoucherService {

    private List<Voucher> listKM;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<Voucher> getAll() {
        
        listKM = new ArrayList<>();
        sql = "select id, maVoucher, tenVoucher, loaiVoucher, ngayBatDau, ngayKetThuc, giaTri from Voucher";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Voucher km = new Voucher(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getInt(7));

                listKM.add(km);
            }
            return listKM;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int AddKM(Voucher km) {
        sql = "insert into Voucher (maVoucher, tenVoucher, loaiVoucher, ngayBatDau, ngayKetThuc, giaTri) values (?, ?, ?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, km.getTen());
            ps.setObject(2, km.getLoaiGiam());
            ps.setObject(3, km.getNgayBD());
            ps.setObject(4, km.getNgayKT());
            ps.setObject(5, km.getGiatri());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateKM(String ma, Voucher km) {
        sql = "Update Voucher set tenVoucher = ?, loaiVoucher = ?, ngayBatDau = ?, ngayKetThuc = ?, giaTri = ?\n"
                + "where maKM like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
           
            ps.setObject(1, km.getTen());
            ps.setObject(2, km.getLoaiGiam());
            ps.setObject(3, km.getNgayBD());
            ps.setObject(4, km.getNgayKT());
            ps.setObject(5, km.getGiatri());
            ps.setObject(6, km.getMa());
            
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Voucher findKhuyenMaiByMaKhuyenMai(String maKhuyenMai) {
        Voucher km = null;

        sql = "select id, maVoucher, tenVoucher, loaiVoucher, ngayBatDau, ngayKetThuc, giaTri from Voucher where maVoucher = ?";
        

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKhuyenMai);
            rs = ps.executeQuery();

            while (rs.next()) {
                 km = new Voucher(rs.getInt(1), rs.getString(3),
                        rs.getString(2), rs.getString(4),
                        rs.getDate(5), rs.getDate(6),
                        rs.getInt(7));

            }
            return km;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 

}
