/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

/**
 *
 * @author admin
 */
public class KichCo {

    private int id;
    private String maKichCo;
    private String ten;
    private int trangThaiXoa;
    private String ngayTao;
    private String ngaySuaCuoi;

    public KichCo() {
    }

    public KichCo(int id, String maKichCo, String ten, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        this.id = id;
        this.maKichCo = maKichCo;
        this.ten = ten;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaKichCo() {
        return maKichCo;
    }

    public void setMaKichCo(String maKichCo) {
        this.maKichCo = maKichCo;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(int trangThaiXoa) {
        this.trangThaiXoa = trangThaiXoa;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgaySuaCuoi() {
        return ngaySuaCuoi;
    }

    public void setNgaySuaCuoi(String ngaySuaCuoi) {
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

}
