package com.sapient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Cart {
private java.util.List<Item> cartList=new ArrayList<Item>();;
public void addToCart(Item item){
<<<<<<< HEAD
	
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
		 
	}
=======
	cartList=(List) new LinkedList();
>>>>>>> ae2bfc0d6d12fa94c60e9964bc28525510f2bfa3
}

}
