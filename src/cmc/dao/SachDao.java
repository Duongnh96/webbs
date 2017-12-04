package cmc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cmc.model.Sach;

public class SachDao {
  public Vector<Sach> getSachList(String sql){
    Vector<Sach> vt = new Vector<Sach>();
    Connection con = null;
    try {
      con = Connectdb.connect();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while(rs.next()){
        Sach sh = new Sach();
        sh.setMa(rs.getInt(1));
        sh.setTen(rs.getNString(2));
        sh.setGia(rs.getBigDecimal(3));
        sh.setLoai(rs.getInt(4));
        sh.setImg(rs.getString(5));
        sh.setNoidung(rs.getNString(6));
        sh.setSoluong(rs.getInt(7));
        vt.add(sh);
      }
    
    } catch (ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return vt;
    
  }
  
  public Sach getById(int ma) {
	  Sach sh = new Sach();
	  try {
		Connection con = Connectdb.connect();
		String sql = "select * from sach where ma = "+ma;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			sh.setMa(rs.getInt(1));
	        sh.setTen(rs.getNString(2));
	        sh.setGia(rs.getBigDecimal(3));
	        sh.setLoai(rs.getInt(4));
	        sh.setImg(rs.getString(5));
	        sh.setNoidung(rs.getNString(6));
	        sh.setSoluong(rs.getInt(7));
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return sh;
	  
  }
  
  public boolean insert(Sach sh){
    try {
      String sql = "insert into sach values(?,?,?,?,?,?)";
      Connection con = Connectdb.connect();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setNString(1, sh.getTen());
      ps.setBigDecimal(2, sh.getGia());
      ps.setInt(3, sh.getLoai());
      ps.setString(4, sh.getImg());
      ps.setNString(5, sh.getNoidung());
      ps.setInt(6, sh.getSoluong());
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
  
  public boolean update(Sach sh){
    try {
      Connection con = Connectdb.connect();
      String sql="update sach set ten = ?,gia = ?,loai = ?,img = ?,noidung = ?,"
          + "soluong =? where ma = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setNString(1, sh.getTen());
      ps.setBigDecimal(2, sh.getGia());
      ps.setInt(3, sh.getLoai());
      ps.setString(4, sh.getImg());
      ps.setNString(5, sh.getNoidung());
      ps.setInt(6, sh.getSoluong());
      ps.setInt(7, sh.getMa());
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
      String sql = "delete from sach where ma = "+ma;
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

