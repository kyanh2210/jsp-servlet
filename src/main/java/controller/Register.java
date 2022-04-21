package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import dao.ListProductDAO;
import dao.RegisterDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws  Exception  {
		response.setContentType("text/html;charset=UTF-8");

		String uname=request.getParameter("username");
		String name =request.getParameter("name");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		Account acc= new Account(uname,password,2,name,address,phone,1);
		RegisterDAO add= new RegisterDAO();
		add.InsertUser(acc);
	}
}
