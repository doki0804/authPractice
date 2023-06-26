package com.noriand.api.v0.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.noriand.api.v0.service.OrderItemService;

@RestController
public class OrderController {
	
	private final OrderItemService orderItemService;
	
	@Autowired
	public OrderController(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
	public ResponseEntity<?> pLocSerchByOrderId(Long OrderId) {
		
		return orderItemService.selectPLocByONo(OrderId);
	}
	
}
