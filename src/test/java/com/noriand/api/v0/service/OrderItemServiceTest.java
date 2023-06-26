package com.noriand.api.v0.service;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.noriand.api.v0.dto.order.OrderItemDto;
import com.noriand.api.v0.serviceImpl.orderItemServiceImpl;

@SpringBootTest
public class OrderItemServiceTest {

	@Autowired
	OrderItemService orderItemService;
	
	@Transactional
	@Test
	void select() {
	}
}
