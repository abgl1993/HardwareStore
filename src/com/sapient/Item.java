package com.sapient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pId;
	private String brandName;
	private String productType;
	private String modelName;
	private String utility;
	private int productQuantity;
	private int cost;
	private String description;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(int uid, String brandName, String productType, String modelName, String utility, int proQuantity, int cost, String description){

		this.pId = uid;
		this.brandName = brandName;
		this.productType = productType;
		this.modelName = modelName;
		this.utility = utility;
		this.productQuantity = proQuantity;
		this.cost = cost;
		this.description = description;
	}
	
	
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getBrandName() {
		return brandName;
	}



	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}



	public String getProductType() {
		return productType;
	}



	public void setProductType(String productType) {
		this.productType = productType;
	}



	public String getModelName() {
		return modelName;
	}



	public void setModelName(String modelName) {
		this.modelName = modelName;
	}



	public String getUtility() {
		return utility;
	}



	public void setUtility(String utility) {
		this.utility = utility;
	}



	public int getProductQuantity() {
		return productQuantity;
	}



	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}



	public int getCost() {
		return cost;
	}



	public void setCost(int cost) {
		this.cost = cost;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	public String getNameId(){
		if(pId<10)
			return "0"+pId;
		else
			return ""+pId;
	}
	
	public List<String> getProductListNames(){
		DataAccessObject dao= new DataAccessObject();
		List<Item> itemList=dao.getProductList();
		List<String> items = new ArrayList<String>();
		for(int i = 0 ; i < itemList.size(); i++)
			items.add(itemList.get(i).getModelName());
		return items;
	}
	
	public List<Item> getProductList(){
		DataAccessObject dao= new DataAccessObject();
		List<Item> itemList=dao.getProductList();
		return itemList;
	}
	
	public Item getItem(String name){
		DataAccessObject dao= new DataAccessObject();
		return dao.getItem(name);
	}
	
	// ----------------------------------- OVER RIDDEN TO REMOVE ITEM FROM CART
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return pId;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return ((Item)obj).pId==this.pId;
	}
}
