package com.trend.trendyol.service;

import java.util.List;

import com.trend.trendyol.model.Cart;

public interface CartService {

	public List<Cart> findAll();

	public Cart getCart(Long id);

	public Cart save(Cart cart);

	public String updateCart(Cart cart);

	public String deleteCart(Long id);

}
