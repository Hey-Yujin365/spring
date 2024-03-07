package com.example.web.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.UserService;
import com.example.vo.User;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	/*
	 * 요청방식
	 * 		GET
	 * 요청URL
	 * 		localhost/user/me
	 * 요청내용
	 * 		인증된 사용자의 상세정보 화면을 요청한다.
	 * 매개변수
	 * 		Principal
	 * 			인증 후 Authentication 객체가 전달된다.
	 * 		Model
	 * 			뷰에 전달할 값을 저장하는 객체가 전달된다.
	 * 처리내용
	 * 		1. 전달받은 인증 후 Authentication 객체에서 사용자 아이디를 조회한다.
	 * 			principal.getName()메소드는 인증된 사용자정보를 식별할 수 있는 값을 반환한다.(우리 애플리케이션에서는 사용자 아이디다.)
	 * 		2. userService에 getUser(String id) 메소드를 실행해서 사용자 상세정보를 조회한다.
	 * 		3. 모델객체에 조회된 사용자정보를 저장해서 JSP에 전달시킨다.
	 * 		4. "/WEB-INF/views/user/info.jsp"로 내부이동할 수 있도록 뷰페이지 이름을 반환한다.
	 */
	// 인증 안 된 사용자는 접근 할 수 없게 @PreAuthorize 어노테이션 부착
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/me")
	public String info(Principal principal, Model model) {
		//principal.getName()은 이름이 아니고 id다. username 즉 id를 가져오는 것
		User user = userService.getUser(principal.getName());
		model.addAttribute("user", user);
		
		return "user/info";
	}
}
