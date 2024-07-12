package view;

import java.util.List;

import controller.CategoryServiceController;
import controller.CommentController;
import model.entity.Comment;
import service.CommentService;

public class StartView {

	public static void comment() throws IllegalAccessException {
		CommentService commentService = new CommentService();
		CommentController commentController = new CommentController(commentService);

		System.out.println("[Comment] \n");

		System.out.println("*** 01. 코멘트 생성 ***");
		commentController.writeComment(1, 1, "comment1");
		commentController.writeComment(1, 2, "comment2");
		commentController.writeComment(1, 1, "comment1");
		commentController.writeComment(1, 2, "comment2");
		commentController.writeComment(1, 1, "comment1");
		commentController.writeComment(1, 2, "comment2");
		commentController.writeComment(1, 1, "comment1");
		commentController.writeComment(1, 2, "comment2");
		commentController.writeComment(1, 1, "comment1");
		commentController.writeComment(1, 2, "comment2");
		commentController.writeComment(1, 1, "comment1");
		commentController.writeComment(1, 2, "comment2");
		commentController.writeComment(2, 1, "comment6");
		commentController.writeComment(2, 2, "comment7");

		System.out.println("생성 완료 \n");

		System.out.println("*** 02. 모든 코멘트 가져오기 ***");
		List<Comment> list = commentController.getCommentAll();
		System.out.println(list + "\n");

		System.out.println("*** 03. 내 코멘트 가져오기 ***");
		List<Comment> listMyComments = commentController.getMyComments(1);
		System.out.println(listMyComments + "\n");

		System.out.println("*** 04. 페이지 내 모든 나의 코멘트 가져오기 ***");
		List<Comment> listMyCommentsInPage = commentController.getMyCommentsByPage(1, 1);
		System.out.println(listMyCommentsInPage + "\n");

		System.out.println("*** 05. 게시글 코멘트 가져오기 ***");
		List<Comment> boardComment = commentController.getBoardComments(1);
		System.out.println(boardComment + "\n");

		System.out.println("*** 06. 페이지 내 모든 게시글 코멘트 가져오기 ***");
		List<Comment> boardCommentsInPage = commentController.getBoardCommentsByPage(1, 1);
		System.out.println(boardCommentsInPage + "\n");

		System.out.println("*** 07. 코멘트 수정 ***");
		commentController.editComment(1, "수정된 코멘트입니다.");
		List<Comment> listEdit = commentController.getCommentAll();
		System.out.println(listEdit + "\n");

		System.out.println("*** 08. 코멘트 삭제 ***");
		commentController.removeComment(1);
		List<Comment> listRemove = commentController.getCommentAll();
		System.out.println(listRemove + "\n");

	}

	public static void category() {
		System.out.println("[Category] \n");
		CategoryServiceController controller = CategoryServiceController.getInstance();

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
	}

	public static void main(String[] args) throws IllegalAccessException {
		comment();
		category();
	}

}
