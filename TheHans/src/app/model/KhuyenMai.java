package app.model;

import java.util.Date;

public class KhuyenMai {

    private int STT;
    private String ten;
    private String ma;
    private String loaiGiam;
    private int Giatri;
    private String ngayBD;
    private String ngayKT;
    private String Trangthai;

    public KhuyenMai() {
    }

    public KhuyenMai(int STT, String ten, String ma, String loaiGiam, int Giatri, String ngayBD, String ngayKT, String Trangthai) {
        this.STT = STT;
        this.ten = ten;
        this.ma = ma;
        this.loaiGiam = loaiGiam;
        this.Giatri = Giatri;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.Trangthai = Trangthai;
    }

    public KhuyenMai(String ten, String ma, String loaiGiam, int Giatri, String ngayBD, String ngayKT, String Trangthai) {
        this.ten = ten;
        this.ma = ma;
        this.loaiGiam = loaiGiam;
        this.Giatri = Giatri;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.Trangthai = Trangthai;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getLoaiGiam() {
        return loaiGiam;
    }

    public void setLoaiGiam(String loaiGiam) {
        this.loaiGiam = loaiGiam;
    }

    public int getGiatri() {
        return Giatri;
    }

    public void setGiatri(int Giatri) {
        this.Giatri = Giatri;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }

    public String getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(String ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(String Trangthai) {
        this.Trangthai = Trangthai;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "STT=" + STT + ", ten=" + ten + ", ma=" + ma + ", loaiGiam=" + loaiGiam + ", Giatri=" + Giatri + ", ngayBD=" + ngayBD + ", ngayKT=" + ngayKT + ", Trangthai=" + Trangthai + '}';
    }
    public Object[] toDataRow() {
        return new Object[]{this.getSTT(), this.getMa(), this.getTen(), 
            this.getLoaiGiam(), this.getGiatri(), this.getNgayBD(), 
            this.getNgayKT(), this.getTrangthai()};
    }

}
