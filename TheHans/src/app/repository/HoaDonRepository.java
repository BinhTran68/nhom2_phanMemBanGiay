/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repository;

import app.dto.HoaDonDTO;
import app.model.HoaDon;
import app.service.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class HoaDonRepository {

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    String sql = "";

    Connection connection = null;

    public String taoHoaDonByHoaDon(HoaDon hoaDon) {
        String maHoaDon = null;
        try {
            connection = DBConnect.getConnection();
            // Tạo hóa đơn. Lấy ra id hóa đơn rồi tạo  
            sql = "INSERT INTO [dbo].[HoaDon]\n"
                    + "           ([id_KhachHang]\n"
                    + "           ,[id_NhanVien]\n"
                    + "           ,[maHoaDon]\n"
                    + "           ,[tienKhachTra]\n"
                    + "           ,[tienThuaLai]\n"
                    + "           ,[thanhTien]\n"
                    + "           ,[ghiChu]\n"
                    + "           ,[hinhThucThanhToan]\n"
                    + "           ,[trangThaiThanhToan]\n"
                    + "           ,[maVoucher]\n"
                    + "           ,[tienSauGiamGia]\n" // Đặt dấu ngoặc mở ở đây
                    + "           ,[ngayTao]\n"
                    + "           ,[ngaySuaCuoi])\n" // Đóng dấu ngoặc sau danh sách giá trị
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), GETDATE())\n";

            // Tạo hóa đơn xong lấy id hóa đơn và danh sách sản phẩm. 
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, hoaDon.getIdKhachHang());
            preparedStatement.setObject(2, hoaDon.getIdNhanVien());
            preparedStatement.setObject(3, hoaDon.getMaHoaDon());
            preparedStatement.setObject(4, hoaDon.getTienKhachTra());
            preparedStatement.setObject(5, hoaDon.getTienThuaLai());
            preparedStatement.setObject(6, hoaDon.getThanhTien());
            preparedStatement.setObject(7, hoaDon.getGhiChu());
            preparedStatement.setObject(8, hoaDon.getHinhThucThanhToan());
            preparedStatement.setObject(9, hoaDon.getTrangThaiThanhToan());
            preparedStatement.setObject(10, hoaDon.getIdVoucher());
            preparedStatement.setObject(11, hoaDon.getTienSauGiamGia());

            int kq = preparedStatement.executeUpdate();
            if (kq > 0) {
                return hoaDon.getMaHoaDon();
            }

            return maHoaDon;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return maHoaDon;
    }

    public HoaDonDTO findHoaDonByMaHoaDon(String maHoaDon) {
        HoaDonDTO hoaDon = null;
        try {

            connection = DBConnect.getConnection();
            sql = "SELECT [HoaDon].id\n"
                    + "      ,id_KhachHang\n"
                    + "      ,id_NhanVien\n"
                    + "      ,maHoaDon\n"
                    + "      ,tenNguoiNhan\n"
                    + "      ,[HoaDon].diaChi\n"
                    + "      ,tienKhachTra\n"
                    + "      ,tienThuaLai\n"
                    + "      ,thanhTien\n"
                    + "      ,[HoaDon].trangThaiXoa\n"
                    + "      ,[HoaDon].ngayTao\n"
                    + "      ,[HoaDon].ngaySuaCuoi\n"
                    + "      ,ghiChu,\n"
                    + "	  NhanVien.hoTen,\n"
                    + "	  KhachHang.hoTen,\n"
                    + "	  KhachHang.SDT, hinhThucThanhToan \n"
                    + "  FROM [dbo].[HoaDon] left join NhanVien on HoaDon.id_NhanVien = NhanVien.id left join KhachHang on KhachHang.id = HoaDon.id";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                  hoaDon = new HoaDonDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getDouble(8),
                        resultSet.getDouble(9),
                        resultSet.getBoolean(10),
                        resultSet.getDate(11),
                        resultSet.getDate(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16),
                        resultSet.getString(17));
            }

            return hoaDon;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hoaDon;
    }

}
