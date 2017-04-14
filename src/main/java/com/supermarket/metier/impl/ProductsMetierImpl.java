package com.supermarket.metier.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.assertj.core.internal.cglib.core.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.dao.CategoriesDao;
import com.supermarket.dao.ProductsDao;
import com.supermarket.entities.Categories;
import com.supermarket.entities.Products;
import com.supermarket.metier.ProductsMetierInter;

@Service
public class ProductsMetierImpl implements ProductsMetierInter {

	@Autowired
	private ProductsDao productsDao;
	
	@Autowired
	private CategoriesDao categoriesDao;
	
	@Override
	public List<Products> getAllProduct() {
		return productsDao.findAll();
	}

	@Override
	public Products findOne(Long idProduct) {		
		return  productsDao.findOne(idProduct) ;
	}

	@Override
	public List<Products> getAllProductForCategorie(Long idCategorie) {
		Categories categorie = categoriesDao.findOne(idCategorie);
		List<Products> allProductForCategories =  (List<Products>) categorie.getProduct(); //getAllProduct();
		if(allProductForCategories==null)
			return Collections.emptyList();	
		else return allProductForCategories;
//		allProductForCategories.stream().filter(s->s.getCategories().equals(categorie)) ;
//		return allProductForCategories;
	}

	@Override
	public Products addProductInCategories(Products product, Long idCategorie) {
		Categories categorie = categoriesDao.findOne(idCategorie);
		product.setProductBuyDate(new Date());
		product.setCategories(categorie);
		return productsDao.save(product);
	}

	@Override
	public Products saveProducts(Products product) {
		 product.setProductAddDate(new Date());
		return productsDao.save(product);
	}

	@Override
	public Products updateProducts(Products product) {
		product.setProductUpdateDate(new Date());
		return productsDao.save(product);
	}

	@Override
	public void deleteProducts(long idProduct) {
		Products product =productsDao.findOne(idProduct);
		productsDao.delete(product);
	}

}
