package cn.edu.bjtu.weibo.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.bjtu.weibo.dao.impl.UserDAOImpl;
import cn.edu.bjtu.weibo.model.User;
import cn.edu.bjtu.weibo.service.FollowingUsersService;



public class FollowingUsersServiceImpl implements FollowingUsersService{

	
	public List<String>getFollowingUserIdList(String userId, int pageIndex, int numberPerPage){
		UserDAOImpl user = new UserDAOImpl();
		ArrayList<String> userIdList = (ArrayList<String>)user.getFollowing(userId, pageIndex, numberPerPage);
		return userIdList;
	}
	
	
	public List<User> getFollowingUserList(String userId, int pageIndex,
			int numberPerPage) {
		UserDAOImpl user = new UserDAOImpl();
		ArrayList<String> userIdList = (ArrayList<String>)user.getFollowing(userId, pageIndex, numberPerPage); 
		ArrayList<User> userList = new ArrayList<User>();
		for(int i = 0;i< userIdList.size();i++){
			User user1 = new User();
			user1.setName(user.getUserName(userIdList.get(i)));
			user1.setAge(user.getUserAge(userIdList.get(i)));
			user1.setBirthday(user.getBirthday(userIdList.get(i)));
			user1.setEducation(user.getUserEducation(userIdList.get(i)));
			user1.setEmail(user.getUserEmail(userIdList.get(i)));
			user1.setIntroduction(user.getUserIntroduction(userIdList.get(i)));
			user1.setPhone(user.getUserPhoneNumber(userIdList.get(i)));
			user1.setSex(user.getSex(userIdList.get(i)));
			user1.setLocation(user.getLocation(userIdList.get(i)));
			user1.setQq(user.getUserQQ(userIdList.get(i)));
			
			userList.add(user1);
		}
		
		return userList;
	}
	
}
