package com.supermarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.entities.Products;

public interface ProductsDao extends JpaRepository<Products, Long> {

}
