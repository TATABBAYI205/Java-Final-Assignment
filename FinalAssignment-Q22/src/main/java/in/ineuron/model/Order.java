package in.ineuron.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "MTO_ORDER")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@NonNull 
	private String orderDescription;
	
	@ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private User user;
	
	public Order() {
		System.out.println("Order:: Zero param constructor is called ::" + this.getClass());
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDescription=" + orderDescription + "]";
	}
	
	
	
}
