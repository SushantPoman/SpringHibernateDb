package com.example.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.dao.UserDetails;

@Repository
public class UserDao {

	@Autowired
	SessionFactory sFactory;

	public String saveUser(UserDetails userDetails) {
		Session session = sFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(userDetails);
		transaction.commit();
		session.close();
		return "User saved";		
	}
	
	public List<UserDetails> getAllUsers() {
		Session session = sFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<UserDetails> uList =session.createQuery("from UserDetails").list();
		return uList;
	}
	

	public UserDetails getUser(Integer uid) {
		Session session = sFactory.openSession();
		Transaction transaction = session.beginTransaction();
		UserDetails userDetails = session.load(UserDetails.class, uid);
		return userDetails;
		
	}
	

	public String deleteUser(Integer uid) {
		Session session = sFactory.openSession();
		Transaction transaction = session.beginTransaction();
		UserDetails userDetails = session.load(UserDetails.class, uid);
		session.delete(userDetails);
		transaction.commit();
		session.close();
		return "User deleted";
	}
}
