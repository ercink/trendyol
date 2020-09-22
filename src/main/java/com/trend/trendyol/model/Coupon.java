package com.trend.trendyol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trend.trendyol.constant.ConditionOperand;
import com.trend.trendyol.constant.DiscountOperand;

@Entity
@Table(name = "coupons")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private DiscountOperand discountOperand; // uygulanacak indirim in operandı %,-
	private float discountValue; // indirim miktarı/oranı
	private ConditionOperand conditionOperand; // uygulanması için gereken operand (<, >, =)
	private float conditionValue; // operand da kullanılacak değer (100, 10)
	private String code;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DiscountOperand getDiscountOperand() {
		return discountOperand;
	}
	public void setDiscountOperand(DiscountOperand discountOperand) {
		this.discountOperand = discountOperand;
	}
	public float getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(float discountValue) {
		this.discountValue = discountValue;
	}
	public ConditionOperand getConditionOperand() {
		return conditionOperand;
	}
	public void setConditionOperand(ConditionOperand conditionOperand) {
		this.conditionOperand = conditionOperand;
	}
	public float getConditionValue() {
		return conditionValue;
	}
	public void setConditionValue(float conditionValue) {
		this.conditionValue = conditionValue;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
