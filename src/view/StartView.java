package view;

import java.util.List;

import controller.BoardController;
import controller.CategoryServiceController;
import controller.CommentController;
import controller.UserController;
import model.GradeType;
import model.entity.Comment;
import model.entity.User;
import service.CommentService;

public class StartView {

	public static void main(String[] args) throws Exception {
		CategoryServiceController controller = CategoryServiceController.getInstance();
		BoardController boardController = BoardController.getInstance();
		UserController userController = UserController.getUserController();
		CommentService commentService = new CommentService();
		CommentController commentController = new CommentController(commentService);
		

		System.out.println("====================");
		System.out.println("      CATEGORY      ");
		System.out.println("====================");
		System.out.println("01. 카테고리 생성");
		controller.createCategory("카테고리1");
		controller.createCategory("카테고리2");
		controller.createCategory("카테고리3");
		controller.createCategory("카테고리4");
		controller.createCategory("카테고리5");
		System.out.println();
		
		System.out.println("02. 모든 카테고리 검색");
		controller.getAllCategoryList();
		System.out.println();

		System.out.println("03. 카테고리 아이디로 검색");
		System.out.print("검색 결과: ");
		controller.getCategory(2);
		System.out.println();
		
		System.out.println("04. 카테고리 업데이트");
		controller.updateCategory(2, "업데이트된 카테고리");
		System.out.print("업데이트 결과: ");
		controller.getCategory(2);
		System.out.println();
		
		System.out.println("05. 카테고리 삭제");
		controller.deleteCategory(2);
		System.out.println("카테고리 결과");
		controller.getAllCategoryList();

		System.out.println();

		// User 관련 View
		System.out.println("================");
		System.out.println("      USER      ");
		System.out.println("================");

		// 01. User 생성
		System.out.println("01. User 생성");
		int userId = 0;
		try {
			userId = userController.createUser("김이름", "name@example.com", GradeType.NORMAL);
			System.out.println("Created User ID: " + userId);
		} catch (Exception e) {
			System.out.println("User 생성 중 오류 발생: " + e.getMessage());
		}
		System.out.println();

		// 02. User 정보 가져오기
		System.out.println("02. User 정보 가져오기");
		try {
			User user = userController.getUserInfo(userId);
			System.out.println("User Info: " + user);
		} catch (Exception e) {
			System.out.println("User 정보 가져오기 중 오류 발생: " + e.getMessage());
		}
		System.out.println();

		// 03. User 이름 업데이트
		System.out.println("03. User 이름 업데이트");
		try {
			User updatedUser = userController.updateUserName(userId, "김수정");
			System.out.println("Updated User Info: " + updatedUser);
		} catch (Exception e) {
			System.out.println("User 이름 업데이트 중 오류 발생: " + e.getMessage());
		}
		System.out.println();

		// 04. User 이메일 업데이트
		System.out.println("04. User 이메일 업데이트");
		try {
			User updatedUser = userController.updateUserEmail(userId, "updatedEmail@example.com");
			System.out.println("Updated User Info: " + updatedUser);
		} catch (Exception e) {
			System.out.println("User 이메일 업데이트 중 오류 발생: " + e.getMessage());
		}
		System.out.println();

		// 05. User 등급 업데이트
		System.out.println("05. User 등급 업데이트");
		try {
			User updatedUser = userController.updateUserGrade(userId, GradeType.VIP);
			System.out.println("Updated User Info: " + updatedUser);
		} catch (Exception e) {
			System.out.println("User 등급 업데이트 중 오류 발생: " + e.getMessage());
		}
		System.out.println();

		// 06. User 삭제
		System.out.println("06. User 삭제");
		try {
			Boolean deleteResult = userController.deleteUser(userId);
			System.out.println("User Deleted: " + deleteResult);
		} catch (Exception e) {
			System.out.println("User 삭제 중 오류 발생: " + e.getMessage());
		}
		System.out.println();

		// 07. 삭제된 User 정보 가져오기
		System.out.println("07. 삭제된 User 정보 가져오기");
		try {
			userController.getUserInfo(userId);
		} catch (Exception e) {
			System.out.println("Error fetching deleted user: " + e.getMessage());
		}
		System.out.println();

		System.out.println();
		System.out.println("====================");
		System.out.println("        BOARD       ");
		System.out.println("====================");

		// Board 관련 View
		System.out.println("01. Board 생성");
		boardController.createBoard(0,1, "1번 게시물", "1번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "2번 게시물", "2번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "3번 게시물", "3번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "4번 게시물", "4번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "5번 게시물", "5번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "6번 게시물", "6번 게시물 입니다.", "ImageUrl");
		boardController.createBoard(0,1, "7번 게시물", "7번 게시물 입니다.", "ImageUrl");
		System.out.println();


		//System.out.println("01. 코멘트 생성");
		commentController.writeComment(1, 1, "comment1");
		commentController.writeComment(1, 2, "comment2");
		commentController.writeComment(1, 1, "comment3");
		commentController.writeComment(1, 2, "comment4");
		commentController.writeComment(1, 1, "comment5");
		commentController.writeComment(1, 2, "comment6");
		commentController.writeComment(1, 1, "comment7");
		commentController.writeComment(1, 2, "comment8");
		commentController.writeComment(1, 1, "comment9");
		commentController.writeComment(1, 2, "comment10");
		commentController.writeComment(1, 1, "comment11");
		commentController.writeComment(1, 2, "comment12");
		commentController.writeComment(2, 1, "comment13");
		commentController.writeComment(2, 2, "comment14");

		// 전체 게시물 페이지로 조회
		System.out.println("02. 1페이지 조회");
		boardController.getBoardListByPage(1);
		System.out.println();


		System.out.println("03. 2페이지 조회");
		boardController.getBoardListByPage(2);
		System.out.println();

		// 게시물 제목으로 조회
		System.out.println("04. 게시글 제목으로 조회");
		boardController.getBoardByTitle("1번 게시물");
		System.out.println();

		// 게시물 id로 조회
		System.out.println("05. 게시글 id로 조회");
		boardController.getBoardById(0);
		System.out.println();

		// 게시물 제목, 내용, 카테고리, img 수정
		System.out.println("06. 게시글 제목, 내용, 카테고리, img 수정");
		boardController.putBoardName(0, "수정된 1번 게시물");
		boardController.putBoardContext(0,"수정된 1번 게시물 입니다.");
		boardController.putBoardCategory(0, 1);
		boardController.putBoardImg(0, "수정된 ImgURL");
		System.out.println();

		// 상세 게시물 보기
		System.out.println("07. 게시물 상세 조회");
		boardController.getBoardDetail(1);
		System.out.println();

		// 게시물 삭제
		System.out.println("08. 게시물 삭제");
		boardController.deleteBoard(0);
		System.out.println();

		// 삭제된 게시물 확인
		System.out.println("09. 삭제된 게시물 확인");
		boardController.getBoardListByPage(1);
		System.out.println();

		// Comment 관련 View
		System.out.println();
		System.out.println("====================");
		System.out.println("       COMMENT      ");
		System.out.println("====================");

		System.out.println("01. 모든 코멘트 가져오기");
		List<Comment> list = commentController.getCommentAll();
		System.out.println(list);
		System.out.println();

		System.out.println("02. 내 코멘트 가져오기");
		List<Comment> listMyComments = commentController.getMyComments(1);
		System.out.println(listMyComments);
		System.out.println();

		System.out.println("03. 페이지 내 모든 나의 코멘트 가져오기");
		List<Comment> listMyCommentsInPage = commentController.getMyCommentsByPage(1, 1);
		System.out.println(listMyCommentsInPage);
		System.out.println();

		System.out.println("04. 게시글 코멘트 가져오기");
		List<Comment> boardComment = commentController.getBoardComments(1);
		System.out.println(boardComment);
		System.out.println();

		System.out.println("05. 페이지 내 모든 게시글 코멘트 가져오기");
		List<Comment> boardCommentsInPage = commentController.getBoardCommentsByPage(1, 1);
		System.out.println(boardCommentsInPage);
		System.out.println();

		System.out.println("06. 코멘트 수정");
		commentController.editComment(1, "수정된 코멘트입니다.");
		System.out.println(commentController.getAComment(1));
		System.out.println();

		System.out.println("07. 코멘트 삭제");
		commentController.removeComment(1);
		List<Comment> listRemove = commentController.getCommentAll();
		System.out.println(listRemove + "\n");
		System.out.println();
	}
}
