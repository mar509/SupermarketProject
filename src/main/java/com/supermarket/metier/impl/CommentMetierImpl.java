package com.supermarket.metier.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.dao.CommentDao;
import com.supermarket.dao.UserDao;
import com.supermarket.entities.Comment;
import com.supermarket.entities.User;
import com.supermarket.metier.CommentMetierInter;

@Service
public class CommentMetierImpl implements CommentMetierInter {

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private UserDao userDao;

	@Override
	public Comment addcomment(Comment comment, Long idUser) {
		User user = userDao.findOne(idUser);
		comment = commentDateUserSetter(comment, user);
		return commentDao.save(comment);
	}

	@Override
	public void deleteComment(Long idComment, Long idUser) {
		User user = userDao.findOne(idUser);
		Comment comment = commentDao.findOne(idComment);
		if(checkCommentWrittenByUser(comment, user)){
			commentDao.delete(comment);			
		}

	}

	@Override
	public Comment updateComment(Comment comment, Long idUser) {
		User user = userDao.findOne(idUser);
		if(checkCommentWrittenByUser(comment, user))
			return commentDao.save(comment);			
	
		return (Comment) Optional.empty().orElse(null);
	}

	@Override
	public Comment commentDateUserSetter(Comment comment, User user) {
		comment.setUser(user);
		comment.setDateComment(new Date());
		return comment;
	}

	@Override
	public boolean checkCommentWrittenByUser(Comment comment, User user) {
		Collection<Comment> commentList = user.getComment();
		return commentList.stream().
				filter(cmt -> cmt.getIdComment() == comment.getIdComment()).
				findFirst().isPresent();
		
	}

}
