package com.sa45.team3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa45.team3.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
