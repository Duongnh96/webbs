package cmc.controller;

import java.io.IOException;

import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmc.dao.SachDao;
import cmc.model.Sach;

/**
 * Servlet implementation class IndexController
 */

public class IndexController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public IndexController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see Servlet#init(ServletConfig)
   */
  public void init(ServletConfig config) throws ServletException {
    // TODO Auto-generated method stub
  }

  /**
   * @see Servlet#destroy()
   */
  public void destroy() {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    if (request.getParameter("numberpage") == null) {
      if (request.getParameter("theloai") == null) {
        SachDao sd = new SachDao();
        String sql = "select * from sach";
        Vector<Sach> al = (Vector<Sach>) sd.getSachList(sql);
        int n = al.size();
        request.setAttribute("loai", "all");
        request.setAttribute("sachlist", al);
        request.setAttribute("size", n);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
      } else {
        String sql;
        String theloai = request.getParameter("theloai");
        switch (theloai) {
        case "thieunhi":
          sql = "select * from sach where loai = 1 ";
          break;
        case "truyen":
          sql = "select * from sach where loai = 2 ";
          break;
        case "kinhdoanh":
          sql = "select * from sach where loai = 3 ";
          break;
        case "khoahoc":
          sql = "select * from sach where loai = 4 ";
          break;
        case "all":
          sql = "select * from sach";
          break;
        default:
          sql = "select * from sach where loai not in (1,2,3,4) ";
          break;

        }
        SachDao sd = new SachDao();
        Vector<Sach> al = (Vector<Sach>) sd.getSachList(sql);
        int n = al.size();
        request.setAttribute("loai", theloai);
        request.setAttribute("sachlist", al);
        request.setAttribute("size", n);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
      }

    } else {
      SachDao sd = new SachDao();
      String sql;
      String theloai = request.getParameter("theloai");
      switch (theloai) {
      case "thieunhi":
        sql = "select * from sach where loai = 1 ";
        break;
      case "truyen":
        sql = "select * from sach where loai = 2 ";
        break;
      case "kinhdoanh":
        sql = "select * from sach where loai = 3 ";
        break;
      case "khoahoc":
        sql = "select * from sach where loai = 4 ";
        break;
      case "all":
        sql = "select * from sach";
        break;
      default:
        sql = "select * from sach where loai not in (1,2,3,4) ";
        break;

      }
      Vector<Sach> al = (Vector<Sach>) sd.getSachList(sql);
      int n = al.size();
      int npage = Integer.valueOf(request.getParameter("numberpage"));

      Vector<Sach> sachList = new Vector<Sach>();
      for (int i = 0; i < 6; i++) {
        if ((npage - 1) * 6 + i < n)
          sachList.add(al.elementAt((npage - 1) * 6 + i));
      }
      request.setAttribute("loai", theloai);
      request.setAttribute("size", n);
      request.setAttribute("sachlist", sachList);
      RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
      rd.forward(request, response);
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub

  }

}
