package com.greedy.section03.collection;


import org.springframework.stereotype.Component;

@Component
public class Cobugi implements Poketmon{

	@Override
	public void attack() {
		System.out.println("하이드로펌프~!!!");
		
	}

}
