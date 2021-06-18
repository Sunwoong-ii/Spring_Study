package com.greedy.section02.aop.xmlconfig.model.service;

import com.greedy.section02.aop.xmlconfig.model.dto.OrderDTO;


public interface OrderService {

	// 주문 등록하는 용도의 메소드
	int registOrder(OrderDTO order) throws Exception;

}
