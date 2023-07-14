package in.ineuron.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.service.UserService;

/*
 25. Create a Spring Boot application that uses Spring AOP to log method calls. The
	 application should have a service class with methods that perform operations. The
	 application should use Spring AOP to log the method calls with input and output
	 parameters to the console.
 */


@Component
public class UserRunner implements CommandLineRunner {

	@Autowired
	private UserService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.saveUser();
		System.out.println();
		service.getUser();
		System.out.println();
		service.deleteUser();
		System.out.println();
		service.saveEmployee();
		
	}

}
