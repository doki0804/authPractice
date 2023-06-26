package com.noriand.api.v0.entity.order;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.noriand.api.v0.entity.customer.Customer;
import com.noriand.api.v0.entity.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SequenceGenerator(name = "OrderItem_id_SEQ_gen"    ,
				   sequenceName = "OrderItem_id_SEQ",
				   allocationSize = 1)
@Entity
@Table(name = "order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderItem_id_SEQ_gen")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "orders_id")
	private Orders orders;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	// 상품수량
	private Integer oiQty;

	// 주문단위
	private String orderUnit;

	// 출고일
	private LocalDateTime shippingDate;

	// order item별 상태
	private String oiStatus;

}
