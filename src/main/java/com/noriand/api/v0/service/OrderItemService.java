package com.noriand.api.v0.service;

import org.springframework.http.ResponseEntity;

import com.noriand.api.v0.dto.order.OrderItemDto;

public interface OrderItemService {
	
	OrderItemDto createOrderItem(OrderItemDto orderItemDto);
	
	ResponseEntity<?> selectPLocByONo(Long id);
}
