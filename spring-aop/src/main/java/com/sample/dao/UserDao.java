package com.sample.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sample.vo.User;

@Repository
public class UserDao {

	private Map<String, User> map = new HashMap<String, User>();
	
	public void insertUser(User user) {
		map.put(user.getId(), user);
	}
	
	public User getUserById(String id) {
		return map.get(id);
	}
	
	public void deleteUser(String id) {
		map.remove(id);
	}
}
