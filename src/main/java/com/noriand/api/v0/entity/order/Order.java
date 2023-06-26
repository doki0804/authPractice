package com.noriand.api.v0.entity.order;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@SequenceGenerator(name = "order_SEQ_gen"	  	,
				   sequenceName = "order_SEQ"	,
				   allocationSize = 1)
@Table(name = "orders")
@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_SEQ_gen")
	private Long id;
	
	private Integer orderNumber;
	
	//주문일자
	private LocalDateTime orderDate;
	
	//주문상태
	private String orderState;
	
	//받는사람
	private String recipient;
	
	//배송지 우편번호
	private String shippingZipCode;
	
	//배송지 주소
	private String shippingLoc;
		
}
