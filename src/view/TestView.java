package view;

import org.junit.Test;

import controller.BoardController;
import model.entity.Category;
import service.CategoryService;

public class TestView {
	
	@Test
	public void categoryTest() {
		BoardController controller = BoardController.getInstance();
		
		controller.createBoard(0, 0, 0, "a", "a", 0, null);
		controller.createBoard(1, 0, 0, "a", "a", 0, null);
		controller.createBoard(2, 0, 0, "a", "a", 0, null);
		controller.createBoard(3, 0, 0, "a", "a", 0, null);
		controller.createBoard(4, 0, 0, "a", "a", 0, null);
		controller.createBoard(5, 0, 0, "a", "a", 0, null);
		controller.createBoard(6, 0, 0, "a", "a", 0, null);
		
		controller.getBoardListByPage(1);
		controller.getBoardDetail(2);
		controller.getBoardDetail(2);
		controller.getBoardDetail(2);
		controller.getBoardDetail(2);
		
	}
	
	
}
