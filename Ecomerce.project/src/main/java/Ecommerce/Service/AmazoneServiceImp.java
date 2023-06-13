package Ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ecommerce.Dao.AmazoneDAO;
import Ecommerce.Model.Amazone;

@Service
public class AmazoneServiceImp implements AmazoneService  {
	
	@Autowired
	private AmazoneDAO amazonedao;

	
	public boolean add(Amazone amazone) {

		return amazonedao.add(amazone);
	}

}
