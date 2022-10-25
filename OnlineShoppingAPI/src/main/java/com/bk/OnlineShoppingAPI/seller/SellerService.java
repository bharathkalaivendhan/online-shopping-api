package com.bk.OnlineShoppingAPI.seller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bk.OnlineShoppingAPI.exceptionHandler.InvalidRatingException;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepo sellerRepo;
	
	public void addSeller(Seller seller) {
		sellerRepo.save(seller);
		return;
	}
	
	public void addAllSeller(List<Seller> seller) {
		sellerRepo.saveAll(seller);
		return;
	}
	
	public List<Seller> getAllSeller() throws SellerNotFoundException
	{
		
		List<Seller> listOfSeller = sellerRepo.findAll();
		if(listOfSeller.isEmpty())
			throw new SellerNotFoundException("There is No Seller at All");
		return listOfSeller;			
	}
	
	public Seller getSellerById(Long id) throws SellerNotFoundException
	{
		Seller seller = sellerRepo.findBySellerId(id);
		if(seller == null)
			throw new SellerNotFoundException("Seller with given Id is Not Found");
		return seller;		
	}

	public void updateSellerDetails(Long id, Seller seller) throws SellerNotFoundException {
		Seller existingSeller = sellerRepo.findBySellerId(id);
		if(existingSeller == null)
		{
			throw new SellerNotFoundException("Seller with given Id is Not Found");
		}
		if(seller.getSellerName()!=null)
		existingSeller.setSellerName(seller.getSellerName());
		if(seller.getEmailId()!=null)
		existingSeller.setEmailId(seller.getEmailId());
		if(seller.getContactNo()!=null)
		existingSeller.setContactNo(seller.getContactNo());
		if(seller.getAddress()!=null)
		existingSeller.setAddress(seller.getAddress());
		if(seller.getPincode()!=null)
		existingSeller.setPincode(seller.getPincode());
		sellerRepo.save(existingSeller);
	}
	
	public void updateSellerRating(Long id, int rating) throws SellerNotFoundException, InvalidRatingException
	{
		Seller seller = sellerRepo.findBySellerId(id);
		if(seller == null)
		{
			throw new SellerNotFoundException("Seller with given Id is Not Found");
		}
		switch (rating) {
		case 0:
			seller.setTotal0Rating(seller.getTotal0Rating()+1);
			break;
		case 1:
			seller.setTotal1Rating(seller.getTotal1Rating()+1);
			break;
		case 2:
			seller.setTotal2Rating(seller.getTotal2Rating()+1);
			break;
		case 3:
			seller.setTotal3Rating(seller.getTotal3Rating()+1);
			break;
		case 4:
			seller.setTotal4Rating(seller.getTotal4Rating()+1);
			break;
		case 5:
			seller.setTotal5Rating(seller.getTotal5Rating()+1);
			break;
		default:
			throw new InvalidRatingException("Provide Valid Rating From 0 To 5");
		}
		int rating0 = seller.getTotal0Rating();
		int rating1 = seller.getTotal1Rating();
		int rating2 = seller.getTotal2Rating();
		int rating3 = seller.getTotal3Rating();
		int rating4 = seller.getTotal4Rating();
		int rating5 = seller.getTotal5Rating();
		int totalRatings = (rating0*0)+(rating1*1)+(rating2*2)+(rating3*3)+(rating4*4)+(rating5*5);
		double TotalPersonsRated = (double) rating0+rating1+rating2+rating3+rating4+rating5;
		double newRating = totalRatings/TotalPersonsRated;
		seller.setRating(newRating);
		sellerRepo.save(seller);
	}
	
	public void removeSellerById(Long id)
	{
		sellerRepo.deleteById(id);
	}
	
	public void removeAllSeller()
	{
		sellerRepo.deleteAll();
	}

}
