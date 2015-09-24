package com.sapient.processor;
import com.sapient.Cart;
import  com.sapient.Item;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sapeint.model.ItemValidator;
import com.sapeint.model.User;

/**
 * Servlet implementation class Processor
 */
public class Processor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Processor() {
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
		String item=request.getParameter("item");
	
		
		System.out.println(item);
		
		ItemValidator item_validator=new ItemValidator();
		Item valiadtedItem=item_validator.getItem(item);
		HttpSession session=request.getSession();
		Cart cart=(Cart)session.getAttribute("ShoppingCart");
			if(cart==null){	
				cart=new Cart();
				session.setAttribute("ShoppingCart", cart);
			}else{
				if(valiadtedItem.getPRO_QUANTITY()>1){
				cart.addToCart(valiadtedItem);
			}
		}
		
			request.getRequestDispatcher("cart.html").forward(request, response);
		
	}	

}
