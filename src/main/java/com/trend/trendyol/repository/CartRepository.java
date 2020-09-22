package com.trend.trendyol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trend.trendyol.model.Cart;

public interface CartRepository  extends JpaRepository<Cart, Long> {

}
