package cmc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cmc.model.HoaDon;


public class HoadonDao {
  public Vector<HoaDon> getHoadonList(String sql){
    Vector<HoaDon> vt = new Vector<HoaDon>();
    Connection con = null;
    try {
      con = Connectdb.connect();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while(rs.next()){
        HoaDon hd = new HoaDon();
        hd.setMa(rs.getInt(1));
        hd.setMakhach(rs.getInt(2));
        hd.setNgay(rs.getDate(3));
        hd.setTinhtrang(rs.getBoolean(4));
        vt.add(hd);
      }
      con.close();
    
    } catch (ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return vt;
    
  }
  
  public boolean insert(HoaDon hd){
    try {
      String sql = "insert into hoadon values(?,?,?)";
      Connection con = Connectdb.connect();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, hd.getMakhach());
      ps.setDate(2, hd.getNgay());
      ps.setBoolean(3, hd.isTinhtrang());
      ps.executeUpdate();
      con.close();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
     
      e.printStackTrace();
      return false;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  public boolean update(HoaDon hd){
    try {
      Connection con = Connectdb.connect();
      String sql="update hoadon set makhach = ?,ngay = ?,tinhtrang = ? where ma = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, hd.getMakhach());
      ps.setDate(2, hd.getNgay());
      ps.setBoolean(3, hd.isTinhtrang());
      ps.setInt(4, hd.getMa());
      ps.executeUpdate();
      con.close();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }
    return true;
  }
  
  public boolean delete(int ma){
    try {
      Connection con = Connectdb.connect();
      Statement st = con.createStatement();
      String sql = "delete from hoadon where ma = "+ma;
      st.executeUpdate(sql);
      con.close();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }
    return true;
  }

}
