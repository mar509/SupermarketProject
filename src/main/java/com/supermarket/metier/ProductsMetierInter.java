package com.supermarket.metier;

import java.util.List;

import com.supermarket.entities.Products;

public interface ProductsMetierInter {	
	List<Products> getAllProduct();
	Products findOne(Long idProduct);
	List<Products> getAllProductForCategorie(Long idCategorie);
	Products addProductInCategories(Products product, Long idCategorie);
	Products saveProducts(Products product);
	Products updateProducts(Products product);
	void deleteProducts(long idProduct);

}
