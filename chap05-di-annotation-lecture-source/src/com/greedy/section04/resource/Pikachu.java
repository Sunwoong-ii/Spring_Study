package com.greedy.section04.resource;

import org.springframework.context.annotation.Primary;

import org.springframework.stereotype.Component;

//@Component
public class Pikachu implements Poketmon{

	@Override
	public void attack() {
		System.out.println("백만볼트!!");
		
	}

}
