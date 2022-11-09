package com.bk.OnlineShoppingAPI.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bk.OnlineShoppingAPI.product.ProductNotFoundException;
import com.bk.OnlineShoppingAPI.user.UserNotFoundException;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/get-by-id/{orderId}")
	ResponseEntity<Order> getOrderById(@PathVariable("orderId") Long orderId) throws OrderNotFoundException
	{
		return new ResponseEntity<Order>(orderService.getOrderById(orderId),HttpStatus.FOUND);
	}
	
	@GetMapping("/get-all")
	ResponseEntity<List<Order>> getAllOrder() throws OrderNotFoundException
	{
		return new ResponseEntity<List<Order>>(orderService.getAllOrder(),HttpStatus.FOUND);
	}
	
	@PostMapping("/{productId}")
	ResponseEntity<Order> orderProduct(@PathVariable("productId") Long productId, @RequestParam("userId") Long userId, @RequestParam("orderedQuantity") Integer orderedQuantity) throws ProductNotFoundException, InvalidOrderException, UserNotFoundException
	{
		orderService.orderProduct(userId, productId, orderedQuantity);
		return new ResponseEntity<Order>(HttpStatus.ACCEPTED);
	}
}
