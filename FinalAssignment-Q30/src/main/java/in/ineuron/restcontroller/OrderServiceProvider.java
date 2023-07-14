package in.ineuron.restcontroller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/*
 30. Create a Spring Boot application that uses Spring Cloud Circuit Breaker to handle
	 failures in a REST API. The API should use a circuit breaker pattern to handle
	 timeouts and other errors.
 */

@RestController
@RequestMapping("/api/order")
public class OrderServiceProvider {

	@GetMapping("/show")
	@HystrixCommand(fallbackMethod = "showFallBack")
	public String showMsg() {
		System.out.println("OrderServiceProvider.showMsg()");
		
		if (new Random().nextInt(10)<=10) {
			throw new RuntimeException("DUMMY");
		}
		return "Hello from provider";
	}
	
	
	public String showFallBack() {
		System.out.println("OrderServiceProvider.showFallBack()");
		return "From fallBack Method";
	}
}
