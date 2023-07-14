package in.ineuron.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IProductDao;
import in.ineuron.model.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao dao;

	@Override
	public List<Product> fetchAllProducts() {
		List<Product> products = dao.findAll();
		products.sort((p1, p2) -> p1.getPid().compareTo(p2.getPid()));
		return products;
	}

}
