package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class ListController
 */
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
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
		try(PrintWriter out=response.getWriter()){
			int n =Integer.parseInt(request.getParameter("page"));
		List<Product>ls=new ListProductDAO().show(n); 
		request.setAttribute("products", ls);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		}catch (Exception ex) {
			Logger.getLogger(ListController.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
}
