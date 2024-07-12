package controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import model.entity.Comment;
import service.CommentService;

@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;
	
	public void writeComment(int boardId, int userId, String context) {
		commentService.createComment(boardId, userId, context);
	}
	
	public List<Comment> getCommentAll(){
		return commentService.getCommentAll();
	}
	
	public List<Comment> getMyComments(int userId){
		return commentService.getCommentListByBoardId(userId);
	}
	
	public List<Comment> getMyCommentsByPage(int userId, int page) throws IllegalAccessException{
		return commentService.getCommentListByBoardIdInPage(userId, page);
	}
	
	public List<Comment> getBoardComments(int boardId){
		return commentService.getCommentListByBoardId(boardId);
	}
	
	public List<Comment> getBoardCommentsByPage(int boardId, int page) throws IllegalAccessException{
		return commentService.getCommentListByBoardIdInPage(boardId, page);
	}
	
	public void editComment(int commentId, String context) {
		commentService.updateCommentContext(commentId, context);
	}
	
	public void removeComment(int commentId) {
		commentService.deleteComment(commentId);
	}
}
