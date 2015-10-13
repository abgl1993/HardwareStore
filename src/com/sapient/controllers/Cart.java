package com.sapient.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.Item;
import com.sapient.Users;

@Controller
public class Cart {

	@RequestMapping(value="/AddCart" ,method= RequestMethod.GET)
	public void addCart(@RequestParam String item, HttpServletRequest request){
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		Item itemObj = new Item();
		itemObj = itemObj.getItem(item);
		users.getCart().addToCart(itemObj);
	}
	
	@RequestMapping(value="/RemoveCart" ,method= RequestMethod.GET)
	public ModelMap removeCart(@RequestParam String item, ModelMap model, HttpServletRequest request){
		HttpSession session = request.getSession();
		Users users = (Users) session.getAttribute("user");
		com.sapient.Cart cart = users.getCart();
		Item itemObj = new Item();
		itemObj = itemObj.getItem(item);
		cart.removeFromCart(itemObj);
		users.setCart(cart);
		session.setAttribute("user", users);
		return model;
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
