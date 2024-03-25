package app.service;

import app.model.Thongke;
import java.sql.*;
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

        sql = "SELECT (d.ngaySuaCuoi) as Thang, s.ten, h.soLuong, SUM(c.giaBan) as TongDoanhThu \n"
                + "FROM HoaDon d\n"
                + "JOIN HoaDonChiTiet h ON d.id = h.id_HoaDon\n"
                + "JOIN ChiTietSanPham c ON h.id_CTSP = c.id\n"
                + "JOIN SanPham s ON c.id_SanPham = s.id\n"
                + "GROUP BY s.ten, h.soLuong, d.ngaySuaCuoi\n"
                + "ORDER BY Thang DESC;";

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

    public ArrayList<Thongke> getTop5(String nam) {
        listTK = new ArrayList<>();
        sql = "SELECT TOP(5) YEAR(d.ngaySuaCuoi) as Nam, s.ten, h.soLuong, SUM(c.giaBan) as TongDoanhThu \n"
                + "FROM HoaDon d\n"
                + "JOIN HoaDonChiTiet h ON d.id = h.id_HoaDon\n"
                + "JOIN ChiTietSanPham c ON h.id_CTSP = c.id\n"
                + "JOIN SanPham s ON c.id_SanPham = s.id\n"
                + "WHERE YEAR(d.ngaySuaCuoi) = ?\n"
                + "GROUP BY YEAR(d.ngaySuaCuoi), s.ten, h.soLuong\n"
                + "ORDER BY TongDoanhThu DESC";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nam);
            ps.execute();
            rs = ps.executeQuery();
            while (rs.next()) {
                Thongke tk = new Thongke(rs.getDate(1), rs.getString(2), rs.getInt(3), rs.getInt(4));

                listTK.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
