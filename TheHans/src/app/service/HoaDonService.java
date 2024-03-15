/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.dto.HoaDonDTO;
import app.model.HoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class HoaDonService {

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    String sql = "";

    Connection connection = null;

    private List<HoaDonDTO> hoaDonDTOs = null;

    public List<HoaDonDTO> findAllHoaDon() {
        try {
            hoaDonDTOs = new ArrayList<>();
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
                    + "	  KhachHang.SDT\n"
                    + "  FROM [dbo].[HoaDon] left join NhanVien on HoaDon.id_NhanVien = NhanVien.id left join KhachHang on KhachHang.id = HoaDon.id";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HoaDonDTO hoaDonDTO = new HoaDonDTO(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getLong(7),
                        resultSet.getLong(8),
                        resultSet.getLong(9),
                        resultSet.getBoolean(10),
                        resultSet.getDate(11),
                        resultSet.getDate(12),
                        resultSet.getString(13),
                        resultSet.getString(14),
                        resultSet.getString(15),
                        resultSet.getString(16)
                );
                hoaDonDTOs.add(hoaDonDTO);

            }

            return hoaDonDTOs;
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
        return hoaDonDTOs;
    }

}
