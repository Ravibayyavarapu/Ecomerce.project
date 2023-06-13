package Ecommerce.Service;

import Ecommerce.Model.UserDetails;

public interface UserService {
	
	public boolean register(UserDetails user);
	public boolean login(UserDetails user);
	
}
