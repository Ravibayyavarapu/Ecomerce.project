package Ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecommerce.Model.Amazone;
import Ecommerce.Service.AmazoneService;
import Ecommerce.utils.Response;

@RequestMapping("/amazone")
@RestController
public class AmazoneController {
	
	@Autowired
	private AmazoneService amazoneservice;
	
	@PostMapping("/add")
	public ResponseEntity <Object> add(@RequestBody Amazone amazone) {
		
		boolean result=amazoneservice.add(amazone);
		
		if(result==true) {
			
			Response response=new Response();
			response.setMessage("Item Added Successfully");
			response.setOperationstatus("success");
			return new ResponseEntity <Object>(response,HttpStatus.OK);
			
		}else {
			Response response=new Response();
			response.setMessage("Item Added failed");
			response.setOperationstatus("failed");
			return new ResponseEntity <Object>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		
	}

}
