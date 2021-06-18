package com.greedy.section03.setterinjection.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section03.setterinjection.javaconfig.config.ContextConfiguration;


public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(String s : beanNames) {
			System.out.println(s);
		}
		
		MakeRandomString string = context.getBean(MakeRandomString.class);
		System.out.println(string.getRandomLengthString());
		System.out.println(string.getRandomLengthString());
		System.out.println(string.getRandomLengthString());
	}
}
