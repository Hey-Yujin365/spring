package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.UserDao;
import com.sample.vo.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void register(String id, String password, String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		
		userDao.insertUser(user);
	}
	
	public User getUser(String id) {
		User user = userDao.getUserById(id);
		if (user == null) {
			throw new IllegalArgumentException("["+id+"] 아이디에 해당하는 사용자 정보가 없습니다.");
		}
		return user;
	}
}
