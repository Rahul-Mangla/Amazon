package com.cart.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.cart.demo.model.CustomerSecureData;

public interface CustomerSecureRepo extends CrudRepository<CustomerSecureData, Integer>{

}
