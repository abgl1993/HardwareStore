package com.sapient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Cart {
private java.util.List<Item> cartList=new ArrayList<Item>();
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
		 
}


}

}
