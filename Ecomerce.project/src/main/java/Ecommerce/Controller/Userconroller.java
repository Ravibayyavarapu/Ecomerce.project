package Ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecommerce.Model.UserDetails;
import Ecommerce.Service.UserService;
import Ecommerce.utils.Response;

@RestController
public class Userconroller {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping ("/healthcheck")
	public String healthcheck() {
		
		System.out.println("===connected===");
		
		return "Connected Successfully";
	}
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody  UserDetails User) {
		System.out.println("----------Registration-form-----------");
		System.out.println(User.getUser_mail());
		
		boolean result=userservice.register(User);
		
		Response response=null;
		
		
		if(result == true) {
			
			response=new Response();
			response.setMessage("Registration successfully");
			response.setOperationstatus("success");
			return new ResponseEntity<Object>(response,HttpStatus.OK);	
		}
		else {
			response=new Response();
			response.setMessage("Registration failure");
			response.setOperationstatus("failure");
			return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
		}
	
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody UserDetails user){
		System.out.println("---login form----");
		System.out.println(user.getUser_name());
		
	boolean result= userservice.login(user);
	
		Response response=null;
		
		
		if(result == true) {
			
			response=new Response();
			response.setMessage("Login successfully");
			response.setOperationstatus("success");
			return new ResponseEntity<Object>(response,HttpStatus.OK);	
		}
		else {
			response=new Response();
			response.setMessage("Login failure");
			response.setOperationstatus("failure");
			return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
		}
	
		
		
	}
	
	

}
