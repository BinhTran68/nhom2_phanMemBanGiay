/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.model.ChatLieu;
import app.model.Hang;
import app.model.KichCo;
import app.model.MauSac;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ThuocTinhService {

    List<ChatLieu> listChatLieu;
    List<Hang> listHang;
    List<KichCo> listKichCo;
    List<MauSac> listMauSac;

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<ChatLieu> getAll() {
        listChatLieu = new ArrayList<>();
        sql = "select * from chatlieu";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu cl = new ChatLieu(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                listChatLieu.add(cl);
            }
            return listChatLieu;
        } catch (Exception e) {
            return null;
        }
    }
}
