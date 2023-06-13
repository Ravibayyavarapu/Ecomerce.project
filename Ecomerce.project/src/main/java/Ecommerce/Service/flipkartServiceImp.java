package Ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ecommerce.Dao.flipkartDAO;
import Ecommerce.Model.Flipkart;

@Service
public class flipkartServiceImp implements flipkartService{

	@Autowired
	private flipkartDAO fd;


	public boolean add(Flipkart flipkart) {
		
		return fd.add(flipkart);
	}
	
	

}
