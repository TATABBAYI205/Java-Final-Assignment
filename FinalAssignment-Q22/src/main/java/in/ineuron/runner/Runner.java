package in.ineuron.runner;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.model.Order;
import in.ineuron.model.User;
import in.ineuron.service.IUserMgmtService;


/*
 22. Create a Spring Boot application that uses Spring Data JPA to retrieve data from a
	 database. The application should have entities for users and orders, and should
	 allow for querying orders by user.
 */


@Component
public class Runner implements CommandLineRunner {
	
	@Autowired
	private IUserMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Insert user and its orders into database
		 * /

		/*
		//Create parent object
		User user = new User("Kohli", "kohli18@gmail.com");
		
		//create child object
		Order order1 = new Order("Mac laptop");
		Order order2 = new Order("Apple Watch");
		Order order3 = new Order("Samsung");
		 
		//link child to parent
		user.setOrders(Set.of(order1, order2, order3));
		
		//Link parent to child
		order1.setUser(user);
		order2.setUser(user);
		order3.setUser(user);
		
		String status = service.saveUser(user);
		System.out.println(status);
		
		*/
		
		/*
		 * Retrieve from database
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter id of user to search orders :: ");
		int id = scan.nextInt();
		
		List<Order> orders = service.fetchOrdersByUserId(id);
		
		if(orders!=null) {
			System.out.println("Orders of user with id :: "+id);
			orders.forEach(order->{
				System.out.println(order.getOrderDescription());
			});
		} else {
			System.out.println("User not found with id "+id);
		}
		
	}

}
