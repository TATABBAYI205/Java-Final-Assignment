package in.ineuron.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Order;
import in.ineuron.model.User;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
	
	public List<Order> findByUser(User user);

}
