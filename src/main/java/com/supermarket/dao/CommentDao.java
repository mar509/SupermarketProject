package com.supermarket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supermarket.entities.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

}
