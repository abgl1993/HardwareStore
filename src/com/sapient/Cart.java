package com.sapient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Cart implements Serializable{
	
	private List<Item> cartList;

	public Cart(){
		cartList = new ArrayList<Item>(); 
	}
	
	public void addToCart(Item item){
		 cartList.add(item);
	}
	
	public void removeFromCart(Item item){
		cartList.remove(item);
	}
	
	public void displayItem(){
		Iterator it;
		it=cartList.iterator();
		while(it.hasNext()){
			 String item =it.toString();
			 System.out.println(item);
		}
	}

	public List<Item> getCartList() {
		return cartList;
	}

	public void setCartList(List<Item> cartList) {
		this.cartList = cartList;
	}

	/*public int cartTotal(){
		int sum = 0;
		for(int i=0;i< cartList.size();i++)
			sum = sum + cartList.get(i).getCost();
		return sum;
	}*/
}
