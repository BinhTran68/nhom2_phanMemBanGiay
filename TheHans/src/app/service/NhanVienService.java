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
        return new NhanVien();
    }

}
