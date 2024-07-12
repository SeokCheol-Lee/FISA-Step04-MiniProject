package controller;

import service.BoardService;
import service.CategoryService;
import view.EndView;

public class BoardController {
	private static BoardController instance = new BoardController();
	private static BoardService service = BoardService.getInstance();
	private static CategoryService categoryService = CategoryService.getInstance();
	public static BoardController getInstance() {
		return instance;
	}
	
	public void getBoardListByPage(int page) {
		EndView.boardListView(service.getBoardInPage(page));
	}
	
	public void getBoardByTitle(String title) {
		EndView.searchedBoardView(service.getBoardByTitle(title));
	}
	
	public void getBoardById(int id) {
		EndView.searchedBoardView(service.getBoardById(id));
	}
	
	public void postBoardName(int id, String name) {
		service.updateBoardName(id, name);
	}
	
	public void postBoardImg(int id, String imgURL) {
		service.updateImage(id, imgURL);
	}
	
	public void postBoardContext(int id , String context){
		service.updateBoardContext(id, context);
	}
	
	public void deleteBoard(int id) {
		service.deleteBoard(id);
	}
	
	public void getBoardDetail(int id) {
		service.addViewCount(service.getBoardById(id));
		EndView.boardDetailView(service.getBoardById(id), service.getBoardsComments(id), 
				categoryService.getCategoryById(id).getName()) ;
		
	}
	
	public void createBoard(int boardId, int catId, int userId, String name, String context, int viewCount, String image) {
		service.createBoard(boardId, catId, userId, name, context, viewCount, image);
	}
}
