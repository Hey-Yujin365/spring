package com.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.UserService;
import com.sample.vo.User;

public class App {

	public static void main(String[] args) {
		// 스프링 컨테이너 생성
		// connectionPool, JdbcTemplate, UserDao, UserService 객체가 생성되었다.
		// UserService <--- UserDao <--- JdbcTemplate <--- ConnectionPool이 조립이 완료된다. 의존성주입
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		
		UserService userService = ctx.getBean(UserService.class);
		userService.registerUser(new User("kang", "zxcv1234", "강감찬", "010-1111-2323", "kang@gmail.com"));
	}
}
