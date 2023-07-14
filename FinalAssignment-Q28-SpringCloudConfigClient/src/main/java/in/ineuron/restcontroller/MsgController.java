package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 28. Create a Spring Boot application that uses Spring Cloud Config Server to externalise
	 configuration. The application should have a property file that defines properties for
	 database connection and other application settings.
 */

@RestController
@RequestMapping("/api/test")
public class MsgController {

	@Value("${msg:Config server not working please check...}")
	public String msg;
	
	@GetMapping("/greet")
	public ResponseEntity<String> showMsg(){
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
