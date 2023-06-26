package com.noriand.api.v0.entity.customer;

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
@SequenceGenerator(name = "customer_id_SEQ_gen"	 ,
				   sequenceName = "customer_id_SEQ" ,
				   allocationSize = 1)

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_SEQ_gen")
	private Long id;
	
	private String cName;
	
	private String cPhone;
	
	private String cAddress;
	
}
