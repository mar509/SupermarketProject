package com.supermarket.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "Categories")
public class Categories {

	@Id
	@Column(name = "categorieId", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categorieId;

	@Column(name = "categorieName")
	private String categorieName;

	@Column(name = "categorieDescription")
	private @Lob String categorieDescription;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "categories")
	private Collection<Products> product;

	@Column(name = "categorieCreationDate")
	private Date categorieCreationDate;

	@Column(name = "categorieUpdateDate")
	private Date categorieUpdateDate;
	
	@ManyToMany(mappedBy="categorie", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Collection<Brand> brand;
	
	
	
	public Collection<Brand> getBrand() {
		return brand;
	}

	public void setBrand(Collection<Brand> brand) {
		this.brand = brand;
	}

	public Long getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(Long categorieId) {
		this.categorieId = categorieId;
	}

	public String getCategorieName() {
		return categorieName;
	}

	public void setCategorieName(String categorieName) {
		this.categorieName = categorieName;
	}

	public String getCategorieDescription() {
		return categorieDescription;
	}

	public void setCategorieDescription(String categorieDescription) {
		this.categorieDescription = categorieDescription;
	}

	public Date getCategorieCreationDate() {
		return categorieCreationDate;
	}

	public void setCategorieCreationDate(Date categorieCreationDate) {
		this.categorieCreationDate = categorieCreationDate;
	}

	public Date getCategorieUpdateDate() {
		return categorieUpdateDate;
	}

	public void setCategorieUpdateDate(Date categorieUpdateDate) {
		this.categorieUpdateDate = categorieUpdateDate;
	}

	@JsonIgnore
	public Collection<Products> getProduct() {
		return product;
	}

	@JsonSetter
	public void setProduct(Collection<Products> product) {
		this.product = product;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Categories)) {
			return false;
		}
		Categories categorie = (Categories) o;
		return categorie.categorieId.equals(categorieId);
	}

}
