package com.sapient.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.Item;

@Controller
@RequestMapping(value="/product")
public class SingleController {
	
	@RequestMapping(method= RequestMethod.GET)
	public ModelAndView viewPage(ModelMap model,HttpServletRequest request, HttpServletResponse response){
		String name =request.getParameter("name");
		Item item = new Item();
		
		if(name==null || name.equals("")){
			return new ModelAndView("shop");
		}else if(item.getProductListNames().indexOf(name)>=0){
			model.addAttribute("single",item.getItem(name));
			return new ModelAndView("single-product","command",item.getItem(name));	
			
		}
		return new ModelAndView("index");
	}
}