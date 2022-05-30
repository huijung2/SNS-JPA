package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 전체생성자
@NoArgsConstructor // 빈생성자
@Data
@Entity //DB에 테이블생성
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //번호증가 전략이 데이터베이스를 따라간다.
	private int id;
	
	private String username;
	private String password;
	
	private String name;
	private String website; // 웹사이트
	private String bio; //자기소개
	private String email;
	private String phone;
	private String gender;
	
	private String profileImageUrl; //사진
	private String role; //권한
	
	private LocalDateTime createDate;
	
	
	//자동으로 DB가 들어가게 함.
	@PrePersist // DB에 insert 되기 직전에 실행
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}

}