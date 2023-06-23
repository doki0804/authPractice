package com.noriand.api.v0.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.noriand.api.v0.entity.product.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


}
