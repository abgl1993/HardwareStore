package com.sapient;

import java.util.LinkedList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Cart {
private List cartList;
public void addToCart(Item item){
	cartList=new LinkedList();
}

}