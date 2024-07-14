package view;

import java.util.HashMap;
import java.util.List;

import model.entity.Board;
import model.entity.Category;
import model.entity.Comment;

public class EndView {

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
	
	public static void boardListView(HashMap<Integer, Board> resultBoardMap) {
		for (Board board : resultBoardMap.values()) {
            System.out.println(board);
        }
	}

	public static void searchedBoardView(Board board) {
		System.out.println(board);
	}
	
	public static void boardDetailView(Board board, List<Comment> comments, String categoryName) {
		
		System.out.println("작성자 : " + board.getUserId());
		System.out.println("__________________________");
		System.out.println("카테고리 : "+ categoryName);
		System.out.println("__________________________");
		System.out.println("제목 : " + board.getName());
		System.out.println("__________________________");		
		System.out.println("내용 : " + board.getContext());
		System.out.println("__________________________");	
		System.out.println("조회수 : " + board.getViewCount());
		System.out.println("__________________________");
		System.out.println("---------댓글 목록---------");
		System.out.println(comments);
		for (int i=0; i<comments.size(); i++) {
			Comment comment = comments.get(i); 
			System.out.println("user :" + comment.getUserId());
			System.out.println("내용 :" + comment.getContext());
			System.out.println("__________________________");
			
		}
		
	}
	
}
