package com.supermarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.entities.Categories;

public interface CategoriesDao extends JpaRepository<Categories, Long> {

}
