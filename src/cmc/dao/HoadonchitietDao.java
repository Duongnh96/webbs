package cmc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cmc.model.HoadonChitiet;

public class HoadonchitietDao {
  public Vector<HoadonChitiet> getHoadonchitietList(String sql){
    Vector<HoadonChitiet> vt = new Vector<HoadonChitiet>();
    Connection con = null;
    try {
      con = Connectdb.connect();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while(rs.next()){
        HoadonChitiet hdct = new HoadonChitiet();
        hdct.setMahd(rs.getInt(1));
        hdct.setMash(rs.getInt(2));
        hdct.setSoluong(rs.getInt(3));
        hdct.setGia(rs.getBigDecimal(4));
        vt.add(hdct);
      }
      con.close();
    
    } catch (ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return vt;
    
  }
  
  public boolean insert(HoadonChitiet hdct){
    try {
      String sql = "insert into hoadonchitiet values(?,?,?,?)";
      Connection con = Connectdb.connect();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, hdct.getMahd());
      ps.setInt(2, hdct.getMash());
      ps.setInt(3, hdct.getSoluong());
      ps.setBigDecimal(4, hdct.getGia());
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
  
  public boolean update(HoadonChitiet hdct){
    try {
      Connection con = Connectdb.connect();
      String sql="update hoadonchitiet set soluong = ?,gia = ? where mahd = ? and makh = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, hdct.getSoluong());
      ps.setBigDecimal(2, hdct.getGia());
      ps.setInt(3, hdct.getMahd());
      ps.setInt(4, hdct.getMash());
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
  
  public boolean delete(int makh,int mash){
    try {
      Connection con = Connectdb.connect();
      Statement st = con.createStatement();
      String sql = "delete from hoadonchitiet where makh = "+makh+"and mash = "+mash;
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
