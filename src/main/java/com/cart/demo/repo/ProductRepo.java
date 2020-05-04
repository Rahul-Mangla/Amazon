package com.cart.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.cart.demo.model.Product;

public interface ProductRepo extends CrudRepository<Product, Integer>{

}
