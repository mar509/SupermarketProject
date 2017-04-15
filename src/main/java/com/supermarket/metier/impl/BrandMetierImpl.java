package com.supermarket.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.dao.BrandDao;
import com.supermarket.entities.Brand;
import com.supermarket.metier.BrandMetierInter;

@Service
public class BrandMetierImpl implements BrandMetierInter {

	@Autowired
	BrandDao brandDao;
	
	@Override
	public Brand findOneBrand(Long idBrand) {		
		return brandDao.findOne(idBrand);
	}

	@Override
	public List<Brand> findall() {
		// TODO Auto-generated method stub
		return brandDao.findAll();
	}

	@Override
	public Brand addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.save(brand);
	}

	@Override
	public Brand updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.save(brand);
	}

	@Override
	public void deleteBrand(Long idBrand) {
		Brand brand = findOneBrand(idBrand);
		 brandDao.delete(brand);
		
	}

}
