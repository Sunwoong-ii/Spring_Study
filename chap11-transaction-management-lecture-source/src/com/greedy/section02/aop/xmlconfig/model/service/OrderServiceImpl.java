package com.greedy.section02.aop.xmlconfig.model.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greedy.section02.aop.xmlconfig.model.dao.OrderMapper;
import com.greedy.section02.aop.xmlconfig.model.dto.OrderDTO;



@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private SqlSessionTemplate sqlSession;


	@Autowired
	public OrderServiceImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int registOrder(OrderDTO order) throws Exception {

		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		int orderResult = orderMapper.insertOrder(order);

		int orderMenuResult = 0;

		for (int i = 0; i < order.getMenuList().size(); i++) {
			orderMenuResult += orderMapper.insertOrderMenu(order.getMenuList().get(i));
		}

		int result = 0;
		if (orderResult > 0 && orderMenuResult == order.getMenuList().size()) {
			result = 1;
			
			throw new Exception("테스트를 위해 발생시미");
		}

		return result;
	}


}
