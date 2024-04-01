package app.service;

import app.model.Thongke;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ThongKeService {

    private List<Thongke> listTK;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<Thongke> getAll() {
        listTK = new ArrayList<>();

        sql = "SELECT (d.ngaySuaCuoi) as Thang, s.ten, h.soLuong, SUM(D.tienSauGiamGia) as TongDoanhThu \n"
                + "                FROM HoaDon d\n"
                + "                JOIN HoaDonChiTiet h ON d.id = h.id_HoaDon\n"
                + "                JOIN ChiTietSanPham c ON h.id_CTSP = c.id\n"
                + "                JOIN SanPham s ON c.id_SanPham = s.id\n"
                + "                GROUP BY s.ten, h.soLuong, d.ngaySuaCuoi\n"
                + "                ORDER BY Thang DESC;";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Thongke tk = new Thongke(rs.getDate(1), rs.getString(2), rs.getInt(3), rs.getInt(4));

                listTK.add(tk);
            }
            return listTK;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int sumDay(java.util.Date start, java.util.Date end) {
        listTK = new ArrayList<>();

        sql = "SELECT SUM(D.tienSauGiamGia) as Tongtien \n"
                + "                FROM HoaDon d\n"
                + "                JOIN HoaDonChiTiet h ON d.id = h.id_HoaDon\n"
                + "                JOIN ChiTietSanPham c ON h.id_CTSP = c.id\n"
                + "                JOIN SanPham s ON c.id_SanPham = s.id\n"
                + "				WHERE d.ngaySuaCuoi BETWEEN ? AND ?;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, sdf.format(start));
            ps.setString(2, sdf.format(end));
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("Tongtien");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<Thongke> KhoangDate(java.util.Date start, java.util.Date end) {
        listTK = new ArrayList<>();

        sql = "SELECT (d.ngaySuaCuoi) as Thang, s.ten, h.soLuong, SUM(D.tienSauGiamGia) as TongTien\n"
                + "                FROM HoaDon d\n"
                + "                JOIN HoaDonChiTiet h ON d.id = h.id_HoaDon\n"
                + "                JOIN ChiTietSanPham c ON h.id_CTSP = c.id\n"
                + "                JOIN SanPham s ON c.id_SanPham = s.id\n"
                + "                WHERE d.ngaySuaCuoi BETWEEN ? AND ?\n"
                + "				GROUP BY s.ten, h.soLuong, d.ngaySuaCuoi";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ps.setString(1, sdf.format(start));
            ps.setString(2, sdf.format(end));
            rs = ps.executeQuery();
            while (rs.next()) {
                Thongke tk = new Thongke(rs.getDate(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                listTK.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTK;
      
    }
}
