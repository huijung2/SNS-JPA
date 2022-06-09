package com.cos.photogramstart.web.dto.auth;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data //Getter, Setter를 만들어주는 어노테이션
public class SignupDto {
	private String username;
	private String password;
	private String email;
	private String name;
	
	public User toEntitiy() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}
}