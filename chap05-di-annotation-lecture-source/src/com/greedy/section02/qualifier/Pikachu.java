package com.greedy.section02.qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Pikachu implements Poketmon{

	@Override
	public void attack() {
		System.out.println("백만볼트!!");
		
	}

}
