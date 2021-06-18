package com.greedy.section01.javaconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.greedy.section01.javaconfig.Account;
import com.greedy.section01.javaconfig.MemberDTO;
import com.greedy.section01.javaconfig.PersonalAccount;

@Configuration
public class ContextConfiguration {

	@Bean
	public Account accountGenerator() {
		
		return new PersonalAccount(20, "110-123-45678", "1234", 50000);
	}
	
	@Bean
	public MemberDTO memberGenerator() {
		
		return new MemberDTO(1, "김선웅", "010-1234-1234", "sw6496@naver.com", accountGenerator());
	}
	
}
