package com.bk.OnlineShoppingAPI.seller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sellers")
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long sellerId;
	private String sellerName;
	private String emailId;
	private String contactNo;
	private String address;
	private Integer pincode;
	private int total0Rating;
	private int total1Rating;
	private int total2Rating;
	private int total3Rating;
	private int total4Rating;
	private int total5Rating;
	private double rating;
	
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contactNo == null) ? 0 : contactNo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		result = prime * result + ((sellerId == null) ? 0 : sellerId.hashCode());
		result = prime * result + ((sellerName == null) ? 0 : sellerName.hashCode());
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
		Seller other = (Seller) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		if (sellerId == null) {
			if (other.sellerId != null)
				return false;
		} else if (!sellerId.equals(other.sellerId))
			return false;
		if (sellerName == null) {
			if (other.sellerName != null)
				return false;
		} else if (!sellerName.equals(other.sellerName))
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
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", emailId=" + emailId + ", contactNo="
				+ contactNo + ", address=" + address + ", pincode=" + pincode + ", total0Rating=" + total0Rating
				+ ", total1Rating=" + total1Rating + ", total2Rating=" + total2Rating + ", total3Rating=" + total3Rating
				+ ", total4Rating=" + total4Rating + ", total5Rating=" + total5Rating + ", rating="
				+ rating + "]";
	}

}
