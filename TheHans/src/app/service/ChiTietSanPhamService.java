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
        sql = "	select maCTSP,SanPham.ten as [tên sp],giaBan,soLuongCon ,MauSac.ten as [màu],KichCo.ten  as [KichCo],Hang.ten as [Hãng],ChatLieu.ten as [Chất liệu],KhuyenMai.tenKM as [tên ctkm],ChiTietSanPham.ngayTao,ChiTietSanPham.ngaySuaCuoi,ChiTietSanPham.trangThaiXoa,ChiTietSanPham.mota,ChiTietSanPham.maVach  from ChiTietSanPham \n"
                + "	join SanPham on id_SanPham = SanPham.id\n"
                + "	join MauSac on id_MauSac = MauSac.id\n"
                + "	join KichCo on id_KichCo = KichCo.id\n"
                + "	join Hang on id_Hang = Hang.id\n"
                + "	join ChatLieu on id_ChatLieu = ChatLieu.id\n"
                + "	join CTSP_KhuyenMai on id_CTSP_KhuyenMai = CTSP_KhuyenMai.id\n"
                + "	join KhuyenMai on KhuyenMai.id = CTSP_KhuyenMai.id_KhuyenMai";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ct = new ChiTietSanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14));
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

    public static void main(String[] args) {
        List<ChiTietSanPham> list = new ArrayList<>();
        ChiTietSanPhamService qld = new ChiTietSanPhamService();
        list = qld.getAllCTSP();
        for (ChiTietSanPham grade : list) {
            System.out.println(grade.toString());
        }
    }

}
