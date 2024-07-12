package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.entity.Category;

public class CategoryService {
	private static CategoryService instance = new CategoryService();
	
	private static HashMap<Integer, Category> categoryList = new HashMap<Integer, Category>();
	private static int counter =0;
	
	private CategoryService() {};
	public static CategoryService getInstance() {
		return instance;
	}
	
	/**
	 * createCategory(String name); 카테고리 만들기
	 * 
	 */
	
	public void createCategory(String name) {
		for(Category category : categoryList.values()) {
			if(category.getName().equals(name)) {
				// 같은 이름이 존재한다면 exception 발생
				throw new IllegalArgumentException("같은 이름의 카테고리가 존재합니다.");
			}
		}
		categoryList.put(counter++, new Category(name));
	}
	
	/**
	 * getCategoryAll(); 모든 카테고리 가져오기 
	 * 
	 */
	
	public List<Category> getCategoryAll() {
	    return new ArrayList<>(categoryList.values());
	}

	
	/**
	 * getCategoryById(int id); 카테고리 아이디로 찾기
	 */
	
	public Category getCategoryById(int id){
		Category category = categoryList.get(id);
		return category;
	}
	
	/**
	 * updateCategory(int id, String categoryName); 카테고리 이름 업데이트 
	 *
	 */
	public void updateCategory(int categoryId,String categoryName) {
		Category category = getCategoryById(categoryId);
		if(category!=null) {
			category.setName(categoryName);
		}
	}
	
	/**
	 * deleteCategory(String categoryName); 카테고리 삭제하기
	 * 
	 */
	
	public void deleteCategory(int categoryId) {
		categoryList.remove(categoryId);
	}
}
