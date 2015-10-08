package com.sapient.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.Users;

@Controller
@RequestMapping(value="/register")
public class Register {

	@RequestMapping(method= RequestMethod.POST)
	public String register(HttpServletRequest request, HttpServletResponse response){
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
			return "index";
		}else{
			return "Login";
		}
	}
}
