package in.ineuron.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.error.ErrorDetails;
import in.ineuron.exception.ProductNotFoundException;

@RestControllerAdvice
public class ProductErrorControllerAdvice {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleProductNotFoundException(ProductNotFoundException pe){
		System.out.println("ProductErrorControllerAdvice.handleProductNotFoundException()");
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), pe.getMessage(), "404-NotFound");
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e){
		System.out.println("ProductErrorControllerAdvice.handleAllProblems()");
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Problem in execution");
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
