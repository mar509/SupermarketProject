package com.supermarket.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comment")
public class Comment implements Serializable {
	@Id
	@Column(name = "idComment", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComment;
	
	@Column(name = "dateComment", unique = true)
	private Date dateComment;
	
	@Column(name = "dateComment", unique = true)
	private String textComment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CODE_PRODUCT_COMMENT")
	private Products product ;
	
	@ManyToOne
	@JoinColumn(name = "subComment")
	private Collection<Comment> subComment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_COMMENT")
	private User user ;
	
	public Long getIdComment() {
		return idComment;
	}

	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}

	public Date getDateComment() {
		return dateComment;
	}

	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}

	public String getTextComment() {
		return textComment;
	}

	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Collection<Comment> getSubComment() {
		return subComment;
	}

	public void setSubComment(Collection<Comment> subComment) {
		this.subComment = subComment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
 
	
}
