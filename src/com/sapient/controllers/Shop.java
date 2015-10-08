package com.sapient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Shop {
	@RequestMapping(value="/shop",method=RequestMethod.GET)
	public String shopPage(){
		return "shop";
	}

}
