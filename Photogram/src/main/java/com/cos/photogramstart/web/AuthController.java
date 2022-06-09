package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final에 대한 모든 생성자를 만들어줌 final DI 할때 사용
@Controller //IoC, 파일을 리턴하는 컨트롤러
public class AuthController{

	private static final Logger log = LoggerFactory.getLogger(AuthController.class);


	private final AuthService authService;

	//	생성자
	//	public AuthController (AuthService authService) {
	//		this.authService = authService; //의존성주입 (없으면 주입 안함)
	//	}
	//	

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
	public String signup(SignupDto signupDto) {
		log.info(signupDto.toString());
		// DTO에서 지정한 toEntitiy가 넘어오도록 설정
		User user = signupDto.toEntitiy();
		User userEntity = authService.회원가입(user);
		System.out.println("sssssssssssss");
		return"auth/signin";
	}
}