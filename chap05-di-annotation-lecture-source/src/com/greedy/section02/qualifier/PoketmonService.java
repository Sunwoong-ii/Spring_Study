package com.greedy.section02.qualifier;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PoketmonService {

	
	/*
	 * 1. List 타입으로 주입 받기
	 * List 타입으로 하나의 타입인 번들을 한번에 주입할 수 있다.
	 * 순서는 bean의 클래스명 영어 알파벳 사전순이다.
	 */
//	@Autowired
//	private List<Poketmon> poketmon;
//	
//	public PoketmonService(List<Poketmon> poketmon) {
//		this.poketmon = poketmon;
//	}
//
//	public void poketmonAttack() {
//		for(Poketmon p : poketmon) {
//			p.attack();
//		}
//	}
	
	/*
	 * 2. Map 타입으로 주입받기
	 */
	
	private Map<String, Poketmon> poketmonMap;

	@Autowired
	public PoketmonService(Map<String, Poketmon> poketmonMap) {
		super();
		this.poketmonMap = poketmonMap;
	}
	
	public void poketmonAttack() {
		
		Iterator<String> iter = poketmonMap.keySet().iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key);
			poketmonMap.get(key).attack();
		}
	}
	
	
	
	
	
	

}
