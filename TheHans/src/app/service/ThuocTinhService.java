/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.model.*;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author admin
 */
public class ThuocTinhService {
    List<SanPham> listSanPham;
    List<ChatLieu> listChatLieu;
    List<Hang> listHang;
    List<KichCo> listKichCo;
    List<MauSac> listMauSac;

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<ChatLieu> getAllChatLieu() {
        listChatLieu = new ArrayList<>();
        sql = "select machatlieu,ten,trangthaixoa,ngaytao,ngaysuacuoi from chatlieu";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu cl = new ChatLieu(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listChatLieu.add(cl);
            }
            return listChatLieu;
        } catch (Exception e) {
            return null;
        }
    }

    public List<MauSac> getAllMauSac() {
        listMauSac = new ArrayList<>();
        sql = "select maMauSac,ten,trangthaixoa,ngaytao,ngaysuacuoi from MauSac";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listMauSac.add(ms);
            }
            return listMauSac;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Hang> getAllHang() {
        listHang = new ArrayList<>();
        sql = "select maHang,ten,trangthaixoa,ngaytao,ngaysuacuoi from Hang";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Hang h = new Hang(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listHang.add(h);
            }
            return listHang;
        } catch (Exception e) {
            return null;
        }
    }

    public List<KichCo> getAllKichCo() {
        listKichCo = new ArrayList<>();
        sql = "select makichco,ten,trangthaixoa,ngaytao,ngaysuacuoi from kichco";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KichCo kc = new KichCo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listKichCo.add(kc);
            }
            return listKichCo;
        } catch (Exception e) {
            return null;
        }
    }

    public int addChatLieu(ChatLieu cl) {
        if (cl == null || cl.getMaChatLieu() == null || cl.getTen() == null) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra xem các trường có giá trị rỗng không
        if (cl.getMaChatLieu().isEmpty() || cl.getTen().isEmpty()) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra mã từ 3 đến 10 ký tự
        if (cl.getMaChatLieu().length() < 3 || cl.getMaChatLieu().length() > 10) {
            throw new IndexOutOfBoundsException("sai định dạng");
        }

        sql = "insert into ChatLieu\n"
                + "values \n"
                + "(?,?,?,getDate(),getDate())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getMaChatLieu());
            ps.setString(2, cl.getTen());
            ps.setInt(3, cl.getTrangThaiXoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int addHang(Hang h) {
        if (h == null || h.getMaHang() == null || h.getTen() == null) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if (h.getMaHang().isEmpty() || h.getTen().isEmpty()) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra mã từ 3 đến 10 ký tự
        if (h.getMaHang().length() < 3 || h.getMaHang().length() > 10) {
            throw new IndexOutOfBoundsException("sai định dạng");
        }

        sql = "insert into Hang\n"
                + "values \n"
                + "(?,?,?,getDate(),getDate())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, h.getMaHang());
            ps.setString(2, h.getTen());
            ps.setInt(3, h.getTrangThaiXoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int addKichCo(KichCo kc) {
        if (kc == null || kc.getMaKichCo() == null || kc.getTen() == null) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra xem các trường có giá trị rỗng không
        if (kc.getMaKichCo().isEmpty() || kc.getTen().isEmpty()) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra mã từ 3 đến 10 ký tự
        if (kc.getMaKichCo().length() < 3 || kc.getMaKichCo().length() > 10) {
            throw new IndexOutOfBoundsException("sai định dạng");
        }

        sql = "insert into KichCo\n"
                + "values \n"
                + "(?,?,?,getDate(),getDate())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kc.getMaKichCo());
            ps.setString(2, kc.getTen());
            ps.setInt(3, kc.getTrangThaiXoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int addMauSac(MauSac ms) {
        if (ms == null || ms.getMaMauSac() == null || ms.getTen() == null) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra xem các trường có giá trị rỗng không
        if (ms.getMaMauSac().isEmpty() || ms.getTen().isEmpty()) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra mã từ 3 đến 10 ký tự
        if (ms.getMaMauSac().length() < 3 || ms.getMaMauSac().length() > 10) {
            throw new IndexOutOfBoundsException("sai định dạng");
        }

        sql = "insert into MauSac\n"
                + "values \n"
                + "(?,?,?,getDate(),getDate())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ms.getMaMauSac());
            ps.setString(2, ms.getTen());
            ps.setInt(3, ms.getTrangThaiXoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }


    public int suaChatLieu(ChatLieu cl, String ma) {
        if (cl == null || cl.getMaChatLieu() == null || cl.getTen() == null) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra xem các trường có giá trị rỗng không
        if (cl.getMaChatLieu().isEmpty() || cl.getTen().isEmpty()) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra mã từ 3 đến 10 ký tự
        if (cl.getMaChatLieu().length() < 3 || cl.getMaChatLieu().length() > 10) {
            throw new IndexOutOfBoundsException("sai định dạng");
        }

        sql = "update ChatLieu set maChatLieu = ?,ten = ?, trangThaiXoa = ?,ngaySuaCuoi = GETDATE() where maChatLieu = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getMaChatLieu());
            ps.setString(2, cl.getTen());
            ps.setInt(3, cl.getTrangThaiXoa());
            ps.setString(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int suaHang(Hang h, String ma) {
        if (h == null || h.getMaHang() == null || h.getTen() == null) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra xem các trường có giá trị rỗng không
        if (h.getMaHang().isEmpty() || h.getTen().isEmpty()) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra mã từ 3 đến 10 ký tự
        if (h.getMaHang().length() < 3 || h.getMaHang().length() > 10) {
            throw new IndexOutOfBoundsException("sai định dạng");
        }

        sql = "update Hang set maHang = ?,ten = ?, trangThaiXoa = ?,ngaySuaCuoi = GETDATE() where maHang = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, h.getMaHang());
            ps.setString(2, h.getTen());
            ps.setInt(3, h.getTrangThaiXoa());
            ps.setString(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int suaKichCo(KichCo kc, String ma) throws IllegalAccessException {
        if (kc == null || kc.getMaKichCo() == null || kc.getTen() == null) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra xem các trường có giá trị rỗng không
        if (kc.getMaKichCo().isEmpty() || kc.getTen().isEmpty()) {
            throw new IllegalAccessException("Không được để trống");
        }

        // Kiểm tra mã từ 3 đến 10 ký tự
        if (kc.getMaKichCo().length() < 3 || kc.getMaKichCo().length() > 10) {
            throw new IndexOutOfBoundsException("sai định dạng");
        }

        sql = "update KichCo set maKichCo = ?,ten = ?, trangThaiXoa = ?,ngaySuaCuoi = GETDATE() where maKichCo = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kc.getMaKichCo());
            ps.setString(2, kc.getTen());
            ps.setInt(3, kc.getTrangThaiXoa());
            ps.setString(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int suaMauSac(MauSac ms, String ma) {
        if (ms == null || ms.getMaMauSac() == null || ms.getTen() == null) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra xem các trường có giá trị rỗng không
        if (ms.getMaMauSac().isEmpty() || ms.getTen().isEmpty()) {
            try {
                throw new IllegalAccessException("Không được để trống");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // Kiểm tra mã từ 3 đến 10 ký tự
        if (ms.getMaMauSac().length() < 3 || ms.getMaMauSac().length() > 10) {
            throw new IndexOutOfBoundsException("sai định dạng");
        }

        sql = "update MauSac set maMauSac = ?,ten = ?, trangThaiXoa = ?,ngaySuaCuoi = GETDATE() where maMauSac = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ms.getMaMauSac());
            ps.setString(2, ms.getTen());
            ps.setInt(3, ms.getTrangThaiXoa());
            ps.setString(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean kiemTraTrungMaChatLieu(String ma) {
        sql = "select maChatLieu from chatlieu where maChatLieu = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean kiemTraTrungTenChatLieu(String ten) {
        sql = "select ten from chatlieu where ten = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean kiemTraTrungTenHang(String ten) {
        sql = "select ten from hang where ten = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean kiemTraTrungMaHang(String ma) {
        sql = "select mahang from hang where mahang = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean kiemTraTrungTenKichCo(String ten) {
        sql = "select ten from KichCo where ten = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean kiemTraTrungMaKichCo(String ma) {
        sql = "select maKichCo from kichco where maKichCo = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean kiemTraTrungTenMauSac(String ten) {
        sql = "select ten from mauSac where ten = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public boolean kiemTraTrungMaMauSac(String ma) {
        sql = "select maMauSac from MauSac where maMauSac = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }




    public int themSanPham(SanPham sp) {
        if (sp == null) {
            return 0;
        }

        sql = "insert into SanPham\n"
                + "values \n"
                + "(?,?,?,getDate(),getDate())";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTen());
            ps.setInt(3, sp.getTrangThaiXoa());
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }

    public int suaSanPham(SanPham sp, String ma) {
        if (sp == null) {
            return 0;
        }
        sql = "update SanPham set maSP = ?,ten = ?, trangThaiXoa = ?,ngaySuaCuoi = GETDATE() where maSP = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTen());
            ps.setInt(3, sp.getTrangThaiXoa());
            ps.setString(4, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }


}


