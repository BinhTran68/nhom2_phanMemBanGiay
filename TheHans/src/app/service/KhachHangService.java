/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;
import app.dto.LichSuKH;
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
    List<LichSuKH> listLS;
    
    public List<KhachHang> getAll(){
        listKH = new ArrayList<>();
        sql = "select id, maKH, hoTen, ngaySinh, gioiTinh,email, SDT, diaChi from KhachHang";
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
                        resultSet.getString(8), 
                        resultSet.getString(7), 
                        resultSet.getString(6));
                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<LichSuKH> getLichSu(){
        listLS = new ArrayList<>();
        sql = "select kh.id, kh.hoTen, hd.maHoaDon, kh.diaChi,hd.ngayTao, hd.thanhTien, hd.trangThaiThanhToan\n" +
                "from KhachHang kh join HoaDon hd\n" +
                "on kh.id = hd.id_KhachHang ";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                LichSuKH ls = new LichSuKH(
                        resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getString(3), 
                        resultSet.getString(4), 
                        resultSet.getDate(5), 
                        resultSet.getLong(6), 
                        resultSet.getInt(7));
                listLS.add(ls);
            }
            return listLS;
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
            preparedStatement.setObject(3, kh.getNgaySinh());
            preparedStatement.setObject(4, kh.getGioiTinh());
            preparedStatement.setObject(5, kh.getEmail());
            preparedStatement.setObject(6, kh.getSdt());
            preparedStatement.setObject(7, kh.getDiaChi());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int updateKhachHang(String ma, KhachHang kh){
        sql = "update KhachHang set hoTen = ?,ngaySinh = ?, gioiTinh=?, SDT = ?,email = ?, diaChi = ? where maKH like ? ";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setObject(1, kh.getHoTen());
            preparedStatement.setObject(2, kh.getNgaySinh());
            preparedStatement.setObject(3, kh.getGioiTinh());
            preparedStatement.setObject(4, kh.getEmail());
            preparedStatement.setObject(5, kh.getSdt());
            preparedStatement.setObject(6, kh.getDiaChi());
            preparedStatement.setObject(7, kh.getMaKH());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0; 
        }
          
    }
    public List<KhachHang> timTheoTen(String ten){
        try {
            listKH = new ArrayList<>();
            connection = DBConnect.getConnection();
            sql = "select id, maKH,hoTen, ngaySinh, gioiTinh, SDT, email, diaChi from KhachHang where hoTen like ?";
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, "%"+ten+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                KhachHang kh = new KhachHang(
                        resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getString(3), 
                        resultSet.getDate(4), 
                        resultSet.getInt(5) , 
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
    
    public List<LichSuKH> timTheoTenLS(String ten){
        try {
            listLS = new ArrayList<>();
            connection = DBConnect.getConnection();
            sql = "select kh.id, kh.hoTen, hd.maHoaDon, kh.diaChi,hd.ngayTao, hd.thanhTien, hd.trangThaiThanhToan\n" +
                    "from KhachHang kh join HoaDon hd\n" +
                    "on kh.id = hd.id_KhachHang\n" +
                    "where hoTen like ?";
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, "%"+ten+"%");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                LichSuKH ls = new LichSuKH(
                        resultSet.getInt(1), 
                        resultSet.getString(2), 
                        resultSet.getString(3), 
                        resultSet.getString(4), 
                        resultSet.getDate(5), 
                        resultSet.getLong(6), 
                        resultSet.getInt(7));
                listLS.add(ls);
            }
            return listLS;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int deleteKH(String ma) {
        sql = "delete from KhachHang where maKH like ?";
        try {// xóa được 
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ma);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
