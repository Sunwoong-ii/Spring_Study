package com.greedy.section01.primary;

import org.springframework.stereotype.Component;

@Component
public class Piry implements Poketmon{

	@Override
	public void attack() {
		System.out.println("불꽃 발사~~~~");
		
	}

}
