package com.supermarket.metier.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.dao.CategoriesDao;
import com.supermarket.entities.Categories;
import com.supermarket.metier.CategoriesMetierInter;

@Service
public class CategoriesMetierImpl implements CategoriesMetierInter {

	@Autowired
	private CategoriesDao categoriesDao;

	@Override
	public List<Categories> getAllCategories() {
		if(categoriesDao.findAll().isEmpty())
			return Collections.emptyList() ;
		
		return categoriesDao.findAll();
	}

	@Override
	public Categories findOne(Long idCategorie) {
		return categoriesDao.findOne(idCategorie);
	}

	@Override
	public Categories addCategorie(Categories categorie) {	
		categorie.setCategorieCreationDate(new Date());
		return categoriesDao.save(categorie);
	}

	@Override
	public void deleteCategorie(Categories categorie, Long idCategorie) {
		categorie = categoriesDao.findOne(idCategorie);
		 categoriesDao.delete(categorie);
		
	}

	@Override
	public Categories updateCategorie(Categories categorie, Long idCategorie) {
		categorie = categoriesDao.findOne(idCategorie);
		categorie.setCategorieUpdateDate(new Date());
		return categoriesDao.save(categorie);
		
	}

}
