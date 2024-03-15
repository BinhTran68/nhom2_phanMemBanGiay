/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.model.NhanVien;
import java.time.Instant;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author admin
 */
public class NhanVienService {

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    String sql = "";

    Connection connection = null;

    public NhanVien dangNhap(String sdt, String matKhau) {

        try {
            connection = DBConnect.getConnection();
            sql = "SELECT [id]\n"
                    + "      ,[hoTen]\n"
                    + "      ,[ngaySinh]\n"
                    + "      ,[gioiTinh]\n"
                    + "      ,[diaChi]\n"
                    + "      ,[SDT]\n"
                    + "      ,[email]\n"
                    + "      ,[matKhau]\n"
                    + "      ,[vaiTro]\n"
                    + "      ,[trangThaiXoa]\n"
                    + "      ,[ngayTao]\n"
                    + "      ,[ngaySuaCuoi]\n"
                    + "  FROM [dbo].[NhanVien] WHERE SDT = ? AND matKhau = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, sdt);
            preparedStatement.setObject(2, matKhau);
            
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet == null) {
                return  null;
            }
            NhanVien nhanVien = null;
            while (resultSet.next()) {                
                nhanVien = new NhanVien(
                        resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getDate(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9), 
                        resultSet.getBoolean(10),
                        resultSet.getDate(11),
                        resultSet.getDate(12));
            
            }
               
            return nhanVien;

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

        return null;
    }

}
