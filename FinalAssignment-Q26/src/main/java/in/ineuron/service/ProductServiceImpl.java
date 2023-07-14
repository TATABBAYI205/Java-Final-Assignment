package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IProductDao;
import in.ineuron.exception.ProductNotFoundException;
import in.ineuron.model.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao dao;

	@Override
	public String createProduct(Product product) {
		Integer pid = dao.save(product).getPid();
		return pid != 0 ? "Product created successfully with id :: " + pid : "Product insertion failed";
	}

	@Override
	public List<Product> fetchAllProducts() {
		List<Product> products = dao.findAll();
		products.sort((p1,p2)->p1.getPid().compareTo(p2.getPid()));
		return products;
	}

	@Override
	public Product fetchProductById(Integer pid) {
		return dao.findById(pid)
				.orElseThrow(() -> new ProductNotFoundException("Product with id " + pid + " not found"));
	}

	@Override
	public String updateProduct(Product product) {
		Optional<Product> optional = dao.findById(product.getPid());
		if (optional.isPresent()) {
			dao.save(product);
			return "Product data updated of id :: " + product.getPid();
		} else {
			throw new ProductNotFoundException(
					"Product with id :: " + product.getPid() + " not available for updation");
		}

	}

	@Override
	public String deleteProduct(Integer pid) {
		Optional<Product> optional = dao.findById(pid);
		if (optional.isPresent()) {
			dao.deleteById(pid);
			return "Record deletion succesfull for id :: " + pid;
		} else {
			throw new ProductNotFoundException("Product with id :: " + pid + " not available for deletion");
		}
	}

}
