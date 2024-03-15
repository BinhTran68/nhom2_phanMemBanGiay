/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import java.util.Date;

/**
 *
 * @author admin
 */
public class HoaDon {
    private int id;
    
    private int idKhachHang;
    
    private int idNhanVien;
    
    private int maHoaDon;
    
    private String tenNguoiNhan;
    
    private String diaChi;
    
    private Long tienKhachTra;
    
    private Long tienThuaLai;
    
    private Long thanhTien;
    
    private boolean trangThaiXoa;
    
    private Date ngayTao;
    
    private Date ngaySuaCuoi;
    
    private String ghiChu;
    

    public HoaDon() {
    }

    public HoaDon(int id, int idKhachHang, int idNhanVien, int maHoaDon, String tenNguoiNhan, String diaChi, Long tienKhachTra, Long tienThuaLai, Long thanhTien, boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi, String ghiChu) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.maHoaDon = maHoaDon;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.tienKhachTra = tienKhachTra;
        this.tienThuaLai = tienThuaLai;
        this.thanhTien = thanhTien;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
        this.ghiChu = ghiChu;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Long getTienKhachTra() {
        return tienKhachTra;
    }

    public void setTienKhachTra(Long tienKhachTra) {
        this.tienKhachTra = tienKhachTra;
    }

    public Long getTienThuaLai() {
        return tienThuaLai;
    }

    public void setTienThuaLai(Long tienThuaLai) {
        this.tienThuaLai = tienThuaLai;
    }

    public Long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Long thanhTien) {
        this.thanhTien = thanhTien;
    }

    public boolean isTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(boolean trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySuaCuoi() {
        return ngaySuaCuoi;
    }

    public void setNgaySuaCuoi(Date ngaySuaCuoi) {
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", idKhachHang=" + idKhachHang + ", idNhanVien=" + idNhanVien + ", maHoaDon=" + maHoaDon + ", tenNguoiNhan=" + tenNguoiNhan + ", diaChi=" + diaChi + ", tienKhachTra=" + tienKhachTra + ", tienThuaLai=" + tienThuaLai + ", thanhTien=" + thanhTien + ", trangThaiXoa=" + trangThaiXoa + ", ngayTao=" + ngayTao + ", ngaySuaCuoi=" + ngaySuaCuoi + '}';
    }
      
}
