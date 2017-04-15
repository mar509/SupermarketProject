package com.supermarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.entities.Brand;

public interface BrandDao extends JpaRepository<Brand, Long> {

}
