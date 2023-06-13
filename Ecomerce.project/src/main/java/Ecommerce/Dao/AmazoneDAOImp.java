package Ecommerce.Dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Ecommerce.Model.Amazone;

@Repository
public class AmazoneDAOImp implements AmazoneDAO {

	
	@Autowired
	private SessionFactory sessionfactory;
	
	
	
	public boolean add(Amazone amazone) {
	
		boolean result=false;
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		int i=(int)session.save(amazone);
		transaction.commit();
		
		if(i!=0) {
			
			result =true;
		}
		return result;
		
		
	}

}
