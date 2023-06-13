package Ecommerce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecommerce.Model.Flipkart;
import Ecommerce.Service.flipkartService;
import Ecommerce.utils.Response;
@RequestMapping("/flipkart")
@RestController
public class flipkartController {
	
	@Autowired
	private flipkartService fs;
	
   @PostMapping("/add")
   public ResponseEntity<Object>add(@RequestBody Flipkart flipkar){
	   
	   boolean result=fs.add(flipkar);
	   
	   if(result==true) {
		   
		   Response response=new Response();
		   response.setMessage("Product Added Successfully");
		   response.setOperationstatus("Success");
		   return new ResponseEntity<Object>(response,HttpStatus.OK);
	   }
	   else {
		  
		   Response response=new Response();
		   response.setMessage("Product Adding Failed");
		   response.setOperationstatus("Failure");
		   return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	   }
	   
	   
   }

}
