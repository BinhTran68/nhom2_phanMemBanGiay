package app.model;


public class ChiTietSanPham {

    private int id;
    private String id_SanPham;
    private String id_MauSac;
    private String id_KichCo;
    private String id_Hang;
    private String id_ChatLieu;
    private String id_CTSP_KhuyenMai;
    private String id_KhuyenMai;
    private int soLuongCon;
    private String maCTSP;
    private String mota;
    private double giaBan;
    private String maVach;
    private int trangThaiXoa;
    private String ngayTao;
    private String ngaySuaCuoi;

    public ChiTietSanPham(String string, String string0, double aDouble, int aInt, String string1, String string2, String string3, String string4, String string5, String string6, int aInt0, String string7, String string8) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ChiTietSanPham(String maCTSP, String id_SanPham, double giaBan, int soLuongCon, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, int trangThaiXoa, String mota, String maVach) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_SanPham() {
        return id_SanPham;
    }

    public void setId_SanPham(String id_SanPham) {
        this.id_SanPham = id_SanPham;
    }

    public String getId_MauSac() {
        return id_MauSac;
    }

    public void setId_MauSac(String id_MauSac) {
        this.id_MauSac = id_MauSac;
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

    public int getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
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

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int id, String id_SanPham, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, String id_CTSP_KhuyenMai, String id_KhuyenMai, int soLuongCon, String maCTSP, String mota, double giaBan, String maVach, int trangThaiXoa, String ngayTao, String ngaySuaCuoi) {
        this.id = id;
        this.id_SanPham = id_SanPham;
        this.id_MauSac = id_MauSac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.id_CTSP_KhuyenMai = id_CTSP_KhuyenMai;
        this.id_KhuyenMai = id_KhuyenMai;
        this.soLuongCon = soLuongCon;
        this.maCTSP = maCTSP;
        this.mota = mota;
        this.giaBan = giaBan;
        this.maVach = maVach;
        this.trangThaiXoa = trangThaiXoa;
        this.ngayTao = ngayTao;
        this.ngaySuaCuoi = ngaySuaCuoi;
    }

    public ChiTietSanPham(String id_SanPham, String id_MauSac, String id_KichCo, String id_Hang, String id_ChatLieu, int soLuongCon, String maCTSP, double giaBan) {
        this.id_SanPham = id_SanPham;
        this.id_MauSac = id_MauSac;
        this.id_KichCo = id_KichCo;
        this.id_Hang = id_Hang;
        this.id_ChatLieu = id_ChatLieu;
        this.soLuongCon = soLuongCon;
        this.maCTSP = maCTSP;
        this.giaBan = giaBan;
    }
    

    

}
