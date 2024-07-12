package controller;

import service.CategoryService;
import view.EndView;

public class CategoryServiceController {
	private static CategoryServiceController instance = new CategoryServiceController();
	private static CategoryService service = CategoryService.getInstance();
	private CategoryServiceController() {};
	public static CategoryServiceController getInstance() {
		return instance;
	}
	
	/**
	 * 모든 카테고리 검색
	 */
	
	public void getAllCategoryList() {
		EndView.categoryListView(service.getCategoryAll());
	}
	
	/**
	 * 카테고리 아이디로 검색
	 */
	public void getCategory(int categoryId) {
		EndView.categoryView(service.getCategoryById(categoryId));
	}
	
	/**
	 * 새로운 카테고리 추가
	 */
	public void createCategory(String categoryName) {
		service.createCategory(categoryName);
	}
	
	/**
	 * 카테고리 이름 수정
	 */
	public void updateCategory(int categoryId, String categoryName) {
		service.updateCategory(categoryId, categoryName);
	}
	
	/**
	 * 카테고리 삭제
	 */
	public void deleteCategory(int categoryId) {
		service.deleteCategory(categoryId);
	}
}

