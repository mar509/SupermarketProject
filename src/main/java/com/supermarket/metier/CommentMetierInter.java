package com.supermarket.metier;



import com.supermarket.entities.Comment;
import com.supermarket.entities.User;

public interface CommentMetierInter {
	Comment addcomment(Comment comment,Long idUser);
	void deleteComment(Long idComment,Long idUser);
	Comment updateComment(Comment comment , Long idUser);	
	Comment commentDateUserSetter(Comment comment, User user);
	boolean checkCommentWrittenByUser(Comment comment, User user);
	

}
