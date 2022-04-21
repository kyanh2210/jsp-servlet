package controller;

import java.io.IOException;

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
 * Servlet implementation class SearchController2
 */
public class SearchController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException  {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String text = request.getParameter("s");
			request.setAttribute("search", text);
			int i =1;
			if(request.getParameter("page")!=null) {
				i=Integer.parseInt(request.getParameter("page"));
			}
			request.setAttribute("result", new ListProductDAO().search(text,i));			
			request.setAttribute("total", new ListProductDAO().total(text,i));
			RequestDispatcher rs=request.getRequestDispatcher("search.jsp");
			rs.forward(request, response);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			response.getWriter().println(ex);
		}
	}
}
