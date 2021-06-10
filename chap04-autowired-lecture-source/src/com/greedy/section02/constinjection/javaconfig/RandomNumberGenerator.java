package com.greedy.section02.constinjection.javaconfig;

// 인스턴스 생성시 범위 값을 입력 받아 랜덤한 수를 리턴해주는 용도의 클래스
public class RandomNumberGenerator implements RandomGenerator{

	private int startNum;
	private int endNum;
	
	public RandomNumberGenerator(int startNum, int endNum) throws Exception {
		if(startNum > endNum) {
			throw new Exception("시작값이 종료 값보다 클 수 없습니다.");
		} else if(startNum <= 0 || endNum <= 0){
			throw new Exception("양의 정수만 입력해 주세요.");
		} else {
			this.startNum = startNum;
			this.endNum = endNum;
		}
	}

	@Override
	public int getRandomNumber() {
		return (int)(Math.random() * (endNum - startNum + 1)) + startNum;
	}

	@Override
	public int getStartNum() {
		return startNum;
	}

	@Override
	public int getEndNum() {
		return endNum;
	}
	

}
