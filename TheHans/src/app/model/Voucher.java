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
public class Voucher {
    private int id;
    
    private String maVoucher;
    
    private Double soTienToiThieu;
    
    private Double  soTienToiDa;
    
    private Double phanTramGiamTrenHoaDon;
    
    private Date ngayTao;
    
    private Date ngaySuaCuoi;

    public Voucher() {
    }

    public Voucher(int id, String maVoucher, Double soTienToiThieu, Double soTienToiDa, Double phanTramGiamTrenHoaDon, Date ngayTao, Date ngaySuaCuoi) {
        this.id = id;
        this.maVoucher = maVoucher;
        this.soTienToiThieu = soTienToiThieu;
        this.soTienToiDa = soTienToiDa;
        this.phanTramGiamTrenHoaDon = phanTramGiamTrenHoaDon;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public Double getSoTienToiThieu() {
        return soTienToiThieu;
    }

    public void setSoTienToiThieu(Double soTienToiThieu) {
        this.soTienToiThieu = soTienToiThieu;
    }

    public Double getSoTienToiDa() {
        return soTienToiDa;
    }

    public void setSoTienToiDa(Double soTienToiDa) {
        this.soTienToiDa = soTienToiDa;
    }

    public Double getPhanTramGiamTrenHoaDon() {
        return phanTramGiamTrenHoaDon;
    }

    public void setPhanTramGiamTrenHoaDon(Double phanTramGiamTrenHoaDon) {
        this.phanTramGiamTrenHoaDon = phanTramGiamTrenHoaDon;
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
    
    
    
}
