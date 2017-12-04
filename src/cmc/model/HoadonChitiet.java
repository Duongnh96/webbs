package cmc.model;

import java.math.BigDecimal;

public class HoadonChitiet {
  private int mahd;
  private int mash;
  private int soluong;
  private BigDecimal gia;

  public int getMahd() {
    return mahd;
  }

  public void setMahd(int mahd) {
    this.mahd = mahd;
  }

  public int getMash() {
    return mash;
  }

  public void setMash(int mash) {
    this.mash = mash;
  }

  public int getSoluong() {
    return soluong;
  }

  public void setSoluong(int soluong) {
    this.soluong = soluong;
  }

  public BigDecimal getGia() {
    return gia;
  }

  public void setGia(BigDecimal gia) {
    this.gia = gia;
  }

}
