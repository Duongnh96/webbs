package cmc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectdb {
  static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  static String ConnectionURL = "jdbc:sqlserver://localhost:1433"
      + ";instance=SQLEXPRESS;databaseName=qlbh;";
  static String userName = "bvquyet";
  static String passWord = "quyet013859";

  /**
   * Method return connection database
   * 
   * @throws ClassNotFoundException
   * 
   * @throws SQLException.
   * 
   */
  
  public static Connection connect() throws ClassNotFoundException,
      SQLException {
    // load driver
    Class.forName(Driver);
    // get connection
    Connection cn = DriverManager.getConnection(ConnectionURL, userName,
        passWord);
    return cn;
  }

}
