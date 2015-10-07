package com.sapient;

import java.io.Serializable;

public class Item implements Serializable{
	private String uId;
	private String brandName;
	private String productType;
	private String modelName;
	private String utility;
	private int productQuantity;
	private int cost;
	private String description;
	
	
	
	public Item(String uid, String brandName, String productType, String modelName, String utility, int proQuantity, int cost, String description){

		this.uId = uid;
		this.brandName = brandName;
		this.productType = productType;
		this.modelName = modelName;
		this.utility = utility;
		this.productQuantity = proQuantity;
		this.cost = cost;
		this.description = description;
	}
	
	public String getU_ID() {
		return uId;
	}
	public void setU_ID(String u_ID) {
		uId = u_ID;
	}
	public String getBRAND_NAME() {
		return brandName;
	}
	public void setBRAND_NAME(String bRAND_NAME) {
		brandName = bRAND_NAME;
	}
	public String getPRODUCT_TYPE() {
		return productType;
	}
	public void setPRODUCT_TYPE(String pRODUCT_TYPE) {
		productType = pRODUCT_TYPE;
	}
	public String getMODEL_NAME() {
		return modelName;
	}
	public void setMODEL_NAME(String mODEL_NAME) {
		modelName = mODEL_NAME;
	}
	public String getUTILITY() {
		return utility;
	}
	public void setUTILITY(String uTILITY) {
		utility = uTILITY;
	}

	
	
	public int getPRO_QUANTITY() {
		return productQuantity;
	}


	public void setPRO_QUANTITY(int pRO_QUANTITY) {
		productQuantity = pRO_QUANTITY;
	}

	public int getCOST() {
		return cost;
	}

	public void setCOST(int cOST) {
		cost = cOST;
	}

	public String getDESCRIPTION() {
		return description;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		description = dESCRIPTION;
	}
	
	public String getNameId(){
		if(Integer.parseInt(uId)<10)
			return "0"+Integer.parseInt(uId);
		else
			return ""+Integer.parseInt(uId);
	}
}
