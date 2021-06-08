package com.greedy.section02.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application2 {
	
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("com/greedy/section02/xmlconfig/config/spring-context2.xml");
		
		System.out.println(context);
		
		/*
		 * bean으로 등록된 name들을 전부 확인할 때 사용하는 메소드 Processor와 이벤트리스터, 설정클래스가 빈으로 등록된 것을 확인할
		 * 수 있다.
		 */
		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println("beanName : " + beanName);
		}
		
		MemberDAO memberDAO = context.getBean(MemberDAO.class);
		
		System.out.println(memberDAO.selectMember(1));
		System.out.println(memberDAO.insertMember(new MemberDTO(4, "user03", "pass03", "새로운멤버")));
		System.out.println(memberDAO.selectMember(4));
		
	}

}
