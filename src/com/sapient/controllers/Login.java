package com.sapient.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.Users;

@Controller
@RequestMapping(value="/")
public class Login {
	
	@RequestMapping(method= RequestMethod.GET)
	public String displayForm(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		if(session.getAttribute("name")==null)
			return "Login";
		else
			return "index";
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		String email=request.getParameter("emailid");
		String password=request.getParameter("pass");
		HttpSession session = request.getSession();
		Users users = new Users();
		boolean status=users.validateLogin(email, password);
		if(status){
			users = users.getUser(email);
			session.setAttribute("name", users.getName());
			session.setAttribute("user", users);
			session.setMaxInactiveInterval(7*24*60*60);		// Session lifetime One Week
			return new ModelAndView("index");
		}
		else{
			return new ModelAndView("Login");
		}
	}
	
	// Get Method to handle direct url access
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String loginGet(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		if(session.getAttribute("name")==null)
			return "Login";
		else
			return "index";
	}
	
	// Logout Link
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		user.saveState();
		session.invalidate();
		return "Login";
	}
	
}
