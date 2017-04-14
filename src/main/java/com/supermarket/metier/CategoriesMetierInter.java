package com.supermarket.metier;

import java.util.List;

import com.supermarket.entities.Categories;

public interface CategoriesMetierInter {

	List<Categories> getAllCategories();
	Categories findOne(Long idCategorie);
	Categories addCategorie( Categories categorie);
	void deleteCategorie(Categories categorie, Long idCategorie);
	Categories updateCategorie(Categories categorie, Long idCategorie);

}
