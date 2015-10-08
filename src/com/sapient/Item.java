package com.sapient;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable{
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
	
	public List getProductList(){
		DataAccessObject dao= new DataAccessObject();
		return dao.getProductList();
	}
	
	public Item getItem(String name){
		DataAccessObject dao= new DataAccessObject();
		return dao.getItem(name);
	}
}
