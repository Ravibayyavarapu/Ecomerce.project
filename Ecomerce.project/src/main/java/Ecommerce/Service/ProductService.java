package Ecommerce.Service;

import java.util.List;

import Ecommerce.Model.Product;

public interface ProductService {
	
	public boolean add(Product product);
	public  List<Product> list();
	public boolean update(Product update);
	public boolean delete(Product delete);

}
