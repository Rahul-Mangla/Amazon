package com.cart.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.cart.demo.model.CustomerAddress;
public interface CustomerAddressRepo extends CrudRepository<CustomerAddress, Integer> {

}
