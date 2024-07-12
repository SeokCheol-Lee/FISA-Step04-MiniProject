package view;

import java.util.List;

import model.entity.Category;
import model.entity.Comment;

public class EndView {

	/**
	 * 
	 * Category
	 */
	// 특정 카테고리
	public static void categoryView(Category category) {
		if(category!=null) {
			System.out.println(category.getName());
		}else {
			System.out.println("해당 카테고리가 존재하지 않습니다.");
		}
	}
	// 전체 카테고리
	public static void categoryListView(List<Category> list) {
		int idx = 0;
		for(Category category : list) {
			if(category!=null) {
				System.out.println("Category ["+(idx++)+"]: "+category.getName());
			}
		}
	}
	
	/**
	 * 
	 * Comment
	 */
	// 특정 코멘트
	public static void commentView(Comment comment) {
		if(comment!=null) {
			System.out.println(comment.getContext());
		}else {
			System.out.println("코멘트가 존재하지 않습니다.");
		}
	}
	
	// 전체 코멘트
	public static void commentListView(List<Comment> list) {
		int idx = 0;
		for(Comment comment : list) {
			if(comment!=null) {
				System.out.println("Comment ["+(idx++)+"]: "+comment.getContext());
			}
		}
	}
}
