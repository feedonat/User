package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AccountService;

/**
 * Servlet implementation class editUser
 */
@WebServlet("/editPage")
public class editPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempUser = request.getParameter("username");
		AccountService accService = new AccountService();
		request.setAttribute("user", accService.getAccountById(tempUser));
		RequestDispatcher rd = request.getRequestDispatcher("editUser.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String username = request.getParameter("username");                 
         String password = request.getParameter("password");
         String fullname = request.getParameter("fullname");
         String role = request.getParameter("role");
         String address = request.getParameter("address");
         String email = request.getParameter("email");
         AccountService accService = new AccountService();
         accService.edit(password, role, fullname, address, email,username);         
         request.setAttribute("userlist", accService.getAllUsers());
         RequestDispatcher rd = request.getRequestDispatcher("/listAll.jsp");
         rd.forward(request, response);
		
	}

}
