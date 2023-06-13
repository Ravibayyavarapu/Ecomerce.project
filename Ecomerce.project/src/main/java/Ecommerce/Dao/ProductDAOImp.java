package Ecommerce.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Ecommerce.Model.Product;

@Repository
public class ProductDAOImp implements ProductDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	boolean result=false;
	public boolean add(Product product) {
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
	    int i=(int)session.save(product);
	    transaction.commit();
	if(i!=0) {
		
		result=true;
	}
		return result;
	}

	@Override
	public List<Product> list() {
		
		
		Session session=sessionfactory.openSession();
		List<Product> list=session.createQuery("from Product").list();
		return list;
	}

	@Override
	public boolean update(Product update) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product delete) {
		
		boolean result=false;
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		try {
			//Product pro=(Product)session.merge(delete);
			session.remove(session.merge(delete));
			transaction.commit();
			result=true;
		} catch (Exception e) {
			System.out.println(e);
			result=false;
		}
		
		
		return result;
	}

}
