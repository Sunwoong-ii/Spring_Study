package com.greedy.section01.fieldinjection.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	
	public static void main(String[] args) {
		
		/*
		 * @AutoWired를 이용한 의존성 주입
		 * 
		 * 스프링 3.1이후 버전부터 어노테이션을 이용한 bean 생성 및 의존성 주입을 위한 어노테이션을 제공한다.
		 * 어노테이션 방식을 이용하면 지금까지 본 생성자 주입과 setter주입 외에필드 주입을 추가적으로 할 수 있다.
		 */
		ApplicationContext context = new AnnotationConfigApplicationContext("com.greedy.section01.fieldinjection.javaconfig");
		
		BookService service = (BookService)context.getBean("bookService");
//		BookService service = new BookService(new BookDAOImpl());
		
		for(BookDTO b : service.selectAllBooks()) {
			System.out.println(b);
		}
		
		System.out.println(service.searchBookBySequence(1));
		System.out.println(service.selectAllBooks());
	}

}
