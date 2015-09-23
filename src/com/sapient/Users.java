package com.sapient;

public class Users {

	private String name;
	private String email;
	private String address;
	private String password;
	private String u_id;
	private String contact_no;
	private Cart cart;
	
	public Users(String name, String email, String address, String u_id,
			Cart cart) {
		
		this.name = name;
		this.email = email;
		this.address = address;
		this.u_id = u_id;
		this.cart = cart;
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
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_ID) {
		u_id = u_ID;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	

	

}
