package view;

import controller.CategoryServiceController;

public class StartView {

	public static void main(String[] args) {
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

}
