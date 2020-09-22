package com.trend.trendyol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trend.trendyol.model.Product;

public interface ProductRepository  extends JpaRepository<Product, Long> {

}
