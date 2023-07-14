package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Student;
import in.ineuron.service.IStudentService;

/*
 24. Create a Spring Boot application that uses Spring MVC to create a REST API. The
	 API should accept a JSON request with data and insert it into a MySQL database
	 table using JPA and Hibernate. The application should use Spring Data JPA to map
	 the table to a Java object and then insert the data into the table.
 */

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;

	@PostMapping("/register")
	public ResponseEntity<String> insertRecord(@RequestBody Student student) {
		String status = service.insertStudent(student);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
}
