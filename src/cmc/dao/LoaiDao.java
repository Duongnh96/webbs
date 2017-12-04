package cmc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cmc.model.Loai;

public class LoaiDao {
  public Vector<Loai> getLoaiList(String sql) {
    Vector<Loai> vt = new Vector<Loai>();
    Connection con = null;
    try {
      con = Connectdb.connect();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      while (rs.next()) {
        Loai l = new Loai();
        l.setMa(rs.getInt(1));
        l.setTen(rs.getString(2));
        l.setMota(rs.getString(3));
        vt.add(l);
      }
      con.close();

    } catch (ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return vt;

  }
  public Loai getById(int ma) {
	  Loai l = new Loai();
	  try {
		Connection con = Connectdb.connect();
		String sql = "select * from loai where ma ="+ma;
		Statement st =con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			l.setMa(ma);
			l.setTen(rs.getNString("ten"));
			l.setMota(rs.getNString("mota"));
		}
		con.close();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l;
	  
  }

  public boolean insert(Loai l) {
    try {
      String sql = "insert into loai values(?,?)";
      Connection con = Connectdb.connect();
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, l.getTen());
      ps.setString(2, l.getMota());

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

  public boolean update(Loai l) {
    try {
      Connection con = Connectdb.connect();
      String sql = "update loai set ten = ?,mota = ? where ma = ?";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, l.getTen());
      ps.setString(2, l.getMota());
      ps.setInt(3, l.getMa());
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

  public boolean delete(int ma) {
    try {
      Connection con = Connectdb.connect();
      Statement st = con.createStatement();
      String sql = "delete from loai where ma = " + ma;
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
