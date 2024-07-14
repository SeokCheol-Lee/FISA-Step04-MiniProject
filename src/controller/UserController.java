package controller;

import java.util.HashMap;

import model.GradeType;
import model.entity.User;
import service.UserService;

public class UserController {
	private static final UserController userController = new UserController();
	private UserService userService = UserService.getUserServiceInstance();

	private UserController() {
	}

	public static UserController getUserController() {
		return userController;
	}

	public User getUserInfo(int userId) throws Exception {
		// userId에 해당하는 유저 정보를 반환합니다. 
		return userService.getUser(userId);
	};

	public int createUser(String name, String email, GradeType gradeType) throws Exception {
		// 유저아이디를 반환합니다. 
		return userService.createUser(name, email, gradeType);
	}

	public User updateUserName(int userId, String name) throws Exception {
		// 이름이 업데이트된 유저정보를 반환합니다. 
		return userService.updateUserName(userId, name);

	}

	public User updateUserEmail(int userId, String email) throws Exception {
		// email이 업데이트된 유저정보를 반환합니다. 
		return userService.updateUserEmail(userId, email);
	}

	public User updateUserGrade(int userId, GradeType gradeType) throws Exception {
		// Grade가 업데이트된 유저정보를 반환합니다. 
		return userService.updateUserGrade(userId, gradeType);
	}

	public Boolean deleteUser(int userId) throws Exception {
		// User 삭제 성공 여부를 반환합니다. 
		return  userService.deleteUser(userId);
	}
}
