package com.bk.OnlineShoppingAPI.seller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bk.OnlineShoppingAPI.exceptionHandler.InvalidRatingException;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping("/add")
	ResponseEntity<Seller> addSeller(@RequestBody Seller seller)
	{
		sellerService.addSeller(seller);
		return new ResponseEntity<Seller>(HttpStatus.CREATED);		
	}
	
	@PostMapping("/add-all")
	ResponseEntity<List<Seller>> addAllSeller(@RequestBody List<Seller> sellers)
	{
		sellerService.addAllSeller(sellers);
		return new ResponseEntity<List<Seller>>(HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all")
	ResponseEntity<List<Seller>> getAllSeller() throws SellerNotFoundException
	{
		return new ResponseEntity<List<Seller>>(sellerService.getAllSeller(),HttpStatus.FOUND);	
	}
	
	@GetMapping("/get-by-id/{id}")
	ResponseEntity<Seller> getSellerById(@PathVariable("id") Long id) throws SellerNotFoundException
	{
		return new ResponseEntity<Seller>(sellerService.getSellerById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update-seller/{id}")
	ResponseEntity<Seller> updateSellerDetails(@PathVariable("id") Long id, @RequestBody Seller seller) throws SellerNotFoundException
	{	
		sellerService.updateSellerDetails(id, seller);
		return new ResponseEntity<Seller>(HttpStatus.OK);
	}
	
	@PatchMapping("/update-rating/{id}/{rating}")
	ResponseEntity<Seller> updateSellerRating(@PathVariable("id") Long id,@PathVariable("rating") int rating) throws SellerNotFoundException, InvalidRatingException
	{
		sellerService.updateSellerRating(id, rating);
		return new ResponseEntity<Seller>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	ResponseEntity<Seller> removeSellerById(@PathVariable("id") Long id)
	{
		sellerService.removeSellerById(id);
		return new ResponseEntity<Seller>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-all")
	ResponseEntity<Seller> removeAllSeller()
	{
		sellerService.removeAllSeller();
		return new ResponseEntity<Seller>(HttpStatus.OK);
	}
	
}

