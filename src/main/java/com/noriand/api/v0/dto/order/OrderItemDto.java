package com.noriand.api.v0.dto.order;

import java.time.LocalDateTime;

import com.noriand.api.v0.dto.customer.CustomerDto;
import com.noriand.api.v0.dto.product.ProductDto;

public class OrderItemDto {
	
	private Long id;

	private OrderDto order;

	private ProductDto product;

	private CustomerDto customer;
	
	// 상품수량
	private Integer oiQty;

	// 주문단위
	private String orderUnit;

	// 출고일
	private LocalDateTime shippingDate;

	// order item별 상태
	private String oiStatus;
}
