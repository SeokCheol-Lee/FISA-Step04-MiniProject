package service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import model.entity.Comment;

public class CommentService {
	
	public static HashMap<Integer,Comment> commentMap = new HashMap<>();
	private static CommentService instance = new CommentService();
	public static int count = 0;
	
	public static CommentService getInstance() {
		return instance;
	}
	
	public void createComment(int boardId, int userId, String context) {
		Comment comment = Comment.builder()
				.userId(userId)
				.boardId(boardId)
				.context(context)
				.build();
		commentMap.put(count++, comment);
	}
	
	public List<Comment> getCommentAll() {
		return commentMap.values().stream().collect(Collectors.toList());
	}
	
	public List<Comment> getCommmentListByUserId(int userId) {
		return commentMap.values().stream().filter(c -> c.getUserId() == userId)
                .collect(Collectors.toList());
	}
	
	public List<Comment> getCommmentListByUserIdInPage(int userId, int page) 
			throws IllegalAccessException {
		List<Comment> commentList = getCommmentListByUserId(userId);
		final int pageRange = 5;
		if(commentList.size() < page*pageRange) {
			throw new IllegalAccessException("옳지 않은 접근입니다.");
		}
		return commentList.stream().skip(page*pageRange).limit(pageRange)
				.collect(Collectors.toList());
	}
	
	public List<Comment> getCommentListByBoardId(int boardId) {
		return commentMap.values().stream().filter(c -> c.getUserId() == boardId)
                .collect(Collectors.toList());
	}
	
	public List<Comment> getCommentListByBoardIdInPage(int boardId, int page) 
			throws IllegalAccessException {
		List<Comment> commentList = getCommmentListByUserId(boardId);
		final int pageRange = 5;
		if(commentList.size() < page*pageRange) {
			throw new IllegalAccessException("옳지 않은 접근입니다.");
		}
		return commentList.stream().skip(page*pageRange).limit(pageRange)
				.collect(Collectors.toList());
	}
	
	public void updateCommentContext(int commentId, String context) {
		commentMap.get(commentId).setContext(context);
	}
	
	public void deleteComment(int commentId) {
		commentMap.remove(commentId);
	}
}
