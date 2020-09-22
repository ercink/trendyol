package com.trend.trendyol.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.trend.trendyol.constant.ConditionOperand;
import com.trend.trendyol.constant.DiscountOperand;

@Entity
@Table(name = "campaign_tiers")
public class CampaignTier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	//private int campaignId;
	
	private ConditionOperand conditionOperand; // uygulanması için gereken operand (<, >, =)
	private float conditionValue; // operand da kullanılacak değer (100, 10)
	private DiscountOperand discountOperand; // uygulanacak indirim in operandı %,-
	private float discountValue; // indirim miktarı/oranı
	
	@ManyToOne
    @JoinColumn(name="campaing_id")
	private Campaign campaing;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Campaign getCampaing() {
		return campaing;
	}
	public void setCampaing(Campaign campaing) {
		this.campaing = campaing;
	}
	/*public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}*/
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
	
	
	
	
	
	
	
}
