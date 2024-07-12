package view;

import model.entity.Category;
import service.CategoryService;

public class TestView {
	public static void main(String[] args) {
		CategoryService service = CategoryService.getInstance();
		
		service.createCategory("카테고리1");
		service.createCategory("카테고리2");
		service.createCategory("카테고리3");
		service.createCategory("카테고리4");
		service.createCategory("카테고리5");
		
		// getCategoryAll()
		
		System.out.println(service.getCategoryAll());
		
		// getCategoryName() 카테고리 이름으로 찾기
		System.out.println(service.getCategoryByName("카테고리3"));
		System.out.println(service.getCategoryByName("카테고리88"));
		
		// updateCategory() 카테고리 이름 변경
		service.updateCategory("카테고리1", "카테고리77");
		
		System.out.println(service.getCategoryAll());
		
		// deleteCategory() 카테고리 삭제
		service.deleteCategory("카테고리77");
		
		System.out.println(service.getCategoryAll());


		
	}
	
	
}
