package com.noriand.api.v0.repository;

import com.noriand.api.v0.entity.customer.Customer;
import com.noriand.api.v0.entity.order.OrderItem;
import com.noriand.api.v0.entity.product.Product;
import com.noriand.api.v0.repository.order.OrderItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
public class OrderItemRepositoryTest {

    @Autowired
    OrderItemRepository orderItemRepository;
    
    @Autowired
    private EntityManager entityManager;


    @Transactional
    @Test
    void select() {
//    	Product product = Product.builder().pAmount(20).pName("테스트상품6").receiptDate(LocalDateTime.now()).build();
//    	Customer customer = Customer.builder().cName("테스터4").build();
//    	OrderItem orderItem = OrderItem.builder().oiQty(1).customer(customer).product(product).build();
//    	orderItemRepository.save(orderItem);
//    	entityManager.flush();
        List<OrderItem> orderItemList = orderItemRepository.findOrderItemsByCustomerId(2L);
        for (OrderItem orderItem : orderItemList) {
			System.out.println(orderItem.getProduct().getPLoc());
		}
//    	List<OrderItem> allItemList = orderItemRepository.findAll();
//    	for (OrderItem orderItem : allItemList) {
//    		System.out.println("  :"+orderItem.getProduct().getPLoc());
//		}
    	
    }
}
