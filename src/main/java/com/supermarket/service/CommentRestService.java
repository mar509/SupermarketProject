package com.supermarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.entities.Comment;
import com.supermarket.metier.CommentMetierInter;

@RestController
public class CommentRestService {
	
	@Autowired
	private CommentMetierInter commentMetier ;

	@RequestMapping( value = "/comments/{idUser}", method = RequestMethod.POST)
	public Comment addcomment(@RequestBody Comment comment, @PathVariable Long idUser) {
		return commentMetier.addcomment(comment, idUser);
	}

	@RequestMapping( value = "/comments/{idUser}", method = RequestMethod.DELETE)
	public void deleteComment(@PathVariable Long idComment, @PathVariable Long idUser) {
		commentMetier.deleteComment(idComment, idUser);
	}

	@RequestMapping( value = "/comments/{idUser}", method = RequestMethod.PUT)
	public Comment updateComment( @RequestBody Comment comment, Long idUser) {
		return commentMetier.updateComment(comment, idUser);
	} 

}
