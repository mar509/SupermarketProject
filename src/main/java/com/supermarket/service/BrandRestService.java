package com.supermarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.entities.Brand;
import com.supermarket.metier.BrandMetierInter;

@RestController
public class BrandRestService {
	
	@Autowired
	private BrandMetierInter brandMetier;

	@RequestMapping(value="/brands/{idBrand}",method=RequestMethod.GET)
	public Brand findOneBrand(@PathVariable Long idBrand) {
		return brandMetier.findOneBrand(idBrand);
	}

	public List<Brand> findall() {
		return brandMetier.findall();
	}

	@RequestMapping(value="/brands",method=RequestMethod.POST)
	public Brand addBrand(@RequestBody Brand brand) {
		return brandMetier.addBrand(brand);
	}

	@RequestMapping(value="/brands",method=RequestMethod.PUT)
	public Brand updateBrand(@RequestBody Brand brand) {
		return brandMetier.updateBrand(brand);
	}
	@RequestMapping(value="/brands/{idBrand}",method=RequestMethod.PUT)
	public void deleteBrand(@PathVariable Long idBrand) {
		brandMetier.deleteBrand(idBrand);
	}

}
