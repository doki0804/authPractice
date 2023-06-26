package com.noriand.api.v0.dto.order;

import java.time.LocalDateTime;

public class OrderDto {

	private Long id;

	private Integer orderNumber;

	// 주문일자
	private LocalDateTime orderDate;

	// 주문상태
	private String orderState;

	// 받는사람
	private String recipient;

	// 배송지 우편번호
	private String shippingZipCode;

	// 배송지 주소
	private String shippingLoc;
}
