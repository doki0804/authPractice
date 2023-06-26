package com.noriand.api.v0.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.noriand.api.v0.entity.customer.Customer;
import com.noriand.api.v0.entity.order.Order;
import com.noriand.api.v0.entity.product.Product;
import com.noriand.api.v0.repository.customer.CustomerRepository;
import com.noriand.api.v0.repository.order.OrderRepository;
import com.noriand.api.v0.repository.product.ProductRepository;

@SpringBootTest
class ProductRepositoryTest {
	
	private ProductRepository productRepository;
	private OrderRepository orderRepository;
	private CustomerRepository customerRepository;
	
	@Autowired
	public ProductRepositoryTest(ProductRepository productRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
	    this.productRepository = productRepository;
	    this.customerRepository = customerRepository;
	    this.orderRepository = orderRepository;
				
	}
	
	@Transactional
	@Test
	void test() {
//		Order order = orderRepository.findById(2L).orElseThrow(null);
//		System.out.println(order.toString());
		Customer customer = customerRepository.findById(1L).orElse(null);
//		Customer customer= Customer.builder().id(1L)
//				
//									.cName("테스트1")
//									.cPhone("010-0000-0001")
//									.cAddress("테스트1")
//									.build();
//		Customer customer2= Customer.builder()
//				.id(2L)
//				.cName("테스트2")
//				.cPhone("010-0000-0002")
//				.cAddress("테스트2")
//				.build();
//		Customer customer3= Customer.builder()
//				.id(3L)
//				.cName("테스트3")
//				.cPhone("010-0000-0003")
//				.cAddress("테스트3")
//				.build();
//		customerRepository.save(customer);
//		customerRepository.save(customer2);
//		customerRepository.save(customer3);
//		LocalDate date = LocalDate.now(); 
//		Order order1 = Order.builder().orderDate(null).orderState("y").customer(customer).build();
//		Order order2 = Order.builder().orderDate(null).orderState("y").customer(customer2).build();
//		Order order3 = Order.builder().orderDate(null).orderState("y").customer(customer3).build();
		
//		orderRepository.save(order1);
//		orderRepository.save(order2);
//		orderRepository.save(order3);
		
//		Product product = Product.builder().pName("테스트상품").pLotNum("s102039210").build(); 
//		
//		productRepository.save(product);
		
//		Product product = productRepository.findById(1L).orElseThrow(null);
//		System.out.println(product);
		
	}

}
