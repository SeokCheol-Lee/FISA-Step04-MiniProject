package view;

import org.junit.Test;
import controller.BoardController;
import controller.CategoryServiceController;
import model.entity.Category;
import model.entity.Comment;
import service.CategoryService;
import service.CommentService;
public class TestView {
	
	@Test
	public void categoryTest() {
		BoardController controller = BoardController.getInstance();
		CategoryService categoryService = CategoryService.getInstance();
		CategoryServiceController categoryServiceController = CategoryServiceController.getInstance();
		CommentService commentService = CommentService.getInstance();
		
		
		
		
		
		categoryServiceController.createCategory("카테고리1");
		categoryServiceController.createCategory("카테고리2");
		categoryServiceController.createCategory("카테고리3");
		categoryServiceController.createCategory("카테고리4");
		categoryServiceController.createCategory("카테고리5");
		
		controller.createBoard(0, 1, 0, "a", "a", 0, null);
		controller.createBoard(1, 0, 0, "a", "a", 0, null);
		controller.createBoard(2, 0, 0, "a", "a", 0, null);
		controller.createBoard(3, 0, 0, "a", "a", 0, null);
		controller.createBoard(4, 0, 0, "a", "a", 0, null);
		controller.createBoard(5, 0, 0, "a", "a", 0, null);
		controller.createBoard(6, 0, 0, "a", "a", 0, null);
		
		commentService.createComment(2, 2, "근하하하하하");
		commentService.createComment(2, 2, "근하하하하하");
		commentService.createComment(2, 2, "근하하하하하");
		
		commentService.createComment(2, 2, "근하하하하하");
		commentService.createComment(2, 2, "근하하하하하");
		commentService.createComment(2, 2, "근하하하하하");
		commentService.createComment(2, 2, "근하하하하하");
		
		controller.getBoardListByPage(1);
		controller.getBoardDetail(2);
		
	}
	
	
}
