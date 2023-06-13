package Ecommerce.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Ecommerce.Model.Flipkart;

@Repository
public class flipkartDAOImp implements flipkartDAO {
 
	@Autowired
	private SessionFactory sf;

	
	public boolean add(Flipkart flipkart) {
		
		boolean result=false;
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		int id=(int)session.save(flipkart);
		transaction.commit();
		if(id!=0) {
			
			result=true;
		}else {
			result=false;
		}
		return result;
	}
	
	
}
