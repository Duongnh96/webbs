package cmc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cmc.dao.LoaiDao;
import cmc.dao.SachDao;
import cmc.model.Loai;
import cmc.model.Sach;

/**
 * Servlet implementation class adminController
 */

public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	    request.setCharacterEncoding("UTF-8");
    	    response.setCharacterEncoding("UTF-8");
    	    response.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	 if (request.getParameter("action") == null) {
                 RequestDispatcher rd = request.getRequestDispatcher("adminManager.jsp");
                 rd.forward(request, response);
                 ////////////////////////////////////////////////////////////////////////////////////////////// 
                 ///////////////////////// Bat dau phan dieu khien trang sachList.jsp
             }
        	 else if (request.getParameter("action").equals("sach")) {
                 if (request.getParameter("actionSH") == null) {
                     SachDao sd = new SachDao();
                     Vector<Sach> vt = sd.getSachList("select * from sach");
                     request.setAttribute("vtsach", vt);
                     RequestDispatcher rd = request.getRequestDispatcher("sachList.jsp");
                     rd.forward(request, response);
                 } else if (request.getParameter("actionSH").equals("xoa")) {
                     int ma = Integer.valueOf(request.getParameter("ma"));
                     SachDao sd = new SachDao();
                     sd.delete(ma);
                     response.sendRedirect("adminController?action=sach");
                 } else if (request.getParameter("actionSH").equals("them")) {
                     if (request.getParameter("btnInsert") == null) {
                         RequestDispatcher rd = request.getRequestDispatcher("sachAdd.jsp");
                         rd.forward(request, response);
                     } else {
                         Sach sh = new Sach();
                         String ten = request.getParameter("txtTen");
                         BigDecimal gia = BigDecimal.valueOf(Double.valueOf(request.getParameter("txtGia")));
                         int loai = Integer.parseInt(request.getParameter("rdoLoai"));
                         String img = request.getParameter("txtImg");
                         int soluong = Integer.parseInt(request.getParameter("txtSoLuong"));
                         String noidung = request.getParameter("txtNoiDung");
                         sh.setTen(ten);
                         sh.setGia(gia);
                         sh.setLoai(loai);
                         sh.setImg(img);
                         sh.setSoluong(soluong);
                         sh.setNoidung(noidung);
                         SachDao sd = new SachDao();
                         sd.insert(sh);
                         response.sendRedirect("adminController?action=sach");

                     }

                 } else if (request.getParameter("actionSH").equals("sua")) {
                     if (request.getParameter("btnUpdate") == null) {
                         int ma = Integer.valueOf(request.getParameter("ma"));
                         SachDao sd = new SachDao();
                         Sach sh = sd.getById(ma);
                         request.setAttribute("sach", sh);
                         RequestDispatcher rd = request.getRequestDispatcher("sachEdit.jsp");
                         rd.forward(request, response);
                     } else {
                         Sach sh = new Sach();
                         int ma = Integer.valueOf(request.getParameter("txtMa"));
                         String ten = request.getParameter("txtTen");
                         BigDecimal gia = BigDecimal.valueOf(Double.valueOf(request.getParameter("txtGia")));
                         int loai = Integer.parseInt(request.getParameter("rdoLoai"));
                         String img = request.getParameter("txtImg");
                         int soluong = Integer.parseInt(request.getParameter("txtSoLuong"));
                         String noidung = request.getParameter("txtNoiDung");
                         sh.setMa(ma);
                         sh.setTen(ten);
                         sh.setGia(gia);
                         sh.setLoai(loai);
                         sh.setImg(img);
                         sh.setSoluong(soluong);
                         sh.setNoidung(noidung);
                         SachDao sd = new SachDao();
                         sd.update(sh);
                         response.sendRedirect("adminController?action=sach");

                     }
                 }
             }////////////Ket thuc phan dieu khien trang sachList.jsp
             ///////////////////////////////////////////////////////////////////////////////////////
             ///////////////////////////////////////////////////////////////////////////////////////
             /////////////Bat dau dieu khien trang loaiList.jsp
             else if (request.getParameter("action").equals("loai")) {
                 if (request.getParameter("actionL") == null) {
                     LoaiDao ld = new LoaiDao();
                     Vector<Loai> vt = ld.getLoaiList("select * from loai");

                     request.setAttribute("vtloai", vt);
                     RequestDispatcher rd = request.getRequestDispatcher("loaiList.jsp");
                     rd.forward(request, response);
                 } else if (request.getParameter("actionL").equals("xoa")) {
                     int ma = Integer.valueOf(request.getParameter("ma"));
                     LoaiDao ld = new LoaiDao();
                     ld.delete(ma);
                     response.sendRedirect("adminController?action=loai");
                 } else if (request.getParameter("actionL").equals("them")) {
                     if (request.getParameter("btnInsert") == null) {
                         RequestDispatcher rd = request.getRequestDispatcher("loaiAdd.jsp");
                         rd.forward(request, response);
                     } else {
                         Loai l = new Loai();
                         String ten = request.getParameter("txtTen");
                         String mota = request.getParameter("txtMoTa");
                         l.setTen(ten);
                         l.setMota(mota);
                         LoaiDao ld = new LoaiDao();
                         ld.insert(l);
                         response.sendRedirect("adminController?action=loai");

                     }

                 } else if (request.getParameter("actionL").equals("sua")) {
                     if (request.getParameter("btnUpdate") == null) {
                         int ma = Integer.valueOf(request.getParameter("ma"));
                         LoaiDao ld = new LoaiDao();
                         Loai l = ld.getById(ma);
                         request.setAttribute("loai", l);
                         RequestDispatcher rd = request.getRequestDispatcher("loaiEdit.jsp");
                         rd.forward(request, response);
                     } else {
                         Loai l = new Loai();
                         LoaiDao ld = new LoaiDao();
                         int ma = Integer.valueOf(request.getParameter("txtMa"));
                         String ten = request.getParameter("txtTen");
                         String mota = request.getParameter("txtMoTa");
                         
                        
                         l.setMa(ma);
                         l.setTen(ten);
                         l.setMota(mota);
                       
                         ld.update(l);
                         response.sendRedirect("adminController?action=loai");

                     }
                 }
             } ///////////////////////////////////////////////////////////////////////////////////////
             /////////////Ket thuc phan dieu khien trang loaiList.jsp
             ////////////////////////////////////////////////////////////////////////////////////////
             /////////////Bat dau phan dieu khien trang hoadonList.jsp
             
        }
      }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
