package com.trend.trendyol.service;

import java.util.List;

import com.trend.trendyol.model.Coupon;

public interface CouponService {
	
	public List<Coupon> findAll();

	public Coupon save(Coupon coupon);

	public Coupon getCoupon(Long id);

	public String updateCoupon(Coupon coupon);

	public String deleteCoupon(Long id);

}
