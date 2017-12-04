package cmc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmc.dao.Connectdb;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("LogOut")!=null){
	    HttpSession session = request.getSession();
	    session.setAttribute("email", null);
	    RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
	    rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  String email = request.getParameter("txtEmail");
	  String pass = request.getParameter("txtPass");
	  RequestDispatcher rDispatcher;
	  try {
	    String sql = "select * from [admin] where email ='"+email+"' and pass = '"+pass+"'";
      Connection con = Connectdb.connect();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      if(rs.next()){
        HttpSession session = request.getSession();
        session.setAttribute("email",email);
        response.sendRedirect("adminManager.jsp");
      } else {
        request.setAttribute("login", "fail");
        rDispatcher = request.getRequestDispatcher("admin.jsp");
        rDispatcher.forward(request, response);
      }
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
	}

}
