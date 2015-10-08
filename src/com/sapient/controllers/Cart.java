package com.sapient.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.DataAccessObject;
import com.sapient.Item;
import com.sapient.Users;

@Controller
public class Cart {

	@RequestMapping(value="/AddCart" ,method= RequestMethod.POST)
	public void addCart(HttpServletRequest request, HttpServletResponse response){
		String name = request.getParameter("item");
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		Item item = new Item();
		item = item.getItem(name);
		users.getCart().addToCart(item);
	}
	
	@RequestMapping(value="/cart" ,method= RequestMethod.GET)
	public String cart(@ModelAttribute("cart") Cart cart, ModelMap model, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		List<Item> cartList = user.getCart().getCartList();
		model.addAttribute("cartList",cartList);
		int sum = 0;
		for(int i=0;i< cartList.size();i++)
			sum = sum + cartList.get(i).getCost();
		model.addAttribute("total",sum);
		return "cart";
	}
}
