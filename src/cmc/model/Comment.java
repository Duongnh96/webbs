package cmc.model;

import java.sql.Date;

public class Comment {
  private int makh;
  private Date ngay;
  private String noidung;
  private boolean visible;
  public int getMakh() {
    return makh;
  }
  public void setMakh(int makh) {
    this.makh = makh;
  }
  public Date getNgay() {
    return ngay;
  }
  public void setNgay(Date ngay) {
    this.ngay = ngay;
  }
  public String getNoidung() {
    return noidung;
  }
  public void setNoidung(String noidung) {
    this.noidung = noidung;
  }
  public boolean isVisible() {
    return visible;
  }
  public void setVisible(boolean visible) {
    this.visible = visible;
  }
  
  
}
