package com.noriand.api.v0.entity.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
