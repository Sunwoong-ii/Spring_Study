package com.greedy.section02.aop.javaconfig.model.service;

import java.sql.SQLException;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.greedy.section02.aop.javaconfig.model.dao.OrderMapper;
import com.greedy.section02.aop.javaconfig.model.dto.OrderDTO;
import com.greedy.section02.aop.javaconfig.model.dto.OrderMenuDTO;


@Service("orderService")
public class OrderServiceImpl implements OrderService {

	private SqlSessionTemplate sqlSession;


	@Autowired
	public OrderServiceImpl(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	/*
	 * class 레벨에서 작성하면 모든 public 메소드에 적용된다.
	 * 메소드 레벨에는 어노테이션 작성된 메소드만 트랜잭션 처리를 한다.
	 */
//	propagation = 트랜잭션 생성(전파행위), isolation=격리행위(동시성 고려)
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE,
				rollbackFor = {Exception.class})
	public int registOrder(OrderDTO order) {

		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		int orderResult = orderMapper.insertOrder(order);

		int orderMenuResult = 0;

		for (int i = 0; i < order.getMenuList().size(); i++) {
			orderMenuResult += orderMapper.insertOrderMenu(order.getMenuList().get(i));
		}

		int result = 0;
		if (orderResult > 0 && orderMenuResult == order.getMenuList().size()) {
			result = 1;
		}

		return result;
	}


}
