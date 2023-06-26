package com.noriand.api.v0.dto.product;

import java.time.LocalDateTime;

public class ProductDto {
	
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
