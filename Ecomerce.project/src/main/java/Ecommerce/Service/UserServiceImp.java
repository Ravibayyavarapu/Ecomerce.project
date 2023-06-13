package Ecommerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Ecommerce.Dao.UserDAO;
import Ecommerce.Model.UserDetails;


@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserDAO userdao;

	@Transactional
	public boolean register(UserDetails user) {
		
		return userdao.register(user);
	}

	@Override
	public boolean login(UserDetails user) {
		// TODO Auto-generated method stub
		return userdao.login(user);
	}

	
}
