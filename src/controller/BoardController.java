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

	// 페이지로 게시물 리스트 조회
	public void getBoardListByPage(int page) {
		EndView.boardListView(service.getBoardInPage(page));
	}

	// 제목으로 게시물 조회
	public void getBoardByTitle(String title) {
		EndView.searchedBoardView(service.getBoardByTitle(title));
	}

	// id로 게시물 조회
	public void getBoardById(int id) {
		EndView.searchedBoardView(service.getBoardById(id));
	}

	// 게시물 제목 수정
	public void putBoardName(int id, String name) {
		service.updateBoardName(id, name);
	}

	// 게시물 이미지 수정
	public void putBoardImg(int id, String imgURL) {
		service.updateImage(id, imgURL);
	}

	// 게시물 내용 수정
	public void putBoardContext(int id , String context){
		service.updateBoardContext(id, context);
	}

	// 게시물 카테고리 수정
	public void putBoardCategory(int id, int catId) {service.updateCategory(id, catId);}

	// 게시물 삭제
	public void deleteBoard(int id) {
		service.deleteBoard(id);
	}

	// 게시물 상세 조회
	public void getBoardDetail(int id) {
		service.addViewCount(service.getBoardById(id));
		EndView.boardDetailView(service.getBoardById(id), service.getBoardsComments(id), 
				categoryService.getCategoryById(id).getName()) ;
	}

	// 게시물 생성
	public void createBoard(int catId, int userId, String name, String context, String image) {
		service.createBoard(catId, userId, name, context, image);
	}
}
