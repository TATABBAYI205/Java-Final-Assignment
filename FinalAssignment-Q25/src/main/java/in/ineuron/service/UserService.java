package in.ineuron.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public void saveUser() {
		System.out.println("User saved to database");
	}
	
	public void getUser() {
		System.out.println("User Retrived from database...");
	}
	
	public void deleteUser() {
		System.out.println("User Deleted from database...");
	}
	
	public Integer saveEmployee() {  //#3

		System.out.println("User Object is saved...");

		return 10;

	}
}
