package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Order;
import in.ineuron.model.User;

public interface IUserMgmtService {
	
	public String saveUser(User user);
	
	public List<Order> fetchOrdersByUserId(Integer id);
}
