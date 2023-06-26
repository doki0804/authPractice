package com.noriand.api.v0.entity.assign;

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
@SequenceGenerator(name = "assign_id_SEQ_gen"	  	,
				   sequenceName = "assign_id_SEQ"	,
				   allocationSize = 1)
@Entity
@Table(name = "assign")
public class Assign {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assign_id_SEQ_gen")
	private Long id;
	
}
