package com.bk.OnlineShoppingAPI.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	Product findByProductId(Long id);
}
