package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import dao.OrderDAO;
import model.Cart;
import model.Orders;

/**
 * Servlet implementation class PayController
 */
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException  {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			HttpSession session =request.getSession(true);
			if(session.getAttribute("cart")==null) {

			}
			OrderDAO dao = new OrderDAO();
			Cart c= (Cart) session.getAttribute("cart");
			String username= request.getParameter("name");
			String discount=request.getParameter("discount");
			String address=request.getParameter("address");
			Date date=new Date();
			Orders d=new Orders(username,2,discount,address,"",date);
			dao.insertOrder(d,c);
			response.sendRedirect("recive.jsp");
			
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			response.getWriter().println(ex);
			ex.printStackTrace();		}
	}
}
