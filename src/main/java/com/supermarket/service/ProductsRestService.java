package com.supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.entities.Products;
import com.supermarket.metier.ProductsMetierInter;

@RestController
public class ProductsRestService {
	
	@Autowired
	private ProductsMetierInter productsMetierInter;

	@RequestMapping(value="/products",method=RequestMethod.GET)
	public List<Products> getAllProduct() {
		return productsMetierInter.getAllProduct();
	}

	@RequestMapping(value="/products/{idProduct}",method=RequestMethod.GET)
	public Products findOne(@PathVariable Long idProduct) {
		return productsMetierInter.findOne(idProduct);
	}

}
