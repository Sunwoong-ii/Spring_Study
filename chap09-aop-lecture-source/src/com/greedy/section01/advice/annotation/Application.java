package com.greedy.section01.advice.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.greedy.section01.advice.annotation.config.ContextConfiguration;

public class Application {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.greedy.section01.advice.annotation");
		
		Student normalStudent = context.getBean("normalStudent", Student.class);
		Student greedyStudent = context.getBean("greedyStudent", Student.class);
		
		System.out.println("========= NormalStudent ===========");
		AchievementResult normalResult = normalStudent.study(new Passion(10));
		
		System.out.println("NormalStudent Result : " + normalResult);
		
		
		System.out.println("========= GreedyStudent ===========");
		AchievementResult greedyResult = greedyStudent.study(new Passion(10));
		
		System.out.println("GreedyStudent Result : " + greedyResult);
		
	}

}
