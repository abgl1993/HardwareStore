package com.sapient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class DataAccessObject {

	private SessionFactory factory;

	Logger log= null;
	
	public DataAccessObject() {
		// TODO Auto-generated constructor stub
		BasicConfigurator.configure();
		factory = new Configuration().configure().buildSessionFactory();
	}

	public boolean validation(String emailid, String password) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			//tx = session.beginTransaction();
			List users = session.createQuery("FROM Users").list();
			if(users==null)
				return false;
			for (Iterator iterator = users.iterator(); iterator.hasNext();) {
				Users user = (Users) iterator.next();
				if (emailid == user.getEmail()
						&& password == user.getPassword()) {
					return true;
				}
				//tx.commit();
			}

		} catch (HibernateException e) {
			//if (tx != null)
			//	tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		log.info("Invalid Id and password");
		return false;
	}

	public Users getUserDetails(String email) {

		Session session = factory.openSession();
		Transaction tx = null;
		Logger log = null;
		try {
			//tx = session.beginTransaction();
			List users = session.createQuery("FROM Users").list();
			for (Iterator iterator = users.iterator(); iterator.hasNext();) {
				Users user = (Users) iterator.next();
				if (email.equals(user.getEmail())) {
					return user;
				}
			}
			//tx.commit();
		} catch (HibernateException e) {
			//if (tx != null)
			//	tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		//log.info("User does not exists!!!!");
		return null;
	}


public int addUser(int uid,String name,String email,String password,String contactNo,String address)
{
	Session session = factory.openSession();
    Transaction tx = null;
    Integer uID = null;
    try{
       tx = session.beginTransaction();
       Cart cart = new Cart();
       Users user = new Users(name, email, address,uid,cart);
       user.setPassword(password);
       user.setContactNo(contactNo);
       session.save(user); 
       tx.commit();
    }catch (HibernateException e) {
       if (tx!=null) tx.rollback();
       e.printStackTrace(); 
       return 0;
    }finally {
       session.close(); 
    }
	return 1;
	}

public List<Item> getProductList(){
	List<Item> items = new ArrayList<Item>();
	
	factory = new Configuration().configure().buildSessionFactory();

	Session session = factory.openSession();
	Transaction tx = null;

	try {
		//tx = session.beginTransaction();
		List item = session.createQuery("FROM Item").list();
		for (Iterator iterator = item.iterator(); iterator.hasNext();) {
			items.add((Item) iterator.next());
		//tx.commit();
		}

	} catch (HibernateException e) {
		//if (tx != null)
		//	tx.rollback();
		e.printStackTrace();
	} finally {
		session.close();
	}
	
	return items;
}

public Item getItem(String itemName){ 
	
	Item item=null;
	Session session = factory.openSession();
    Transaction tx = null;
    try{
       tx = session.beginTransaction();
       Criteria cr = session.createCriteria(Item.class);
       // Add restriction.
       cr.add(Restrictions.gt("modelName",itemName));
       List items = cr.list();

       for (Iterator iterator = items.iterator(); iterator.hasNext();){
          Item itemSearch = (Item) iterator.next(); 
          return itemSearch;
       }
       tx.commit();
    }catch (HibernateException e) {
       if (tx!=null) tx.rollback();
       e.printStackTrace(); 
    }finally {
       session.close(); 
    }
	
	log.info("Item not found");
	return null;
}




}
/*
 * static Logger log; Context ctx = null; DataSource ds = null; Connection con =
 * null; PreparedStatement ps = null;
 * 
 * public DataAccessObject() { log =
 * Logger.getLogger(DataAccessObject.class.getName());
 * BasicConfigurator.configure(); try { ctx = new InitialContext(); ds =
 * (DataSource)ctx.lookup("java:comp/env/jdbc/ProjectDB"); con =
 * ds.getConnection(); } catch (NamingException e) { //e.printStackTrace();
 * log.info("Naming Exception!"); } catch (SQLException e) {
 * //e.printStackTrace(); log.info("SQL Connection Error!"); } } public boolean
 * validation(String emailid, String password){
 * 
 * try { ps = con.prepareStatement(
 * "SELECT NAME FROM USER_DETAILS WHERE EMAIL_ID=? AND PASSWORD=?");
 * ps.setString(1, emailid); ps.setString(2, password);
 * 
 * ResultSet rs = ps.executeQuery();
 * 
 * if(rs.next()) { //fname = rs.getString(1); //lname = rs.getString(2); return
 * true; }
 * 
 * return false; }catch (SQLException e) { //e.printStackTrace();
 * log.info("SQL Connection Error!"); } return false; }
 * 
 * public int addUser(int uid,String name,String email,String password,String
 * contactNo,String address) {
 * 
 * try { ps =
 * con.prepareStatement("INSERT INTO USER_DETAILS VALUES (?,?,?,?,?,?,?,?)" );
 * 
 * ps.setString(1, name); ps.setString(2, email); ps.setString(3, password);
 * ps.setString(4, contactNo); ps.setString(5, address); ps.setString(6,null);
 * ps.setInt(7,(int) Math.random()); ps.setInt(8, 1); ps.executeUpdate(); }
 * catch (SQLException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); return 0; } return 1;
 * 
 * }
 * 
 * public List<Item> getProductList(){ List<Item> items = new ArrayList<Item>();
 * 
 * try { ps = con.prepareStatement("SELECT * FROM PRODUCT_DETAILS"); ResultSet
 * rs = ps.executeQuery();
 * 
 * while(rs.next()) {
 * 
 * Item item = new Item(rs.getString(1), rs.getString(2), rs.getString(3),
 * rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7),
 * rs.getString(8));
 * 
 * 
 * items.add(item); }
 * 
 * }catch (SQLException e) { //e.printStackTrace();
 * log.info("SQL Connection Error!"); } return items; } public Item
 * getItem(String itemName){ Item item=null; try {
 * ps=con.prepareStatement("SELECT * FROM PRODUCT_DETAILS WHERE MODEL_NAME = ?"
 * ); ps.setString(1,itemName); ResultSet rs = ps.executeQuery(); if(rs.next())
 * { item = new Item(rs.getString(1), rs.getString(2), rs.getString(3),
 * rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7),
 * rs.getString(8)); } } catch (SQLException e) { // TODO Auto-generated catch
 * block e.printStackTrace(); }
 * 
 * return item; }
 * 
 * public Users getUserDetails(String email, Cart cart){ Users user=null; try {
 * ps=con.prepareStatement("SELECT * FROM USER_DETAILS WHERE EMAIL_ID = ?");
 * ps.setString(1,email); ResultSet rs = ps.executeQuery(); if(rs.next()) { user
 * = new Users(rs.getString(1), rs.getString(2), rs.getString(4),
 * rs.getString(7), cart); } } catch (SQLException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); } return user; }
 * 
 * public void dataAccessObjectClose(){ ctx=null; ds = null; con= null; ps =
 * null; }
 */

