package com.supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.entities.Brand;
import com.supermarket.metier.BrandMetierInter;

@RestController
public class BrandRestService {
	
	@Autowired
	private BrandMetierInter brandMetier;

	
	public Brand findOneBrand(Long idBrand) {
		return brandMetier.findOneBrand(idBrand);
	}

	public List<Brand> findall() {
		return brandMetier.findall();
	}

	public Brand addBrand(Brand brand) {
		return brandMetier.addBrand(brand);
	}

	public Brand updateBrand(Brand brand) {
		return brandMetier.updateBrand(brand);
	}

	public void deleteBrand(Long idBrand) {
		brandMetier.deleteBrand(idBrand);
	}

}
