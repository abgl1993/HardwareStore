package com.sapient;

import java.io.Serializable;

public class Users implements Serializable{

	private String name;
	private String email;
	private String address;
	private String password;
	private int uId;
	private String contactNo;
	private Cart cart;
	
	public Users(String name, String email, String address, int u_id,
			Cart cart) {
		
		this.name = name;
		this.email = email;
		this.address = address;
		this.uId = u_id;
		this.cart = cart;
	}
	
	public Users() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Users getUser(String email){
		DataAccessObject dao = new DataAccessObject();
		Cart cart = new Cart();
		return dao.getUserDetails(email);
	}
	
	public boolean validateLogin(String email,String password){
		DataAccessObject dao = new DataAccessObject();
		if(dao.validation(email, password))
			return true;
		else
			return false;
	}
	
	public int addNewUser(String name,String email,String password,String contactNo,String address)
	{
		DataAccessObject dao = new DataAccessObject();
		int uid = (int)Math.random();
		int i=dao.addUser(uid,name,email,password,contactNo,address);
		return i;
		//System.out.print(name);
	}
	
	public boolean saveState(Users user){
		DataAccessObject dao = new DataAccessObject();
		if(dao.cartState(user, cart)==null){
			return false;
		}
		return true;
	}
}
