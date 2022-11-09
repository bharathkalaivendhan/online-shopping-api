package com.bk.OnlineShoppingAPI.order;

import javax.persistence.Table;

import com.bk.OnlineShoppingAPI.product.Product;
import com.bk.OnlineShoppingAPI.user.User;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	private LocalDateTime orderedDateTime;
	private Long orderedPrice;
	private Integer orderedQuantity;
	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderedDateTime() {
		return orderedDateTime;
	}

	public void setOrderedDateTime(LocalDateTime orderedDateTime) {
		this.orderedDateTime = orderedDateTime;
	}

	public Long getOrderedPrice() {
		return orderedPrice;
	}

	public void setOrderedPrice(Long orderedPrice) {
		this.orderedPrice = orderedPrice;
	}

	public Integer getOrderedQuantity() {
		return orderedQuantity;
	}

	public void setOrderedQuantity(Integer orderedQuantity) {
		this.orderedQuantity = orderedQuantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderedDateTime == null) ? 0 : orderedDateTime.hashCode());
		result = prime * result + ((orderedPrice == null) ? 0 : orderedPrice.hashCode());
		result = prime * result + ((orderedQuantity == null) ? 0 : orderedQuantity.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderedDateTime == null) {
			if (other.orderedDateTime != null)
				return false;
		} else if (!orderedDateTime.equals(other.orderedDateTime))
			return false;
		if (orderedPrice == null) {
			if (other.orderedPrice != null)
				return false;
		} else if (!orderedPrice.equals(other.orderedPrice))
			return false;
		if (orderedQuantity == null) {
			if (other.orderedQuantity != null)
				return false;
		} else if (!orderedQuantity.equals(other.orderedQuantity))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderedDateTime=" + orderedDateTime + ", orderedPrice=" + orderedPrice
				+ ", orderedQuantity=" + orderedQuantity + ", product=" + product + ", user=" + user + "]";
	}
	
}
