package cmc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cmc.dao.SachDao;
import cmc.model.Cart;
import cmc.model.Sach;

/**
 * Servlet implementation class cartController
 */
@WebServlet("/cartController")
public class cartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
        	 if(request.getParameter("action")!=null)
             {
                 if(request.getParameter("action").equals("addcart"))
                 {
                     int ma = Integer.valueOf(request.getParameter("ma"));
                     SachDao sd = new SachDao();
                     Sach sh = sd.getById(ma);
                     //lay session
                     HttpSession session = request.getSession();
                     Cart cart = Cart.instance();
                     if(session.getAttribute("cart")!=null)
                     {
                         cart = (Cart)session.getAttribute("cart");
                     }
                     //add san pham gio hang
                     cart.addSachtoCart(sh);
                     //luu session
                     session.setAttribute("cart", cart);
                     //nhay den trang hien thi cart
                     response.sendRedirect("cartController?action=showcart");
                 }
                 else if(request.getParameter("action").equals("showcart"))
                 {
                      RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
                      rd.forward(request, response);
                 }
                 else if(request.getParameter("action").equals("deletecartitem"))
                 {
                     int ma = Integer.valueOf(request.getParameter("ma"));
                     HttpSession session = request.getSession();
                     Cart cart = Cart.instance();
                     if(session.getAttribute("cart")!=null)
                     {
                         cart = (Cart)session.getAttribute("cart");
                     }
                     //delete san pham gio hang
                     cart.deleteCartSach(ma);
                     //luu session
                     session.setAttribute("cart", cart);
                     //nhay den trang hien thi cart
                     response.sendRedirect("cartController?action=showcart");
                 }
                 
                 
                 
                
             }
              /*else{
                     SPDAO dao = new SPDAO();
                     Vector<SPDTO> vt= dao.getAll();
                     request.setAttribute("vt", vt);
                     RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                     rd.forward(request, response);
                 }*/
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
