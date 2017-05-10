package com.supermarket.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Products")
public class Products {

	/* picture for the product */

	@Id
	@Column(name = "productId", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(name = "productName")
	private String productName;

	@Lob
	@Column(name = "productDescription")
	private String productDescription;

	@Column(name = "productPrice")
	private String productPrice;

	@Column(name = "productBuyDate")
	private Date productBuyDate;

	@Column(name = "productUpdateDate")
	private Date productUpdateDate;

	@Column(name = "productAddDate")
	private Date productAddDate;

	@Column(name = "productExpDate")
	private Date productExpDate;

	@Column(name = "productQte")
	private Long productQte;

	@Column(name = "productBarCode")
	private Long productBarCode;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="comite")
	private List<Comment> comment;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categories_Product")
	private Categories categories;

	public Date getProductUpdateDate() {
		return productUpdateDate;
	}

	public void setProductUpdateDate(Date productUpdateDate) {
		this.productUpdateDate = productUpdateDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductBuyDate() {
		return productBuyDate;
	}

	public void setProductBuyDate(Date productBuyDate) {
		this.productBuyDate = productBuyDate;
	}

	public Date getProductExpDate() {
		return productExpDate;
	}

	public void setProductExpDate(Date productExpDate) {
		this.productExpDate = productExpDate;
	}

	public Long getProductQte() {
		return productQte;
	}

	public void setProductQte(Long productQte) {
		this.productQte = productQte;
	}

	public Long getProductBarCode() {
		return productBarCode;
	}

	public void setProductBarCode(Long productBarCode) {
		this.productBarCode = productBarCode;
	}

	public Date getProductAddDate() {
		return productAddDate;
	}

	public void setProductAddDate(Date productAddDate) {
		this.productAddDate = productAddDate;
	}

	public Categories getCategories() {
		return categories;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Products)) {
			return false;
		}
		Products product = (Products) o;
		return product.productId.equals(productId);
	}

}
