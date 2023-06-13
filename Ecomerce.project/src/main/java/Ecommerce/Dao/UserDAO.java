package Ecommerce.Dao;

import Ecommerce.Model.UserDetails;

public interface UserDAO {
	
	public boolean register(UserDetails user) ;
	public boolean login(UserDetails user);
	
}
