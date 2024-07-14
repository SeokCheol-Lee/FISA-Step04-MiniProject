package view;

import controller.BoardController;
import controller.CategoryServiceController;
import controller.UserController;
import service.UserService;

public class StartView {

	public static void main(String[] args) {
		CategoryServiceController controller = CategoryServiceController.getInstance();
		BoardController boardController = BoardController.getInstance();
		
		System.out.println("*** 01. 카테고리 생성 ***");
		controller.createCategory("카테고리1");
		controller.createCategory("카테고리2");
		controller.createCategory("카테고리3");
		controller.createCategory("카테고리4");
		controller.createCategory("카테고리5");
		System.out.println();
		
		System.out.println("*** 02. 모든 카테고리 검색 ***");
		controller.getAllCategoryList();
		System.out.println();

		
		System.out.println("*** 03. 카테고리 아이디로 검색 ***");
		System.out.print("검색 결과: ");
		controller.getCategory(2);
		System.out.println();
		
		System.out.print("검색 결과: ");
		controller.getCategory(7);
		System.out.println();

		
		System.out.println("*** 04. 카테고리 업데이트 ***");
		controller.updateCategory(2, "업데이트된 카테고리");
		System.out.print("업데이트 결과: ");
		controller.getCategory(2);
		System.out.println();

		
		System.out.println("*** 05. 카테고리 삭제 ***");
		controller.deleteCategory(2);
		System.out.println();

		
		System.out.println("*** 카테고리 결과 ***");
		controller.getAllCategoryList();

		// User 관련 View

		// Comment 관련 View

		// Board 관련 View
		System.out.println("*** Board 생성 ***");
		boardController.createBoard(0,1, "1번 게시물", "1번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "2번 게시물", "2번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "3번 게시물", "3번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "4번 게시물", "4번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "5번 게시물", "5번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "6번 게시물", "6번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "7번 게시물", "7번 게시물 입니다.", "ImageUrl");

		// 전체 게시물 페이지로 조회
		System.out.println("*** 1페이지 조회 ***");
		boardController.getBoardListByPage(1);

		System.out.println("*** 2페이지 조회 ***");
		boardController.getBoardListByPage(2);

		// 게시물 제목으로 조회
		System.out.println("*** 게시글 제목으로 조회 ***");
		boardController.getBoardByTitle("1번 게시물");

		// 게시물 id로 조회
		System.out.println("*** 게시글 id로 조회 ***");
		boardController.getBoardById(0);

		// 게시물 제목, 내용, 카테고리, img 수정
		System.out.println("*** 게시글 제목, 내용, 카테고리, img 수정 ***");
		boardController.putBoardName(0, "수정된 1번 게시물");
		boardController.putBoardContext(0,"수정된 1번 게시물 입니다.");
		boardController.putBoardCategory(0, 1);
		boardController.putBoardImg(0, "수정된 ImgURL");

		// 상세 게시물 보기
		System.out.println("*** 게시물 상세 조회 ***");
		boardController.getBoardDetail(0);

		// 게시물 삭제
		System.out.println("*** 게시물 삭제 ***");
		boardController.deleteBoard(0);

		// 삭제된 게시물 확인
		System.out.println("*** 삭제된 게시물 확인 ***");
		boardController.getBoardListByPage(1);
	}

}
