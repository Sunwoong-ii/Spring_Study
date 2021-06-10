package com.greedy.section02.annotation;

public class Beverage extends Product{

	private int capcity;

	public Beverage() {}

	public Beverage(String name, int price, int capcity) {
		super(name, price);
		this.capcity = capcity;
	}

	public int getCapcity() {
		return capcity;
	}

	public void setCapcity(int capcity) {
		this.capcity = capcity;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + this.capcity;
	}
}
