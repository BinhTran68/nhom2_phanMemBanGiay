package app.model;

import java.util.Date;

public class ChiTietSanPham {

    private String id;
    private String id_SanPham;
    private String id_mausac;
    private String id_KichCo;
    private String id_Hang;
    private String id_ChatLieu;
    private String id_CTSP_KhuyenMai;
    private String id_KhuyenMai;
    private int soLuongCon;
    private String maCTSp;
    private String mota;
    private double giaBan;
    private String maVach;
    private Boolean trangThaiXoa;
    private Date ngayTao;
    private Date ngaySuaCuoi;

    public ChiTietSanPham(String id, String id_SanPham, String id_mausac, String id_KichCo, String id_Hang, String id_ChatLieu, String id_CTSP_KhuyenMai, String id_KhuyenMai, int soLuongCon, String maCTSp, String mota, double giaBan, String maVach, Boolean trangThaiXoa, Date ngayTao, Date ngaySuaCuoi) {
        this.id = id;
        this.id_SanPham = id_SanPham;
        this.id_mausac = id_mausac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.id_CTSP_KhuyenMai = id_CTSP_KhuyenMai;
        this.id_KhuyenMai = id_KhuyenMai;
        this.soLuongCon = soLuongCon;
        this.maCTSp = maCTSp;
        this.mota = mota;
        this.giaBan = giaBan;
        this.maVach = maVach;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    public ChiTietSanPham(String id_SanPham, String id_mausac, String id_KichCo, String id_Hang, String id_ChatLieu, String maCTSp, int soLuongCon, double giaBan) {
        this.id_SanPham = id_SanPham;
        this.id_mausac = id_mausac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.maCTSp = maCTSp;
        this.soLuongCon = soLuongCon;
        this.giaBan = giaBan;
    }

    public int getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
    }
    

    public ChiTietSanPham() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_SanPham() {
        return id_SanPham;
    }

    public void setId_SanPham(String id_SanPham) {
        this.id_SanPham = id_SanPham;
    }

    public String getId_mausac() {
        return id_mausac;
    }

    public void setId_mausac(String id_mausac) {
        this.id_mausac = id_mausac;
    }

    public String getId_KichCo() {
        return id_KichCo;
    }

    public void setId_KichCo(String id_KichCo) {
        this.id_KichCo = id_KichCo;
    }

    public String getId_Hang() {
        return id_Hang;
    }

    public void setId_Hang(String id_Hang) {
        this.id_Hang = id_Hang;
    }

    public String getId_ChatLieu() {
        return id_ChatLieu;
    }

    public void setId_ChatLieu(String id_ChatLieu) {
        this.id_ChatLieu = id_ChatLieu;
    }

    public String getId_CTSP_KhuyenMai() {
        return id_CTSP_KhuyenMai;
    }

    public void setId_CTSP_KhuyenMai(String id_CTSP_KhuyenMai) {
        this.id_CTSP_KhuyenMai = id_CTSP_KhuyenMai;
    }

    public String getId_KhuyenMai() {
        return id_KhuyenMai;
    }

    public void setId_KhuyenMai(String id_KhuyenMai) {
        this.id_KhuyenMai = id_KhuyenMai;
    }

    public String getMaCTSp() {
        return maCTSp;
    }

    public void setMaCTSp(String maCTSp) {
        this.maCTSp = maCTSp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public Boolean getTrangThaiXoa() {
        return trangThaiXoa;
    }

    public void setTrangThaiXoa(Boolean trangThaiXoa) {
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

}
