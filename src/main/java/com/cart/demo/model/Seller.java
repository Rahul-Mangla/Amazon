package com.cart.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Seller {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer sellerId;
private String Name;
private Integer Phone;
private String city;
private Integer pincode;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "sellerId")
private SellerSecureData sellerSecureData;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
		  name = "seller_product", 
		  joinColumns = @JoinColumn(name = "sellerId"), 
		  inverseJoinColumns = @JoinColumn(name = "productId"))
private Set<Product> product;

public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> product) {
	this.product = product;
}

public SellerSecureData getSellerSecureData() {
	return sellerSecureData;
}
public void setSellerSecureData(SellerSecureData sellerSecureData) {
	this.sellerSecureData = sellerSecureData;
}

public Integer getSellerId() {
	return sellerId;
}
public void setSellerId(Integer sellerId) {
	this.sellerId = sellerId;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Integer getPhone() {
	return Phone;
}
public void setPhone(Integer phone) {
	Phone = phone;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Integer getPincode() {
	return pincode;
}
public void setPincode(Integer pincode) {
	this.pincode = pincode;
}


	
}
