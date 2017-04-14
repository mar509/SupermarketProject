package com.supermarket.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.entities.Categories;
import com.supermarket.metier.CategoriesMetierInter;

@RestController
public class CategoriesRestService {
	
	private CategoriesMetierInter categoriesMetierInter ;

	@RequestMapping(value="/products",method=RequestMethod.PUT)
	public Categories addCategorie(@RequestBody Categories categorie) {
		return categoriesMetierInter.addCategorie(categorie);
	}
	@RequestMapping(value="/products",method=RequestMethod.DELETE)
	public void deleteCategorie(@RequestBody Categories categorie, @PathVariable Long idCategorie) {
		categoriesMetierInter.deleteCategorie(categorie, idCategorie);
	}

	@RequestMapping(value="/products",method=RequestMethod.POST)
	public Categories updateCategorie(@RequestBody Categories categorie, @PathVariable  Long idCategorie) {
		return categoriesMetierInter.updateCategorie(categorie, idCategorie);
	}

	@RequestMapping(value="/products/all",method=RequestMethod.GET)
	public List<Categories> getAllCategories() {
		return categoriesMetierInter.getAllCategories();
	}

	@RequestMapping(value="/products/{idCategorie}",method=RequestMethod.GET)
	public Categories findOne(@PathVariable  Long idCategorie) {
		return categoriesMetierInter.findOne(idCategorie);
	}

}
