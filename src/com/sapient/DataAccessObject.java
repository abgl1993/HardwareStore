package com.sapient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;

public class DataAccessObject {

	static Logger log;
	Context ctx = null;
	DataSource ds = null;
	Connection con = null;
	PreparedStatement ps = null;
	
	public DataAccessObject() {
		log = Logger.getLogger(DataAccessObject.class.getName());
		BasicConfigurator.configure();
        try {
			ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProjectDB");
			con = ds.getConnection();
		} catch (NamingException e) {
			//e.printStackTrace();
			log.info("Naming Exception!");
		} catch (SQLException e) {
			//e.printStackTrace();
			log.info("SQL Connection Error!");
		}
	}
	public boolean validation(String username, String password){
		
		try {
			ps = con.prepareStatement("SELECT FIRST_NAME, LAST_NAME FROM USERS WHERE USERID=? AND PASSWORD=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//fname = rs.getString(1);
				//lname = rs.getString(2);
				return true;
			}
			
			return false;
		}catch (SQLException e) {
			//e.printStackTrace();
			log.info("SQL Connection Error!");
		}
		return false;
	}
	
	public List<Object> getProductList(){
		
		List<Item> items = new ArrayList<Item>();
		
		try {
			ps = con.prepareStatement("SELECT * FROM PRODUCT_DETAILS");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Item item = new Item(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
				items.add(item);
				return null;
			}
			
		}catch (SQLException e) {
			//e.printStackTrace();
			log.info("SQL Connection Error!");
		}
		return null;
	}
	
	public void dataAccessObjectClose(){
		ctx=null;
		ds = null;
		con= null;
		ps = null;
	}
}
