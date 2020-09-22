package com.trend.trendyol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trend.trendyol.model.Coupon;

public interface CouponRepository  extends JpaRepository<Coupon, Long> {

}
