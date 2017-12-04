package cmc.model;

import java.sql.Date;

public class HoaDon {
  private int ma;
  private int makhach;
  private Date ngay;
  private boolean tinhtrang;
  public int getMa() {
    return ma;
  }
  public void setMa(int ma) {
    this.ma = ma;
  }
  public int getMakhach() {
    return makhach;
  }
  public void setMakhach(int makhach) {
    this.makhach = makhach;
  }
  public Date getNgay() {
    return ngay;
  }
  public void setNgay(Date ngay) {
    this.ngay = ngay;
  }
  public boolean isTinhtrang() {
    return tinhtrang;
  }
  public void setTinhtrang(boolean tinhtrang) {
    this.tinhtrang = tinhtrang;
  }
  
  

}
