package com.greedy.section02.annotation.config;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.greedy.section02.annotation.Beverage;
import com.greedy.section02.annotation.Bread;
import com.greedy.section02.annotation.Owner;
import com.greedy.section02.annotation.Product;
import com.greedy.section02.annotation.ShoppingCart;


@Configuration
public class ContextConfiguration {
	
	@Bean
	public Product carpBrad() {
		return new Bread("메론빵",1000,new java.util.Date());
	}
	
	@Bean
	public Product milk() {
		return new Beverage("초코우유", 1500, 500);
	}
	
	@Bean
	public Product water() {
		return new Beverage("지리산암반수",3000,500);
	}
	
	@Bean
	@Scope("prototype") //기본값
	public ShoppingCart cart() {
		return new ShoppingCart();
	}
	
	
	
	
}
