package com.supermarket.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User {	
	@Id
	@Column(name="userId", unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;	
	
	@Column(name="username")
	private String username;
	
	@Column(name="userEmail")
	private String userEmail;
	
	@Column(name="userPassword")
	private String userPassword;	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private Comment comment;
	
	@OneToMany(mappedBy="USER_COMMENT",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Comment> comment;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Collection<Comment> getComment() {
		return comment;
	}

	public void setComment(Collection<Comment> comment) {
		this.comment = comment;
	}


	
	

}
