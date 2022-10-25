package com.bk.OnlineShoppingAPI.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bk.OnlineShoppingAPI.seller.Seller;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private Integer quantity;
	private String category;
	private Integer price;
	private String description;
	private int total0Rating;
	private int total1Rating;
	private int total2Rating;
	private int total3Rating;
	private int total4Rating;
	private int total5Rating;
	private double rating;
	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private Seller seller;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotal0Rating() {
		return total0Rating;
	}

	public void setTotal0Rating(int total0Rating) {
		this.total0Rating = total0Rating;
	}

	public int getTotal1Rating() {
		return total1Rating;
	}

	public void setTotal1Rating(int total1Rating) {
		this.total1Rating = total1Rating;
	}

	public int getTotal2Rating() {
		return total2Rating;
	}

	public void setTotal2Rating(int total2Rating) {
		this.total2Rating = total2Rating;
	}

	public int getTotal3Rating() {
		return total3Rating;
	}

	public void setTotal3Rating(int total3Rating) {
		this.total3Rating = total3Rating;
	}

	public int getTotal4Rating() {
		return total4Rating;
	}

	public void setTotal4Rating(int total4Rating) {
		this.total4Rating = total4Rating;
	}

	public int getTotal5Rating() {
		return total5Rating;
	}

	public void setTotal5Rating(int total5Rating) {
		this.total5Rating = total5Rating;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((seller == null) ? 0 : seller.hashCode());
		result = prime * result + total0Rating;
		result = prime * result + total1Rating;
		result = prime * result + total2Rating;
		result = prime * result + total3Rating;
		result = prime * result + total4Rating;
		result = prime * result + total5Rating;
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
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (seller == null) {
			if (other.seller != null)
				return false;
		} else if (!seller.equals(other.seller))
			return false;
		if (total0Rating != other.total0Rating)
			return false;
		if (total1Rating != other.total1Rating)
			return false;
		if (total2Rating != other.total2Rating)
			return false;
		if (total3Rating != other.total3Rating)
			return false;
		if (total4Rating != other.total4Rating)
			return false;
		if (total5Rating != other.total5Rating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", category=" + category + ", price=" + price + ", description=" + description + ", total0Rating="
				+ total0Rating + ", total1Rating=" + total1Rating + ", total2Rating=" + total2Rating + ", total3Rating="
				+ total3Rating + ", total4Rating=" + total4Rating + ", total5Rating=" + total5Rating + ", rating="
				+ rating + ", seller=" + seller + "]";
	}
	
}
