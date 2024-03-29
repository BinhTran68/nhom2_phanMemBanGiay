/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.dto.HoaDonDTO;
import app.model.ChiTietSanPham;
import app.model.HoaDon;
import app.model.HoaDonChiTiet;
import app.repository.HoaDonRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    private HoaDonRepository hoaDonRepository = new HoaDonRepository();

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
                    + "	  KhachHang.SDT, hinhThucThanhToan, trangThaiThanhToan,Voucher.maVoucher  \n"
                    + "  FROM [dbo].[HoaDon] "
                    + " left join NhanVien on HoaDon.id_NhanVien = NhanVien.id "
                    + " left join KhachHang on KhachHang.id = HoaDon.id_KhachHang "
                    + " LEFT JOIN Voucher on Voucher.id = HoaDon.maVoucher";

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
                        resultSet.getString(17),
                        resultSet.getInt(18),
                        resultSet.getString(19)
                        
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



    public List<HoaDonDTO> locTheoGiaTri(String trangThai, String hinhThucThanhToan, Date tuNgay, Date denNgay) {
        List<HoaDonDTO> hoaDonDTOs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnect.getConnection();
            hoaDonDTOs = new ArrayList<>();

            String sql =  sql = "SELECT [HoaDon].id\n"
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
                    + "	  KhachHang.SDT, hinhThucThanhToan, trangThaiThanhToan,Voucher.maVoucher, tienSauGiamGia  \n"
                    + "  FROM [dbo].[HoaDon] "
                    + " left join NhanVien on HoaDon.id_NhanVien = NhanVien.id "
                    + " left join KhachHang on KhachHang.id = HoaDon.id_KhachHang "
                    + " LEFT JOIN Voucher on Voucher.id = HoaDon.maVoucher";

            int count = 1;

            if (trangThai != null && !trangThai.isEmpty()) {
                sql += " WHERE trangThaiThanhToan = ?";
                count++;
            }

            if (hinhThucThanhToan != null && !hinhThucThanhToan.isEmpty()) {
                if (count > 1) {
                    sql += " AND hinhThucThanhToan = ?";
                } else {
                    sql += " WHERE hinhThucThanhToan = ?";
                }
                count++;
            }

            if (tuNgay != null && denNgay != null) {
                if (count > 1) {
                    sql += " AND [HoaDon].ngaySuaCuoi BETWEEN ? AND ?";
                } else {
                    sql += " WHERE [HoaDon].ngaySuaCuoi BETWEEN ? AND ?";
                }
            }

            preparedStatement = connection.prepareStatement(sql);
            count = 1;

            if (trangThai != null && !trangThai.isEmpty()) {
                preparedStatement.setString(count++, trangThai);
            }

            if (hinhThucThanhToan != null && !hinhThucThanhToan.isEmpty()) {
                preparedStatement.setString(count++, hinhThucThanhToan);
            }

            if (tuNgay != null && denNgay != null) {
                java.sql.Date sqlTuNgay = new java.sql.Date(tuNgay.getTime());
                java.sql.Date sqlDenNgay = new java.sql.Date(denNgay.getTime());
                preparedStatement.setDate(count++, sqlTuNgay);
                preparedStatement.setDate(count++, sqlDenNgay);
            }

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HoaDonDTO hoaDonDTO = new HoaDonDTO(
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
                        resultSet.getString(17),
                        resultSet.getInt(18),
                        resultSet.getString(19),
                        resultSet.getDouble(20)
                );
                hoaDonDTOs.add(hoaDonDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hoaDonDTOs;
    }
    
    public List<HoaDonDTO> getHoaDonToDay() {
        List<HoaDonDTO> hoaDonDTOs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnect.getConnection();
            hoaDonDTOs = new ArrayList<>();

            String sql =  sql = "SELECT [HoaDon].id\n"
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
                    + "	  KhachHang.SDT, hinhThucThanhToan, trangThaiThanhToan,Voucher.maVoucher, tienSauGiamGia  \n"
                    + "  FROM [dbo].[HoaDon] "
                    + " left join NhanVien on HoaDon.id_NhanVien = NhanVien.id "
                    + " left join KhachHang on KhachHang.id = HoaDon.id_KhachHang "
                    + " LEFT JOIN Voucher on Voucher.id = HoaDon.maVoucher "
                    + " WHERE CONVERT(DATE, [HoaDon].ngayTao) = CONVERT(DATE, GETDATE())";

            int count = 1;
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
                        resultSet.getString(17),
                        resultSet.getInt(18),
                        resultSet.getString(19),
                        resultSet.getDouble(20)
                );
                hoaDonDTOs.add(hoaDonDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hoaDonDTOs;
    }
    

    public String taoHoaDon(HoaDon hoaDon) {
        String maHoaDon = hoaDonRepository.taoHoaDonByHoaDon(hoaDon);
        System.out.println(maHoaDon);
        return maHoaDon;
    }
    
    public HoaDonDTO findHoaDonByMaHoaDon(String maHoaDon) {
        return hoaDonRepository.findHoaDonByMaHoaDon(maHoaDon);
    }

    public int updateHoaDonByMaHoaDon(String maHoaDonUpdate) {
        return hoaDonRepository.updateHoaDonByMaHoaDon(maHoaDonUpdate);
    }

    public List<ChiTietSanPham> findChiTietSanPhamByMaHoaDon(String maHoaDon) {
       return hoaDonRepository.findChiTietSanPhamByMaHoaDon(maHoaDon);
    }

    public int updateHoaDonByHoaDonUpdate(HoaDonDTO hoaDonUpdate) {
        return hoaDonRepository.updateHoaDonByHoaDonDTO(hoaDonUpdate);
    }
    
    

}
