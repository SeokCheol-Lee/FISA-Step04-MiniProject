package view;

import java.util.List;

import model.entity.Category;

public class EndView {

	// 특정 카테고리
	public static void categoryView(Category category) {
		if(category!=null) {
			System.out.println(category.getName());
		}else {
			System.out.println("해당 카테고리가 존재하지 않습니다.");
		}
	}
	// 전체 카테고리
	public static void categoryListView(List<Category> list) {
		int idx = 0;
		for(Category category : list) {
			if(category!=null) {
				System.out.println("Category ["+(idx++)+"]: "+category.getName());
			}
		}
	}
}
