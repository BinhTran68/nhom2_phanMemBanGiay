package app.service;

import app.model.KhuyenMai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhuyenMaiService {

    private List<KhuyenMai> listKM;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<KhuyenMai> getAll() {
        listKM = new ArrayList<>();

        sql = "select id, maKM, tenKM, loaiKM, ngayBatDau, ngayKetThuc, giaTri, trangThaiXoa from KhuyenMai";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6),
                        rs.getString(7), rs.getString(8));

                listKM.add(km);
            }
            return listKM;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
