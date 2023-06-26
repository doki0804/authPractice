package com.noriand.api.v0.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noriand.api.v0.entity.order.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{
}
