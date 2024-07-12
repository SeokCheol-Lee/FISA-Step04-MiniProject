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
	 * getCategoryByName(String name); 카테고리 이름으로 가져오기 
	 */
	
	public Category getCategoryByName(String name){
		for(Category category : categoryList.values()) {
			if(category.getName().equals(name)) {
				return category;
			}
		}
		return null;
	}
	
	/**
	 * updateCategory(String categoryName); 카테고리 이름 업데이트 
	 *
	 */
	public void updateCategory(String originalName,String categoryName) {
		Category category = getCategoryByName(originalName);
		if(category!=null) {
			category.setName(categoryName);
		}
	}
	
	/**
	 * deleteCategory(String categoryName); 카테고리 삭제하기
	 * 
	 */
	public void deleteCategory(String categoryName) {
		Category category = getCategoryByName(categoryName);
		if(category!=null) {
			categoryList.values().remove(category);
		}
	}
}
