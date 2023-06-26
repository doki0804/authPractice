package com.noriand.api.v0.entity.product;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@SequenceGenerator(name = "product_SEQ_gen"		,
				   sequenceName = "product_SEQ" ,
				   allocationSize = 1			,
				   initialValue = 1)
				   
@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_SEQ_gen")
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
