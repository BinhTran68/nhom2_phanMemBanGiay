/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;
import java.sql.*;
import app.model.KhachHang;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author admin
 */
public class KhachHangService {
    List<KhachHang> listKH;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Connection connection = null;
    String sql = "";
    
    public List<KhachHang> getAll(){
        listKH = new ArrayList<>();
        sql = "select id, maKH, hoTen, ngaySinh, gioiTinh, diaChi, SDT,email from KhachHang";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                KhachHang kh = new KhachHang(
                        resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getString(3),
                        resultSet.getDate(4), 
                        resultSet.getInt(5), 
                        resultSet.getString(6), 
                        resultSet.getString(7), 
                        resultSet.getString(8));
                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<KhachHang> getLichSu(){
        listKH = new ArrayList<>();
        sql = "select id, maKH, hoTen, ngaySinh, gioiTinh, diaChi, SDT,email from KhachHang";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                KhachHang kh = new KhachHang(
                        resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getString(3),
                        resultSet.getDate(4), 
                        resultSet.getInt(5), 
                        resultSet.getString(6), 
                        resultSet.getString(7), 
                        resultSet.getString(8));
                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public int insertKH (KhachHang kh){
        sql = "insert into KhachHang(maKH, hoTen, ngaySinh, gioiTinh,email, SDT, diaChi)values(?,?,?,?,?,?,?)";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setObject(1, kh.getMaKH());
            preparedStatement.setObject(2, kh.getHoTen());
            preparedStatement.setObject(4, kh.getNgaySinh());
            preparedStatement.setObject(5, kh.getGioiTinh());
            preparedStatement.setObject(7, kh.getEmail());
            preparedStatement.setObject(7, kh.getSdt());
            preparedStatement.setObject(8, kh.getDiaChi());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int updateNhanVien(String ma, KhachHang kh){
        sql = "update KhachHang set maNV = ?, hoTen = ?,ngaySinh = ?, gioiTinh=?, SDT = ?,email = ?, diaChi = ? where maKH like ?";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, kh.getMaKH());
            preparedStatement.setObject(2, kh.getHoTen());
            preparedStatement.setObject(4, kh.getNgaySinh());
            preparedStatement.setObject(5, kh.getGioiTinh());
            preparedStatement.setObject(7, kh.getEmail());
            preparedStatement.setObject(7, kh.getSdt());
            preparedStatement.setObject(8, kh.getDiaChi());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;   
        }
    }
}
