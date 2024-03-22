/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.model.ChatLieu;
import app.model.NhanVien;
import java.time.Instant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class NhanVienService {
    List<NhanVien> listNV;

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
   
    public  List<NhanVien> getAll(){
        listNV = new ArrayList<>();
        sql = "	select id, maNV,hoTen, vaiTro, ngaySinh, gioiTinh, SDT, email, diaChi from NhanVien";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { 
                NhanVien nv = new NhanVien(
                        resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getString(3), 
                        resultSet.getDate(5), 
                        resultSet.getInt(6) , 
                        resultSet.getString(7), 
                        resultSet.getString(8), 
                        resultSet.getString(9), 
                        resultSet.getString(4));
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insertNV(NhanVien nv) {
        sql = "insert into NhanVien( maNV,hoTen,vaiTro,ngaySinh, gioiTinh,SDT, email, diaChi)values(?,?,?,?,?,?,?,?)";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, nv.getMaNV());
            preparedStatement.setObject(2, nv.getHoTen());
            preparedStatement.setObject(3, nv.getVaiTro());
            preparedStatement.setObject(4, nv.getNgaySinh());
            preparedStatement.setObject(5, nv.getGioiTinh());
            preparedStatement.setObject(6, nv.getSdt());
            preparedStatement.setObject(7, nv.getEmail());
            preparedStatement.setObject(8, nv.getDiaChi());
            return preparedStatement.executeUpdate();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int updateNhanVien(String ma, NhanVien nv){
        sql = "update NhanVien set maNV = ?, hoTen = ?, vaiTro = ?,ngaySinh = ?, gioiTinh=?, SDT = ?,email = ?, diaChi = ? where maNV like ?";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, nv.getMaNV());
            preparedStatement.setObject(2, nv.getHoTen());
            preparedStatement.setObject(3, nv.getVaiTro());
            preparedStatement.setObject(4, nv.getNgaySinh());
            preparedStatement.setObject(5, nv.getGioiTinh());
            preparedStatement.setObject(6, nv.getSdt());
            preparedStatement.setObject(7, nv.getEmail());
            preparedStatement.setObject(8, nv.getDiaChi());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;   
        }
    }
    public List<NhanVien> timTheoMa(String ma){
        try {
            listNV = new ArrayList<>();
            connection = DBConnect.getConnection();
            sql = "select id, maNV,hoTen, vaiTro, ngaySinh, gioiTinh, SDT, email, diaChi from NhanVien where maNV like ?";
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(2, "%"+ma+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                NhanVien nv = new NhanVien(
                        resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getString(3), 
                        resultSet.getDate(5), 
                        resultSet.getInt(6) , 
                        resultSet.getString(7), 
                        resultSet.getString(8), 
                        resultSet.getString(9), 
                        resultSet.getString(4));
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
    
