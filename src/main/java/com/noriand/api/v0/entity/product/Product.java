package com.noriand.api.v0.entity.product;

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

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@SequenceGenerator(name = "product_id_SEQ_gen"		,
				   sequenceName = "product_id_SEQ" ,
				   allocationSize = 1)
				   
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_SEQ_gen")
	private Long id;
	
	private String pName;
	
	private String pLotNum;
	
	//낱개수량
	private Integer pAmount;
	
	//단위
	private String pUnit;
	
	private Integer pPrice;
	
	private String pManufacturer;
	
	//제조일
	private LocalDateTime pCreatedDate;
	
	//유통기한
	private LocalDateTime pExpirationDate;
	
	//입고일 
	private LocalDateTime receiptDate;
	
	//상품위치
	private String pLoc;
}
