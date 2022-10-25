package com.bk.OnlineShoppingAPI.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Long>{

	Seller findBySellerId(Long id);
	
}
