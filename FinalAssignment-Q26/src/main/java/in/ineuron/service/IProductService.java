package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Product;

public interface IProductService {
	public String createProduct(Product product);
	
	public List<Product> fetchAllProducts();
	
	public Product fetchProductById(Integer pid);
	
	public String updateProduct(Product product);
	
	public String deleteProduct(Integer pid);
}
