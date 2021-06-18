package com.greedy.section03.setterinjection.xmlconfig;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeRandomString {
	
	private RandomGenerator ramdom;
	
	public MakeRandomString() {}
	
	@Autowired
	public void setRandom(RandomGenerator random) {
		this.ramdom = random;
	}
	
	public String getRandomLengthString() {
		StringBuilder sb = new StringBuilder();
		
		int randomNumber = ramdom.getRandomNumber();
		for(int i = ramdom.getStartNum(); i <= randomNumber; i++) {
			sb.append("*");
		}
		return sb.toString();
			
	}
}
