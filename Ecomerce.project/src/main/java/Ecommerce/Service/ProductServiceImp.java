package Ecommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ecommerce.Dao.ProductDAO;
import Ecommerce.Model.Product;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
	private ProductDAO productdao;
	
	public boolean add(Product product) {
		
		return productdao.add(product);
	}

	@Override
	public List<Product> list() {
		return productdao.list();
	}

	@Override
	public boolean update(Product update) {
		
		return false;
	}

	@Override
	public boolean delete(Product delete) {
		
		return productdao.delete(delete);
	}

}
