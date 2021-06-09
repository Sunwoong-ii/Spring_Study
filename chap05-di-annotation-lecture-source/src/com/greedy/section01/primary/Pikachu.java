package com.greedy.section01.primary;

import org.springframework.stereotype.Component;

@Component
public class Pikachu implements Poketmon{

	@Override
	public void attack() {
		System.out.println("백만볼트!!");
		
	}

}
