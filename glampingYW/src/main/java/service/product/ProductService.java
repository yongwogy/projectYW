package service.product;

import java.util.List;

import model.Product;

public interface ProductService {
	
	int getTotal(Product product);
	
	List<Product> listTop(Product product);
	
	List<Product> listBest(Product product);
	
	List<Product> list(Product product);
	
	Product proview(int pro_no);

}
