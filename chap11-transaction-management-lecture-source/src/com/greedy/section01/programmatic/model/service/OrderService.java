package com.greedy.section01.programmatic.model.service;

import com.greedy.section01.programmatic.model.dto.OrderDTO;
import com.greedy.section01.programmatic.model.dto.OrderMenuDTO;

public interface OrderService {

	// 주문 등록하는 용도의 메소드
	int registOrder(OrderDTO order);

}
