package com.greedy.section02.qualifier;

import org.springframework.stereotype.Component;

@Component
public class Piry implements Poketmon{

	@Override
	public void attack() {
		System.out.println("불꽃 발사~~~~");
		
	}

}
