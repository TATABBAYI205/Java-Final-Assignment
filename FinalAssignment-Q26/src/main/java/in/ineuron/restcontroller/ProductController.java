package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Product;
import in.ineuron.service.IProductService;

/*
 26. Create a Spring Boot application that exposes a REST API for managing a list of
	 products. The API should allow for creating, updating, deleting, and retrieving products.
 */

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> insertProduct(@RequestBody Product product){
		String createStatus = service.createProduct(product);
		return new ResponseEntity<String>(createStatus, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAllProducts(){
		List<Product> products = service.fetchAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@GetMapping("/find/{pid}")
	public ResponseEntity<?> displayProductById(@PathVariable Integer pid){
		Product product = service.fetchProductById(pid);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<?> modifyProduct(@RequestBody Product product){
		String updateProduct = service.updateProduct(product);
		return new ResponseEntity<String>(updateProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{pid}")
	public ResponseEntity<?> removeProductById(@PathVariable Integer pid){
		String deleteProduct = service.deleteProduct(pid);
		return new ResponseEntity<String>(deleteProduct, HttpStatus.OK);
	}
}
