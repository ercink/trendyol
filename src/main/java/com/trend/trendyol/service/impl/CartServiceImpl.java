package com.trend.trendyol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trend.trendyol.model.Cart;
import com.trend.trendyol.repository.CartRepository;
import com.trend.trendyol.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	public void cartServiceImpl() {
		
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public Cart getCart(Long id) {
		return cartRepository.findById(id).orElse(null);
	}

	@Override
	public Cart save(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public String updateCart(Cart cart) {
		Cart cartOld = cartRepository.findById(cart.getId()).orElse(null);
		return null;

//		if (campaignOld != null) {
//			if (campaign.getTitle() != null) {
//				campaignOld.setTitle(campaign.getTitle());
//			}
//			campaignRepository.save(campaignOld);
//			return "OK";
//		} else {
//			return "ERROR! ID NOT FOUND ON DATABASE.";
//		}
	}

	@Override
	public String deleteCart(Long id) {
		// TODO Auto-generated method stub
		Cart cart = cartRepository.findById(id).orElse(null);
		if (cart != null) {
			cartRepository.delete(cart);
			return "OK";

		} else {
			return "ERROR! ID NOT FOUND.";
		}
	}

}
