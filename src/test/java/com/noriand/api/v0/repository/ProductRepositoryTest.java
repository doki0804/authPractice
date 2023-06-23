package com.noriand.api.v0.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.noriand.api.v0.entity.product.Product;

@SpringBootTest
class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void test() {
		Product product1 = productRepository.findById(16L).orElseThrow(null);
		Product product2 = new Product();
		product1 = productRepository.findById(16L).orElseThrow(null);
		
		if(product1 == product2) {
			System.out.println("같음");
		} else {
			System.out.println("다름");
		}
		
		
	}

}
