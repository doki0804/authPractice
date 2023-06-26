package com.noriand.api.v0.repository.order;

import com.noriand.api.v0.entity.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
	@Query("SELECT oi FROM OrderItem oi LEFT JOIN oi.orders c WHERE c.id = :ordersId")
	List<OrderItem> findOrderItemsByOrdersId(@Param("ordersId") Long ordersId);
	
	@Query("SELECT oi FROM OrderItem oi LEFT JOIN oi.customer c WHERE c.id = :customerId")
	List<OrderItem> findOrderItemsByCustomerId(@Param("customerId") Long customerId);
}
