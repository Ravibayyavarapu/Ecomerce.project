package Ecommerce.Dao;


import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Ecommerce.Model.UserDetails;

@Repository
public class UserDAOimp implements UserDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	
	public boolean register(UserDetails user) {
		
		boolean result=false;
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		int id=(int)session.save(user);
		transaction.commit();
		if(id!=0) {
			result=true;
		}
		return result;
	}


	@Override
	public boolean login(UserDetails user) {
		
		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		boolean result=false;
		String HQLQuery="select user_password from UserDetails where user_name=:user_name";
		Query query=session.createQuery(HQLQuery);
		
		query.setParameter("user_name",user.getUser_name());
		transaction.commit();
		System.out.println("pass"+query.getSingleResult());
		
//		if(user.getUser_password().contentEquals(pass)) {
//			result=true;
//		}
//		
		return result;
	}




}
