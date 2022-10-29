package com.bk.OnlineShoppingAPI.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bk.OnlineShoppingAPI.exceptionHandler.InvalidRatingException;
import com.bk.OnlineShoppingAPI.seller.Seller;
import com.bk.OnlineShoppingAPI.seller.SellerNotFoundException;
import com.bk.OnlineShoppingAPI.seller.SellerService;

@Service
public class ProductService {
	
	@Autowired
	private SellerService sellerService;
	@Autowired
	private ProductRepo productRepo;

	public void addProduct(Product product, Long sellerId) throws SellerNotFoundException
	{
		Seller seller = sellerService.getSellerById(sellerId);
		product.setSeller(seller);
		productRepo.save(product);
	}
	
	public void addAllProduct(List<Product> products, Long sellerId) throws SellerNotFoundException
	{
		Seller seller = sellerService.getSellerById(sellerId);
		products.forEach(product -> product.setSeller(seller));
		productRepo.saveAll(products);
	}
	
	public List<Product> getAllProduct() throws ProductNotFoundException
	{
		List<Product> listOfProduct = productRepo.findAll();
		if(listOfProduct.isEmpty())
			throw new ProductNotFoundException("There is No Product at All");
		return listOfProduct;			
	}
	
	public Product getProductById(Long id) throws ProductNotFoundException
	{
		Product product = productRepo.findByProductId(id);
		if(product == null)
			throw new ProductNotFoundException("Product with given Id is Not Found");
		return product;		
	}
	
	public void updateProductDetails(Long id, Product product) throws ProductNotFoundException {
		Product existingProduct = productRepo.findByProductId(id);
		if(existingProduct == null)
		{
			throw new ProductNotFoundException("Product with given Id is Not Found");
		}
		if(product.getProductName()!=null)
			existingProduct.setProductName(product.getProductName());
		if(product.getCategory()!=null)
			existingProduct.setCategory(product.getCategory());
		if(product.getPrice()!=null)
			existingProduct.setPrice(product.getPrice());
		if(product.getQuantity()!=null)
			existingProduct.setQuantity(product.getQuantity());
		if(product.getDescription()!=null)
			existingProduct.setDescription(product.getDescription());
		productRepo.save(existingProduct);
	}
	
	public void updateProductRating(Long id, int rating) throws InvalidRatingException, ProductNotFoundException
	{
		Product product = productRepo.findByProductId(id);
		if(product == null)
		{
			throw new ProductNotFoundException("Product with given Id is Not Found");
		}
		switch (rating) {
		case 0:
			product.setTotal0Rating(product.getTotal0Rating()+1);
			break;
		case 1:
			product.setTotal1Rating(product.getTotal1Rating()+1);
			break;
		case 2:
			product.setTotal2Rating(product.getTotal2Rating()+1);
			break;
		case 3:
			product.setTotal3Rating(product.getTotal3Rating()+1);
			break;
		case 4:
			product.setTotal4Rating(product.getTotal4Rating()+1);
			break;
		case 5:
			product.setTotal5Rating(product.getTotal5Rating()+1);
			break;
		default:
			throw new InvalidRatingException("Provide Valid Rating From 0 To 5");
		}
		int rating0 = product.getTotal0Rating();
		int rating1 = product.getTotal1Rating();
		int rating2 = product.getTotal2Rating();
		int rating3 = product.getTotal3Rating();
		int rating4 = product.getTotal4Rating();
		int rating5 = product.getTotal5Rating();
		int totalRatings = (rating0*0)+(rating1*1)+(rating2*2)+(rating3*3)+(rating4*4)+(rating5*5);
		double TotalPersonsRated = (double) rating0+rating1+rating2+rating3+rating4+rating5;
		double newRating = totalRatings/TotalPersonsRated;
		product.setRating(newRating);
		productRepo.save(product);
	}
	
	public void removeProductById(Long id)
	{
		productRepo.deleteById(id);
	}
	
	public void removeAllProduct()
	{
		productRepo.deleteAll();
	}
	
	public List<String> getAllCategory() {
		return productRepo.findDistinctByCategory();	
	}
	
	public List<Product> searchByCategory(String category, Integer minPrice, Integer maxPrice, String orderBy)
	{
		if(minPrice==null)
			minPrice = Integer.MIN_VALUE;
		if(maxPrice==null)
			maxPrice = Integer.MAX_VALUE;
		if(orderBy.equals(new String("DESC")))
		{
			return productRepo.findByCategoryAndPriceBetweenOrderByPriceAsc(category, minPrice, maxPrice);
		}
		else if(orderBy.equals(new String("DESC"))) {
			return productRepo.findByCategoryAndPriceBetweenOrderByPriceDesc(category, minPrice, maxPrice);
		}
		else {
			return productRepo.findByCategoryAndPriceBetween(category, minPrice, maxPrice);
		}
	}
}
