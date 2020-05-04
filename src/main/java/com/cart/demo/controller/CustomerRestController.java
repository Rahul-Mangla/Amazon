package com.cart.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.demo.model.Category;
import com.cart.demo.model.Customer;
import com.cart.demo.model.CustomerAddress;
import com.cart.demo.model.CustomerSecureData;
import com.cart.demo.model.Product;
import com.cart.demo.model.Seller;
import com.cart.demo.model.SellerSecureData;
import com.cart.demo.model.Wishlist;
import com.cart.demo.repo.CustomerAddressRepo;
import com.cart.demo.repo.CustomerRepo;
import com.cart.demo.repo.CustomerSecureRepo;
import com.cart.demo.repo.ProductRepo;
import com.cart.demo.repo.SellerRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerRestController {

	@Autowired
	private CustomerRepo repo;

	@Autowired
	private CustomerAddressRepo caRepo;

	@Autowired
	private CustomerSecureRepo CustomerSecureRepo;

	@Autowired
	SellerRepo sellerRepo;

	@Autowired
	ProductRepo productRepo;

	@GetMapping("/test")
	public String ReturnString() {

		CustomerSecureData CSD = new CustomerSecureData();
		List<CustomerAddress> ll = new ArrayList<>();
		CustomerAddress ca = new CustomerAddress();
		CustomerAddress ca2 = new CustomerAddress();

		Customer c = new Customer();
		c.setCustId(4324);
		c.setEmail("RahulMangla.com");
		c.setName("Rahul");
		c.setPhone("9996761604");

		// 1st customer address
		ca.setCustAddressId(1001);
		ca.setCity("Pune");
		ca.setPincode("121102");
		ca.setStreet("Megapolis");
		ca.setCustomer(c);

		// 2nd customer address
		ca2.setCustAddressId(1022);
		ca2.setCity("Pune-Wakad");
		ca2.setPincode("411057");
		ca2.setStreet("Mystic");
		ca2.setCustomer(c);

		ll.add(ca);
		ll.add(ca2);

		CSD.setLoggedStatus(true);
		CSD.setPassword("password");

		c.setCustomerAddress(ll);
		// c.setCustomerSecureAddress(CSA);

		// onetoone mapping procedure
		CSD.setCustomer(c);
		c.setCustomerSecureData(CSD);

		// casRepo.save(CSA);
		repo.save(c);
		// caRepo.save(ca);
		// CustomerSecureRepo.save(CSD);
		return "Hello Customer Controller";

	}

	@GetMapping("/savecustomer")
	public String saveCustomer() {

		return "customer data saved";
	}

	@GetMapping("/saveSeller")
	public String saveSeller() {
		Seller seller = new Seller();
		SellerSecureData sellerSecureData = new SellerSecureData();

		// OneToOne mapping data for seller or secure
		seller.setName("Ravi");
		seller.setPhone(542395840);
		seller.setPincode(121102);
		seller.setCity("Ballabgarh");

		sellerSecureData.setLoggedStatus(false);
		sellerSecureData.setPassword("pass123");

		seller.setSellerSecureData(sellerSecureData);
		sellerSecureData.setSeller(seller);

		sellerRepo.save(seller);

		return "Seller data saved";
	}

	@GetMapping("/saveproduct")
	public String saveproduct() {
		Product product = new Product();
		Category category = new Category();
		List<Product> productList = new ArrayList<>();

		product.setProductName("Adidas shoes");
		product.setDescription("cofortable Rig rag");
		product.setAvail(true);
		product.setQuantity(15);
		product.setPrice(1499.99);
		productList.add(product);

		category.setCategoryName("Shoes");
		category.setProduct(productList);
		product.setCategory(category);
		productRepo.save(product);

		return "product data saved";
	}

	@GetMapping("/saveSP")
	public String saveSellerProduct() {

		Product product = new Product();
		Seller seller = new Seller();
		Set<Product> productList = new HashSet();
		Set<Seller> sellerList = new HashSet();

		product.setProductName("Adidas shoes");
		product.setDescription("cofortable Rig rag");
		product.setAvail(true);
		product.setQuantity(15);
		product.setPrice(1499.99);
		productList.add(product);

		seller.setName("poonam");
		seller.setPhone(542395840);
		seller.setPincode(121102);
		seller.setCity("palwal");
		sellerList.add(seller);

		product.setSeller(sellerList);
		seller.setProduct(productList);

		sellerRepo.save(seller);
		return "SellerProduct data saved";
	}

	@GetMapping("/savewish")
	public String saveWish() {
		Wishlist wishlist = new Wishlist();
		Customer c = new Customer();
		c.setCustId(4324);
		c.setEmail("RahulMangla.com");
		c.setName("Rahul");
		c.setPhone("9996761604");

		wishlist.setAvailable(true);
		wishlist.setCustomer(c);
		c.setWishList(wishlist);
		
		repo.save(c);
		
		return "wish data saved";
	}

}
