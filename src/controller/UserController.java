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

	private static UserController getUserController() {
		return userController;
	}

	public User getUserInfo(int userId) throws Exception {
		User user = userService.getUser(userId);

		return user;
	};

	public Integer createUser(String name, String email, GradeType gradeType) throws Exception {
		Integer id = userService.createUser(name, email, gradeType);

		return id;
	}

	public User updateUserName(int userId, String name) throws Exception {
		User updatedUser = userService.updateUserName(userId, name);

		return updatedUser;
	}

	public User updateUserEmail(int userId, String email) throws Exception {
		User updatedUser = userService.updateUserEmail(userId, email);

		return updatedUser;
	}

	public User updateUserGrade(int userId, GradeType gradeType) throws Exception {
		User updatedUser = userService.updateUserGrade(userId, gradeType);

		return updatedUser;
	}

	public Boolean deleteUser(int userId) throws Exception {
		Boolean result = userService.deleteUser(userId);

		return result;
	}
}
