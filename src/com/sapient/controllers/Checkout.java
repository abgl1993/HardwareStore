package com.sapient.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.Item;
import com.sapient.Users;

@Controller
public class Checkout {
	
	@RequestMapping(value="/checkout" ,method= RequestMethod.GET)
	public String cart(ModelMap model, HttpServletRequest request){
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		List<Item> cartList = user.getCart().getCartList();
		model.addAttribute("cartList",cartList);
		int sum = 0;
		for(int i=0;i< cartList.size();i++)
			sum = sum + cartList.get(i).getCost();
		model.addAttribute("total",sum);
		if(sum<500){
			model.addAttribute("shipping",100);
		}else{
			model.addAttribute("shipping",0);
		}
		return "checkout";
	}

}
