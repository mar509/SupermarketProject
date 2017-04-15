package com.supermarket.metier;

import java.util.List;

import com.supermarket.entities.Brand;

public interface BrandMetierInter {
	
	Brand findOneBrand(Long idBrand);
	List<Brand> findall();
	Brand addBrand(Brand brand);
	Brand updateBrand(Brand brand);
	void deleteBrand(Long idBrand);
	

}
