package com.cart.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class CustomerSecureData {

	public CustomerSecureData(){	}
	
	@Id 
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(generator = "newGenerator")
	@GenericGenerator(name = "newGenerator",strategy = "foreign",parameters = {@Parameter (value = "customer",name = "property") })
	private Integer custId;	
	private String password;
	private Boolean loggedStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="custId")
	private Customer customer;
	
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
