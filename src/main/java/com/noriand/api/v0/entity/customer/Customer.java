package com.noriand.api.v0.entity.customer;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.noriand.api.v0.entity.order.Order;
import com.noriand.api.v0.entity.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@SequenceGenerator(name = "customer_SEQ_gen"	 ,
				   sequenceName = "customer_SEQ" ,
				   allocationSize = 1			 ,
				   initialValue = 1)
				   
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_SEQ_gen")
	private Long id;
	
	private String cName;
	
	private String cPhone;
	
	private String cAddress;
	
}
