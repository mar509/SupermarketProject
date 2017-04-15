package com.supermarket.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Brand")
public class Brand {
	@Id
	@Column(name = "brandId", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandId;
	
	@Column(name = "brandName")
	private String brandName;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="categorieBrand", joinColumns=@JoinColumn(name="categorieId",referencedColumnName="categorieId",nullable = false, updatable = false,insertable=true), inverseJoinColumns=@JoinColumn(name="brandId",referencedColumnName="brandId",nullable = false, updatable = false,insertable=true))
	Collection<Categories> categorie;

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Collection<Categories> getCategorie() {
		return categorie;
	}

	public void setCategorie(Collection<Categories> categorie) {
		this.categorie = categorie;
	}
	
	

}
