package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.greedy.section01.advice.annotation.AchievementResult;

@Aspect
@Component
public class AfterReturningAttendingAdvice {
	
	/*
	 * returning 속성은 리턴값으로 받아올 오브젝트의 매개변수 이름과 동일해야 한다.
	 * 또한 joinPoint는 반드시 첫 번째 매개변수로 선언해야 한다.
	 */
	@AfterReturning(pointcut = "execution(* com.greedy.section01.advice.annotation..*(..))", returning = "result")
	public void atfetReturningAttending(JoinPoint joinPoint, Object result) {
		
		System.out.println("========== after returning attending ================");
		System.out.println("보람찬!! 하루일을! 끝마치고서~~~ 두 다리 쭉 펴면 고향의 안방으로~~~~~~");
		System.out.println("오늘의 이해도 : " + ((AchievementResult) result).getUnderstandingScore());
		System.out.println("오늘의 만족도 : " + ((AchievementResult) result).getSatisfactionScore());
		
		double employeementRate = ((AchievementResult) result).getEmployeementRate();
		double percent = employeementRate / 1000.0 * 100;
		System.out.println("증가된 취업율 : " + percent + "%");
		
		((AchievementResult) result).setEmployeementRate(percent);
	}
	

}
