package com.bk.OnlineShoppingAPI.order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bk.OnlineShoppingAPI.product.Product;
import com.bk.OnlineShoppingAPI.product.ProductNotFoundException;
import com.bk.OnlineShoppingAPI.product.ProductService;
import com.bk.OnlineShoppingAPI.user.User;
import com.bk.OnlineShoppingAPI.user.UserNotFoundException;
import com.bk.OnlineShoppingAPI.user.UserService;

@Service
public class OrderService {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderRepo orderRepo;

	public Order getOrderById(Long orderId) throws OrderNotFoundException {
		Order order = orderRepo.findByOrderId(orderId);
		if(order == null)
			throw new OrderNotFoundException("Order with Given Id is Not Found");
		return order;
	}
	
	public List<Order> getAllOrder() throws OrderNotFoundException {
		List<Order> orders = orderRepo.findAll();
		if(orders.isEmpty())
			throw new OrderNotFoundException("There is No Orders at All");
		return orders;
	}

	public void orderProduct(Long userId, Long productId, Integer orderedQuantity) throws ProductNotFoundException, InvalidOrderException, UserNotFoundException {
		Product product = productService.getProductById(productId);
		if(product.getQuantity()<orderedQuantity)
		{
			throw new InvalidOrderException("Do Not Have the Required Quantity of Ordered Product");
		}
		User user = userService.getUserById(userId);
		
		LocalDateTime orderedDateTime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		Long orderedPrice = (long) (orderedQuantity*product.getPrice());
		
		Order order = new Order();
		order.setOrderedDateTime(orderedDateTime);
		order.setOrderedPrice(orderedPrice);
		order.setOrderedQuantity(orderedQuantity);
		order.setProduct(product);
		order.setUser(user);
		
		orderRepo.save(order);
	}
	
}
