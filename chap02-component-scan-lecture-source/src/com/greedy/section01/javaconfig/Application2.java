package com.greedy.section01.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.javaconfig.config.ContextConfiguration2;

public class Application2 {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration2.class);
		
		System.out.println(context);
		
		String[] beanNames = context.getBeanDefinitionNames();
		
		for(String name : beanNames) {
			System.out.println(name);
		}
		
	}

}
