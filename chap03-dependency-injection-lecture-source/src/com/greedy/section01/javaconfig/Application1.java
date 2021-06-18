package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration;

public class Application1 {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		System.out.println(context.getBean(MemberDTO.class));
		
		System.out.println(context.getBean(Account.class));
		
		System.out.println(context.getBean("memberGenerator"));
		
		System.out.println(context.getBean(MemberDTO.class).getPersonalAccount().getBalance());
		
	}

}
