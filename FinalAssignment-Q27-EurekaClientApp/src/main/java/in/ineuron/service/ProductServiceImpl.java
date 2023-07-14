package in.ineuron.service;

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
	public Product fetchProductById(Integer pid) {
		return dao.findById(pid)
				.orElseThrow(() -> new ProductNotFoundException("Product with id " + pid + " not found"));
	}

}
