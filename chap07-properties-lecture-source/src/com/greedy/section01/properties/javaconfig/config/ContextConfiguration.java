package com.greedy.section01.properties.javaconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.greedy.section01.properties.javaconfig.Beverage;
import com.greedy.section01.properties.javaconfig.Bread;
import com.greedy.section01.properties.javaconfig.Product;
import com.greedy.section01.properties.javaconfig.ShoppingCart;


@Configuration
@PropertySource("product-info.properties")
public class ContextConfiguration {
	
	/*
	 * 치환자(placeholder) 문법을 이용하여 properties에 저장된 key를 입력하면 value에 해당하는 값을 꺼내온다.
	 * 공백을 사용하면 값을 읽어오지 못하니 주의할 것
	 * 
	 * : 뒤의 값은 값을 읽어오지 못하는 경우 사용할 대체값을 입력하면 된다.
	 */
	@Value("${bread.carpbrad.name:대체빵}")
	private String carpBreadName;
	@Value("${bread.carpbrad.price:10000000}")
	private int carpBreadPrice;
	
	@Value("${beverage.milk.price:700}")
	private int milkPrice;
	@Value("${beverage.milk.name:딸기우유}")
	private String milkName;
	@Value("${beverage.milk.capacity:1000}")
	private int milkCapacity;
	
	@Value("${beverage.water.price:7800}")
	private int waterPrice;
	@Value("${beverage.water.capacity:1000987}")
	private int waterCapacity;
	
	@Bean
	public Product carpBrad() {
		return new Bread(carpBreadName,carpBreadPrice,new java.util.Date());
	}
	
	@Bean
	public Product milk() {
		return new Beverage(milkName, milkPrice, milkCapacity);
	}
	
	@Bean
	public Product water(@Value("${beverage.milk.name:초코와타}") String waterName
			, @Value("${beverage.water.price:7800}") int waterPrice) {
		return new Beverage(waterName, waterPrice, waterCapacity);
	}
	
	@Bean
	@Scope("prototype") //기본값
	public ShoppingCart cart() {
		return new ShoppingCart();
	}
	
}
