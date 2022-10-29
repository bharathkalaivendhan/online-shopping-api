package com.bk.OnlineShoppingAPI.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	public Product findByProductId(Long id);
	@Query("SELECT DISTINCT category FROM Product")
	public List<String> findDistinctByCategory();
	public List<Product> findByCategoryAndPriceBetweenOrderByPriceAsc(String category, Integer minPrice, Integer maxPrice);
	public List<Product> findByCategoryAndPriceBetweenOrderByPriceDesc(String category, Integer minPrice, Integer maxPrice);
	public List<Product> findByCategoryAndPriceBetween(String category, Integer minPrice, Integer maxPrice);
}
