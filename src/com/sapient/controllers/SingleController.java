package com.sapient.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.Item;

@Controller
@RequestMapping(value="/product")
public class SingleController {
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView viewPage(HttpServletRequest request, HttpServletResponse response){
		String name =request.getParameter("name");
		Item item = new Item();
		if(name.isEmpty()){
			return new ModelAndView("shop");
		}else if(item.getProductList().indexOf(name.trim())>=0){
			return new ModelAndView("single-product","command",item.getItem(name));	
		}
		return new ModelAndView("shop");
	}
}