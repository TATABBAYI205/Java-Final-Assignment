package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Product;
import in.ineuron.service.IProductService;

/*
 29. Create a Spring Boot application that uses Spring Data JPA to retrieve data from a
	 database and expose it as a REST API. The API should allow for filtering, sorting,
	 and paging.
 */

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAllProducts(){
		List<Product> products = service.fetchAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
