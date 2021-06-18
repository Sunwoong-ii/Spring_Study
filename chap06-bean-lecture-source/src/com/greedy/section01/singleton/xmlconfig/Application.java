package com.greedy.section01.singleton.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.greedy.section01.singleton.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section01/singleton/xmlconfig/config/spring-config.xml");
		
		
		String[] beanNames = context.getBeanDefinitionNames();
		
		for(String n : beanNames) {
			System.out.println(n);
		}
		
		/*
		 * 현재 빈 구성은 singleton으로 설정되어있다(기본값)
		 * singleton은 IoC컨테이너당 하나의 인스턴스만 생성한다.
		 * 
		 * singleton Ioc컨테이너당 빈 인스턴스 하나를 생성한다.
		 * prototype 요청할 때마다 빈 인스턴스를 새로 만든다.
		 * request HTTP 요청당 하나의 빈 인스턴스를 생성합니다. 웹 애플리케이션 컨텍스트에만 해당된다.
		 * session HTTP 세션당 빈 인스턴스 하나를 생성한다. 웹 애플리케이션 컨텍스트에만 해당된다
		 * globalSession 전역 HTTP세션당 빈 인스턴스 하나를 생성한다. 포털 애플리케이션 컨텍스트에만 해당된다.
		 */
		
		Product carpBread = context.getBean("carpBrad",Bread.class);
		Product milk = context.getBean("milk",Beverage.class);
		Product water = context.getBean("water",Beverage.class);
		
		ShoppingCart cart1 = context.getBean("cart",ShoppingCart.class);
		cart1.addItem(carpBread);
		cart1.addItem(milk);
		
		System.out.println(cart1.getItem());
		
		ShoppingCart cart2 = context.getBean("cart",ShoppingCart.class);
		cart2.addItem(water);
		System.out.println(cart2.getItem());
	}
}