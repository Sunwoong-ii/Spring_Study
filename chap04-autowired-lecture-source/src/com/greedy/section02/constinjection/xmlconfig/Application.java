package com.greedy.section02.constinjection.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section02/constinjection/xmlconfig/config/spring-context.xml");
		
		MakeRandomString string = context.getBean(MakeRandomString.class);
		
		System.out.println(string.getRandomLengthString());
	}
}
