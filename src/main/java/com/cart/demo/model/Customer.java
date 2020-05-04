package com.cart.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.tomcat.jni.Address;

@Entity
@Table
public class Customer {
	

	public Customer(Integer custId, String email, String name, String phone, List<CustomerAddress> customerAddress) {
		super();
		this.custId = custId;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.customerAddress = customerAddress;
	}

	public Customer() {	}
	
	@Id
  //@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cust_id",unique = true,nullable = false)
	private Integer custId;
	
	private String email;
	private String name;
	private String phone;
	
//  @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
//  @JoinColumn(name = "cust_id")
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<CustomerAddress> customerAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custId")
	private CustomerSecureData customerSecureData;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custId")
	private Wishlist wishList;
	
	public Wishlist getWishList() {
		return wishList;
	}

	public void setWishList(Wishlist wishList) {
		this.wishList = wishList;
	}

	public CustomerSecureData getCustomerSecureData() {
		return customerSecureData;
	}

	public void setCustomerSecureData(CustomerSecureData customerSecureData) {
		this.customerSecureData = customerSecureData;
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", name=" + name + ", phone=" + phone + "]";
	}
	
}
