package Ecommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecommerce.Model.Product;
import Ecommerce.Service.ProductService;
import Ecommerce.utils.Response;

@RequestMapping("/product")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/add")
	public ResponseEntity<Object> add(@RequestBody Product product) {
		
	boolean result=	productservice.add(product);
	
	if(result==true) {
		
		Response response =new Response();
		response.setMessage("product added successfully");
		response.setOperationstatus("success");
		return new ResponseEntity<Object>(response,HttpStatus.CREATED);
	 
	}else {
		Response response =new Response();
		response.setMessage("product adding failed ");
		response.setOperationstatus("Failed");
		return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	 
		
	}
	
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Object> delete(@RequestBody Product delete) {
				
	boolean	result=productservice.delete(delete);
	
	if(result==true) {
		
		Response response=new Response();
		response.setMessage("Product deleted successfully");
		response.setOperationstatus("success");
		return new ResponseEntity<Object>(response,HttpStatus.OK);
		
	}
	else {
		Response response=new Response();
		response.setMessage("Product deleting failed");
		response.setOperationstatus("Failed");
		return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	}
	}
	
	@GetMapping("/list")
	public ResponseEntity<Object>list(){
     List<Product> result=productservice.list();
     return new ResponseEntity<Object>(result,HttpStatus.OK);
		
		
		
	}

}
