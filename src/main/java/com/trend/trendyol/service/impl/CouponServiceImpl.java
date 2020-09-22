package com.trend.trendyol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trend.trendyol.model.Coupon;
import com.trend.trendyol.repository.CouponRepository;
import com.trend.trendyol.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService{

	@Autowired
	private CouponRepository couponRepository;
	
	@Override
	public List<Coupon> findAll() {
		return couponRepository.findAll();
	}

	@Override
	public Coupon getCoupon(Long id) {
		return couponRepository.findById(id).orElse(null);
	}

	@Override
	public Coupon save(Coupon campaign) {
		return couponRepository.save(campaign);
	}

	@Override
	public String updateCoupon(Coupon coupon) {
		Coupon couponOld = couponRepository.findById(coupon.getId()).orElse(null);
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
	public String deleteCoupon(Long id) {
		// TODO Auto-generated method stub
		Coupon coupon = couponRepository.findById(id).orElse(null);
		if (coupon != null) {
			couponRepository.delete(coupon);
			return "OK";

		} else {
			return "ERROR! ID NOT FOUND.";
		}
	}

}
