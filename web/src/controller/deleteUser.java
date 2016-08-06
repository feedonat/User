package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AccountService;

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempUser = request.getParameter("username");
		AccountService accService = new AccountService();
		request.setAttribute("user", accService.getAccountById(tempUser));
		RequestDispatcher rd = request.getRequestDispatcher("deleteUser.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
        AccountService accService = new AccountService();      
        accService.delete(username);         
        request.setAttribute("userlist", accService.getAllUsers());
        RequestDispatcher rd = request.getRequestDispatcher("/listAll.jsp");
        rd.forward(request, response);
	}

}
