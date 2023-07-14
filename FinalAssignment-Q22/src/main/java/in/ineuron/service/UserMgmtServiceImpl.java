package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Order;
import in.ineuron.model.User;
import in.ineuron.repo.IOrderRepository;
import in.ineuron.repo.IUserRepository;

@Service("service")
public class UserMgmtServiceImpl implements IUserMgmtService {

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private IOrderRepository orderRepo;

	@Override
	public String saveUser(User user) {
		Integer id = userRepo.save(user).getId();
		return "User and its orders saved with id value :: "+id;

	}

	@Override
	public List<Order> fetchOrdersByUserId(Integer id) {
		Optional<User> optional = userRepo.findById(id);
		List<Order> orders = null;
		if (optional.isPresent()) {
			User user = optional.get();
			orders = orderRepo.findByUser(user);
		}
		return orders;
	}

}
