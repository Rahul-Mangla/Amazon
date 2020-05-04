package com.cart.demo.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
public class CustomerAddress {
	

	public CustomerAddress(Integer custAddressId, String street, String pincode, String city, Boolean isBillingAddress,
			Customer customer) {
		super();
		this.custAddressId = custAddressId;
		this.street = street;
		this.pincode = pincode;
		this.city = city;
		this.isBillingAddress = isBillingAddress;
		this.customer = customer;
	}

	public CustomerAddress() {}
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer custAddressId;
	private String street;
	private String pincode;
	private String city;
	private Boolean isBillingAddress;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	public Integer getCustAddressId() {
		return custAddressId;
	}

	public void setCustAddressId(Integer custAddressId) {
		this.custAddressId = custAddressId;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Boolean getIsBillingAddress() {
		return isBillingAddress;
	}

	public void setIsBillingAddress(Boolean isBillingAddress) {
		this.isBillingAddress = isBillingAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	
	
}
