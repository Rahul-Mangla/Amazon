package com.cart.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class SellerSecureData {
	//id generation process pending
    @Id
    @GeneratedValue(generator = "newGenerator")
	@GenericGenerator(name = "newGenerator",strategy = "foreign",parameters = {@Parameter (value = "seller",name = "property") })
    private Integer sellerId;
	private String password;
	private Boolean loggedStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sellerId")
	private Seller seller;
	
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getLoggedStatus() {
		return loggedStatus;
	}
	public void setLoggedStatus(Boolean loggedStatus) {
		this.loggedStatus = loggedStatus;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	
}
