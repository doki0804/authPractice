package com.noriand.api.v0.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noriand.api.v0.entity.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
