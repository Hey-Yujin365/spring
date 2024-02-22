package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.UserDao;
import com.sample.vo.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void registerUser(User user) {
		User savedUser = userDao.getUserById(user.getId());
		if (savedUser != null) {
			throw new RuntimeException("["+user.getId()+"] 아이디가 이미 사용중입니다.");
		}
		userDao.insertUser(user);
	}
	
	public User getUserDetail(String id) {
		User savedUser = userDao.getUserById(id);
		if (savedUser == null) {
			throw new RuntimeException("["+id+"] 아이디에 해당하는 사용자정보를 찾을 수 없습니다.");
		}
		return savedUser;
	}
}
