package com.greedy.section01.advice.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.greedy.section01.advice.annotation.GreedyStudent;

@Aspect
@Component
public class AroundAttendingAdvice {

	/*
	 * Around Advice는 가장 강력한 어드바이스이다.
	 * 이 어드바이스는 조인포인트를 완전히 장악하기 때문에
	 * 앞에 살펴 본 어드바이스 모두 Around 어드바이스로 조합할 수 있다.
	 * 심지어 원본 조인 포인트를 언제 실행할지, 실행 자체를 안할지, 계속 실행할지 여부까지도 제어한다.
	 * 
	 * AroundAdvice의 조인포인트 매개변수는 ProceedingJoinPoint로 고정되어 있다.
	 * JoinPoint의 하위 인터페이스로 원본 조인포인트의 진행 시점을 제어할 수 있다.
	 */
	
	//@Around("execution(* com.greedy.section01.advice.annotation..*(..))")
	@Around("studentAroundPointcut()")
	public Object aroundAttending(ProceedingJoinPoint JoinPoint) throws Throwable{

		System.out.println("============ around attending before ============");
		System.out.println("오늘도 학원에 가서 열심히 공부해야지!! 라는 마을을 가득 품고 아침~~일~~~찍 일어납니다.");
		System.out.println("=================================================");
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
//		원본 조인포인트를 실행한다.
		Object result = JoinPoint.proceed();
		
		System.out.println("============== around attending atfer============");
		
//		만약에 Greedy 학생이면 학원 문이 닫을 때 까지 열심히 스터디를 합니다.
		if(JoinPoint.getTarget() instanceof GreedyStudent) {
			System.out.println("그리디 학생~~~공부공부~~~");
		}
		
		stopWatch.stop();
		
		System.out.println("총 공부 소요 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");
		
		return result;
	}

//	포인트 컷은 void형 메소드로 작성하고 표현식을 작성한뒤 메소드 이름이 포인트컷의 이름이 된다.
	@Pointcut("execution(* com.greedy.section01.advice.annotation..*(..))")
	private void studentAroundPointcut() {
		
	}
	
}
