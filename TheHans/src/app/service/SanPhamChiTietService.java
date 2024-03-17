/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import app.model.ChiTietSanPham;
import com.microsoft.sqlserver.jdbc.SQLServerStatementColumnEncryptionSetting;

import java.util.ArrayList;
import java.util.List;

public class SanPhamChiTietService {
public List<ChiTietSanPham> getAllSPCT() {
    List<ChiTietSanPham> list = new ArrayList<>();
    String sql = """
       select maCTSP,SanPham.ten, ChatLieu.ten, KichCo.ten,MauSac.ten, Hang.ten, soLuongCon, giaBan  from ChiTietSanPham
                  join SanPham on SanPham.id = ChiTietSanPham.id_SanPham
                  join ChatLieu on ChatLieu.id = ChiTietSanPham.id_ChatLieu
                  join KichCo on KichCo.id = ChiTietSanPham.id_KichCo
                  join MauSac on MauSac.id = ChiTietSanPham.id_MauSac
                  join Hang on Hang.id = ChiTietSanPham.id_Hang
                """;
    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ChiTietSanPham ctsp = new ChiTietSanPham(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getInt(7),
                    rs.getDouble(8)
            );

            list.add(ctsp);
        }
    } catch (Exception e) {
        e.printStackTrace(); // In ra thông báo lỗi để xem nguyên nhân cụ thể
    }
    return list; // Trả về danh sách, có thể rỗng nếu có lỗi xảy ra
}

}
