package com.trend.trendyol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trend.trendyol.model.Coupon;
import com.trend.trendyol.service.CouponService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class CouponController {

	@Autowired
	private CouponService couponService;

	// Get ALL Coupon
	@ApiOperation(value = "Get ALL Coupon")
	@RequestMapping(method = RequestMethod.GET, value = "/coupons")
	public List<Coupon> all() {
		return couponService.findAll();
	}

	// Get SINGLE Coupon
	@ApiOperation(value = "Get SINGLE Coupon")
	@RequestMapping(method = RequestMethod.GET, value = "/coupon/{id}")
	public Coupon getCoupon(@ApiParam(value = "Id of Coupon", required = true,example = "123") @PathVariable Long id) {
		return couponService.getCoupon(id);
	}

	// POST for JSON ARRAY of Coupon
	@ApiOperation(value = "POST for JSON ARRAY of Coupon")
	@RequestMapping(method = RequestMethod.POST, value = "/coupon/bulk")
	public Coupon newCoupon(@RequestBody Coupon coupon) {
		return couponService.save(coupon);
	}

	// UPDATE Coupon
	@ApiOperation(value = "UPDATE Coupon")
	@RequestMapping(method = RequestMethod.PUT, value = "/coupon")
	public String updateCoupon(@ApiParam(value = "Two rules apply here:\n\n1.) You have to enter Coupon id\n2.) Enter the title property with its updated value", required = true, example = "123") 
	@RequestBody Coupon coupon) {
		return couponService.updateCoupon(coupon);
	}

	// DELETE Coupon
	@ApiOperation(value = "DELETE Coupon")
	@RequestMapping(method = RequestMethod.DELETE, value = "/coupon/{id}")
	public String deleteCoupon(@ApiParam(value = "Enter Coupon id to delete", required = true,example = "123") @PathVariable Long id) {
		return couponService.deleteCoupon(id);
	}
}
