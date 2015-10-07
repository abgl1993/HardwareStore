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
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
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
		String name=request.getParameter("name");
	    String email=request.getParameter("email");
	    String password=request.getParameter("pass");
	    String contactNo=request.getParameter("contactNo");
	    String address=request.getParameter("address");
		Users users=new Users();
		int success = users.addNewUser(name,email,password,contactNo,address);
		if(success==1){
			HttpSession session = request.getSession();
			users = users.getUser(email);
			//request.setAttribute("userBean", user);
			session.setAttribute("name", users.getName());
			session.setAttribute("user", users);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/Login.html").forward(request, response);
		}
}

}
