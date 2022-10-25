package com.bk.OnlineShoppingAPI.product;


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
import com.bk.OnlineShoppingAPI.seller.Seller;
import com.bk.OnlineShoppingAPI.seller.SellerNotFoundException;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/add/{sellerId}")
	public ResponseEntity<Product> name(@PathVariable("sellerId") Long sellerId,@RequestBody Product product) throws SellerNotFoundException {
		productService.addProduct(product, sellerId);
		return new ResponseEntity<>(HttpStatus.CREATED);		
	}
	
	@PostMapping("/add-all/{sellerId}")
	public ResponseEntity<Product> name(@PathVariable("sellerId") Long sellerId,@RequestBody List<Product> products) throws SellerNotFoundException {
		productService.addAllProduct(products, sellerId);
		return new ResponseEntity<>(HttpStatus.CREATED);		
	}
	
	@GetMapping("/get-all")
	ResponseEntity<List<Product>> getAllProduct() throws ProductNotFoundException
	{
		return new ResponseEntity<List<Product>>(productService.getAllProduct(),HttpStatus.FOUND);	
	}
	
	@GetMapping("/get-by-id/{id}")
	ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException
	{
		return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update-product/{id}")
	ResponseEntity<Product> updateProductDetails(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException
	{	
		productService.updateProductDetails(id, product);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
	@PatchMapping("/update-rating/{id}/{rating}")
	ResponseEntity<Product> updateProductRating(@PathVariable("id") Long id,@PathVariable("rating") int rating) throws ProductNotFoundException, InvalidRatingException
	{
		productService.updateProductRating(id, rating);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-by-id/{id}")
	ResponseEntity<Product> removeSellerById(@PathVariable("id") Long id)
	{
		productService.removeProductById(id);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-all")
	ResponseEntity<Seller> removeAllSeller()
	{
		productService.removeAllProduct();
		return new ResponseEntity<Seller>(HttpStatus.OK);
	}
}
