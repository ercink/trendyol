package com.trend.trendyol.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "campaigns")
public class Campaign {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@Column(name="category_id")
	//private int categoryId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private boolean isActive;
	private Long categoryRefId;
	
//	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="category_id")
	private Category category;
	
	@OneToMany(mappedBy = "campaing", cascade = CascadeType.ALL)
    private Set<CampaignTier> campaignTiers = new HashSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	/*public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}*/
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Set<CampaignTier> getCampaignTiers() {
		return campaignTiers;
	}
	public void setCampaignTiers(Set<CampaignTier> campaignTiers) {
		this.campaignTiers = campaignTiers;
	}
	public Long getCategoryRefId() {
		return categoryRefId;
	}
	public void setCategoryRefId(Long categoryRefId) {
		this.categoryRefId = categoryRefId;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
