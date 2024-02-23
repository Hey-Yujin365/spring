package com.sample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sample.vo.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate template;
	
	public void insertUser(User user) {
		String sql = "insert into sample_users values(?, ?, ?, ?, ?)";
		template.update(sql, user.getId(), user.getPassword(), user.getName(), user.getTel(), user.getEmail());
	}
	
	public void deleteUser(String id) {
		String sql = "delete from sample_users where user_id = ?";
		template.update(sql, id);
	}
	
	public void updateUser(User user) {
		String sql = "update sample_users set user_password = ?, user_tel = ?, user_email = ? where user_id = ?";
		template.update(sql, user.getPassword(), user.getTel(), user.getEmail(), user.getId());
	}
	
	public List<User> getAllUser() {
		return null;
	}
	
	public User getUserById(String id) {
		String sql = "select * from sample_users where user_id = ?";
		
		return template.queryForObject(sql, (rs, rownum) -> {
			User user = new User();
			user.setId(rs.getString("user_id"));
			user.setPassword(rs.getString("user_password"));
			user.setName(rs.getString("user_name"));
			user.setTel(rs.getString("user_tel"));
			user.setEmail(rs.getString("user_email"));
			return user;
		}, id);
	}
}
