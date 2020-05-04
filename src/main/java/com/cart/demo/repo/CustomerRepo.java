package com.cart.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.cart.demo.model.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
