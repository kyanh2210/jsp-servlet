package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class InformationProductController
 */
public class InformationProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationProductController() {
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
			String id=request.getParameter("id");
			Product a= new ListProductDAO().getProduct(id);
			request.setAttribute("product",a);
			RequestDispatcher rd =request.getRequestDispatcher("infoProduct.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			response.getWriter().println(ex);
		}
	}
}