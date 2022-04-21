package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import bean.adminpassword;
import dao.RegisterDAO;
import dao.adminpass;
import model.historycart;

/**
 * Servlet implementation class login
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init (ServletConfig)
	 */
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// tiengviet
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			request.getSession(true).invalidate();
			String regexMail="^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex="[a-zA-Z0-9_!@#$%^&*]+";
			String userID=request.getParameter("username");
			String password=request.getParameter("password");
			String checker =request.getParameter("remember");
			
			Cookie name =new Cookie("user", userID);
			Cookie pass=new Cookie("pass", password);
			response.addCookie(name);
			response.addCookie(pass);
			int check=0;
			if(checker=="1") {
			check= Integer.parseInt(checker);
			name.setMaxAge(3600);
			pass.setMaxAge(3600);
			}
			Account acc= new Account();
			acc.setName(userID);acc.setPwd(password);acc.setCheck(check);
			HttpSession session=request.getSession();
			if(password!=null&&userID!=null) {
			if(!password.matches(regex)||!userID.matches(regexMail)) {
				session.setAttribute("error","invalidsyntax");
				response.sendRedirect("login.jsp");
			}
			/**?name=somename&password=somepassword
			String uid= getServletContext().getInitParameter("username");
			String pwd=getServletContext().getInitParameter("password");
			
			// check ten vs pass dung trong xml ko**/
			List<Account> a=  new adminpass().listad();
			boolean checkpass=false;
			int aaa=0;
			for(Account x:a) {
				aaa=x.getRole();
				String uid=x.getUsr();
				String pwd=x.getPwd();
				if(password.equals(pwd)&&userID.equalsIgnoreCase(uid)) {
					checkpass=true;
					break;
				}
			}
			if(userID!=null && checkpass&&aaa!=0) {
				if(aaa==1) {
					response.sendRedirect("admin/index.jsp");
				
				}else {
					RegisterDAO his= new RegisterDAO();
					List<historycart> pdht = his.searchUser(userID);
					if(pdht==null) {
						response.sendRedirect("homePage.jsp");
					}
					session.setAttribute("history", pdht);
					response.sendRedirect("History.jsp");
				}
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				response.getWriter().println("<font color='red'>Username or password is invalid</font>");
				rd.include(request, response);
			}
		}else {
			name.setMaxAge(-1);
			pass.setMaxAge(-1);
			response.sendRedirect("home.jsp");
		}
			
		}catch (Exception ex) {
			response.getWriter().println(ex);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
