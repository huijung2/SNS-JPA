package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //IoC, 파일을 리턴하는 컨트롤러
public class AuthController{
	
	@GetMapping("/auth/signin")
	public String signinForm() {
		return"auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return"auth/signup";
	}
	
	// 회원가입버튼 -> .auth/signup -> /auth/signin
	@PostMapping("/auth/signup")
	public String signup() {
		return"auth/signin";
	}
}