package com.sapient.processor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapient.Cart;
import com.sapient.DataAccessObject;
import com.sapient.Users;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		String email=request.getParameter("emailid");
		String password=request.getParameter("pass");
		HttpSession session = request.getSession();
		Users users = new Users();
		boolean status=users.validateLogin(email, password);
		if(status){
			users = users.getUser(email);
			session.setAttribute("name", users.getName());
			session.setAttribute("user", users);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else{
			//PrintWriter out=new PrintWriter(System.out,true);
			//out.println("Reached to else loop");
			request.getRequestDispatcher("/Login.html").forward(request, response);
		}
		
	}

}
