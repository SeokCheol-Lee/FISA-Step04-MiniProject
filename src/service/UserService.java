package service;

import java.util.ArrayList;
import java.util.HashMap;

import model.GradeType;
import model.entity.User;

public class UserService {

	private static final UserService  userService = new UserService();
	private HashMap<Integer, User> userMap = new HashMap();
	private int userIdCount= 0;
	private UserService() {}
	
	
	public static UserService getUserServiceInstance() {
		return userService;
	}
	


	
	public int createUser(String name, String email, GradeType grade){
		/* 
		 * 같은 이름 , 이메일 의 유저가 있는지 확인 
		 * 
		 * 이미 존재하는 유저가 있다면 null 반환 
		 * 새로운 유저라면  User 객체 저장후 저장한 객체 반환
		 * 
		 * */

		if(isEnrollableUser(name, email).equals(false))throw new Exception("등록할 수 없는 이름 , 이메일 입니다.");
		User newUser = new User( name, email, grade);
		Integer userId = getUserIdCount();
		userMap.put(userId , newUser);
		 
		return userId;
	}
	
	public User getUser(Integer id) {
		User user =  userMap.get(id);
		
		// 유저가 존재하는 경우 User를 , 존재하지 않는다면 NUll 반환 
		if(user == null)throw new Exception("존재 하지 않는 유저입니다. ");
		return user ;
	}
	
	public User updateUserName(int userId, String userName) {
		// 유저존재 여부 , 유저 이름 확인 

		if(isValidUser(userId) && isValidName(userName) == false) throw new Exception("userId 혹은 email이 유효하지 않습니다."); 
		
		// user 이름 업데이트 
		User user = userMap.get(userId);
		user.setName(userName);
		
		return user;
		
	}
	
	public User updateUserEmail(int userId, String userEmail) {
		if(isValidUser(userId) && isValidEmail(userEmail) == false) throw new Exception("userId 혹은 email이 유효하지 않습니다."); 
		
		// user 이름 업데이트 
		User user = userMap.get(userId);
		user.setEmail(userEmail);
		
		return user;
	};
	
	public User updateUserGrade(int userId, GradeType grade) {
		if(isValidUser(userId) == false) throw new Exception("userId가 유효하지 않습니다."); 
		
		// user 이름 업데이트 
		User user = userMap.get(userId);
		user.setGrade(grade);
		
		return user;
	}
	
	public Boolean deleteUser(int id) {
		if(isValidUser(id) == false) throw new Exception("userId가 유효하지 않습니다."); 
		
		userMap.remove(id);
		
		return true;
	}
	
	
	
	private  Boolean isValidEmail(String email) {
		if(email == null || email.length() == 0)return false;
		return true;
	}
	
	private  Boolean isValidName(String name) {
		if(name == null || name.length() == 0)return false;
		return true;
	}
	
	private  Boolean isValidUser(int id) {
		// 유저를 저장하는 유저맵에 유저가 없는 경우.
		return userMap.get(id) != null ;
	}
	
	private int getUserIdCount() {
		return userIdCount++;
	}
	
	private  Boolean isEnrollableUser(String name ,String email ) {

		if(isValidEmail(email) && isValidName(name) != true) return false;

		ArrayList<User> userList = new ArrayList(userMap.values());
		
		for(User user : userList) {
			if(user.getName().equals(name) || user.getEmail().equals(email)) return false;
		}
		return true;
	}
}
