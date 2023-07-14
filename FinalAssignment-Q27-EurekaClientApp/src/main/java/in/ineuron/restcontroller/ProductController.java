package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Product;
import in.ineuron.service.IProductService;

/*
 27. Create a Spring Boot application that uses Spring Cloud to register a service with
	 Eureka Server. The application should expose a REST API for retrieving data from a
	 database and the API should be discovered by Eureka Server.
 */

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private IProductService service;
	
	@GetMapping("/find/{pid}")
	public ResponseEntity<?> displayProductById(@PathVariable Integer pid){
		Product product = service.fetchProductById(pid);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
}
