package com.supermarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.entities.Brand;
import com.supermarket.entities.User;

public interface UserDao extends JpaRepository<User, Long> {

}
