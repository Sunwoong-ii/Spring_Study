package com.greedy.section01.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
/*
 * @Primary 어노테이션을 설정하면  @Autowired로 동일한 타입의 여러 빈을 찾게 되는 경우
 * 자동 연결을 우선 시 할 타입으로 설정하는 것이다.
 * 동일한 타입(Poketmon) 클래스 중 한 개만 @Primary 어노테이션 사용이 가능하다.
 */
public class Cobugi implements Poketmon{

	@Override
	public void attack() {
		System.out.println("하이드로펌프~!!!");
		
	}

}
