/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.model.ChatLieu;
import app.model.ChiTietSanPham;
import app.model.Hang;
import app.model.KichCo;
import app.model.MauSac;
import app.model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ChiTietSanPhamService {

    List<ChiTietSanPham> listCTSP;
    List<String> listTenChatLieu;
    List<String> listTenKichCo;
    List<String> listTenHang;
    List<String> listTenMau;
    List<String> listTenSanPham;

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<ChiTietSanPham> getAllCTSP() {
        listCTSP = new ArrayList<>();
        sql = "	select maCTSP,SanPham.ten as [tên sp],giaBan,soLuongCon ,MauSac.ten as [màu],KichCo.ten  as [KichCo],Hang.ten as [Hãng],ChatLieu.ten as [Chất liệu],ChiTietSanPham.ngayTao,ChiTietSanPham.ngaySuaCuoi,ChiTietSanPham.trangThaiXoa,ChiTietSanPham.mota,ChiTietSanPham.maVach  from ChiTietSanPham \n"
                + "	join SanPham on id_SanPham = SanPham.id\n"
                + "	join MauSac on id_MauSac = MauSac.id\n"
                + "	join KichCo on id_KichCo = KichCo.id\n"
                + "	join Hang on id_Hang = Hang.id\n"
                + "	join ChatLieu on id_ChatLieu = ChatLieu.id";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ct = new ChiTietSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13));
                listCTSP.add(ct);
            }
            return listCTSP;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<String> getTenChatLieu() {
        listTenChatLieu = new ArrayList<>();

        sql = "select machatlieu,ten,trangthaixoa,ngaytao,ngaysuacuoi from chatlieu";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu cl = new ChatLieu(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listTenChatLieu.add(cl.getTen());
            }
            return listTenChatLieu;
        } catch (Exception e) {
            return null;
        }
    }

    public List<String> getTenHang() {
        listTenHang = new ArrayList<>();

        sql = "select maHang,ten,trangthaixoa,ngaytao,ngaysuacuoi from hang";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Hang h = new Hang(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listTenHang.add(h.getTen());
            }
            return listTenHang;
        } catch (Exception e) {
            return null;
        }
    }

    public List<String> getTenKichCo() {
        listTenKichCo = new ArrayList<>();

        sql = "select makichco,ten,trangthaixoa,ngaytao,ngaysuacuoi from KichCo";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KichCo kc = new KichCo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listTenKichCo.add(kc.getTen());
            }
            return listTenKichCo;
        } catch (Exception e) {
            return null;
        }
    }

    public List<String> getTenMauSac() {
        listTenMau = new ArrayList<>();

        sql = "select maMauSac,ten,trangthaixoa,ngaytao,ngaysuacuoi from MauSac";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listTenMau.add(ms.getTen());
            }
            return listTenMau;
        } catch (Exception e) {
            return null;
        }
    }

    public List<String> getTenSanPham() {
        listTenSanPham = new ArrayList<>();

        sql = "select maSP,ten,trangthaixoa,ngaytao,ngaysuacuoi from SanPham";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listTenSanPham.add(sp.getTen());
            }
            return listTenSanPham;
        } catch (Exception e) {
            return null;
        }
    }

    public int themCTSP(ChiTietSanPham ctsp) {
        sql = "insert into  ChiTietSanPham (maCTSP,id_SanPham,giaBan,soLuongCon,id_MauSac,id_KichCo,id_Hang,id_ChatLieu,ngayTao,ngaySuaCuoi,trangThaiXoa,mota,maVach)\n"
                + "values\n"
                + "(?,?,?,?,?,?,?,?,GETDATE(),GETDATE(),?,?,null)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ctsp.getMaCTSP());
            ps.setInt(2, Integer.parseInt(ctsp.getId_SanPham()));
            ps.setDouble(3, ctsp.getGiaBan());
            ps.setInt(4, ctsp.getSoLuongCon());
            ps.setInt(5, Integer.parseInt(ctsp.getId_MauSac()));
            ps.setInt(6, Integer.parseInt(ctsp.getId_KichCo()));
            ps.setInt(7, Integer.parseInt(ctsp.getId_Hang()));
            ps.setInt(8, Integer.parseInt(ctsp.getId_ChatLieu()));
            ps.setInt(9, ctsp.getTrangThaiXoa());
            ps.setString(10, ctsp.getMota());

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int getIDChatLieu(String TenChatLieu) {
        sql = "select id from chatlieu where ten = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, TenChatLieu);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int getIDHang(String TenHang) {
        sql = "select id from Hang where ten = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, TenHang);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int getIDKichCo(String TenKichCo) {
        sql = "select id from KichCo where ten = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, TenKichCo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int getIDMauSac(String TenMauSac) {
        sql = "select id from MauSac where ten = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, TenMauSac);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int getIDSanPham(String TenSanPham) {
        sql = "select id from SanPham where ten = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, TenSanPham);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public int suaCTSP(ChiTietSanPham ctsp, String maCTSP) {
        sql = "update ChiTietSanPham set maCTSP = ?, id_SanPham = ?, giaBan = ?,"
                + " soLuongCon = ?,id_MauSac = ?, id_KichCo = ?, id_Hang = ?,id_ChatLieu = ?,"
                + "ngaySuaCuoi = GETDATE(),trangThaiXoa = ?,mota = ?,maVach = null"
                + " where maCTSP = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ctsp.getMaCTSP());
            ps.setInt(2, Integer.parseInt(ctsp.getId_SanPham()));
            ps.setDouble(3, ctsp.getGiaBan());
            ps.setInt(4, ctsp.getSoLuongCon());
            ps.setInt(5, Integer.parseInt(ctsp.getId_MauSac()));
            ps.setInt(6, Integer.parseInt(ctsp.getId_KichCo()));
            ps.setInt(7, Integer.parseInt(ctsp.getId_Hang()));
            ps.setInt(8, Integer.parseInt(ctsp.getId_ChatLieu()));
            ps.setInt(9, ctsp.getTrangThaiXoa());
            ps.setString(10, ctsp.getMota());
            ps.setString(11, maCTSP);

            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        List<ChiTietSanPham> list = new ArrayList<>();
        ChiTietSanPhamService qld = new ChiTietSanPhamService();
        list = qld.getAllCTSP();

        for (ChiTietSanPham grade : list) {
            System.out.println(grade.toString());
        }
    }

}
