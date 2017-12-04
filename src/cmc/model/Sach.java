package cmc.model;

import java.math.BigDecimal;

public class Sach {
  private int ma;
  private String ten;
  private BigDecimal gia;
  private int loai;
  private String img;
  private String noidung;
  private int soluong;

  public int getMa() {
    return ma;
  }

  public void setMa(int ma) {
    this.ma = ma;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  public BigDecimal getGia() {
    return gia;
  }

  public void setGia(BigDecimal gia) {
    this.gia = gia;
  }

  public int getLoai() {
    return loai;
  }

  public void setLoai(int loai) {
    this.loai = loai;
  }

  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public String getNoidung() {
    return noidung;
  }

  public void setNoidung(String noidung) {
    this.noidung = noidung;
  }

  public int getSoluong() {
    return soluong;
  }

  public void setSoluong(int soluong) {
    this.soluong = soluong;
  }

}
