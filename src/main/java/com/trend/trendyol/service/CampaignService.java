package com.trend.trendyol.service;

import java.util.List;

import com.trend.trendyol.model.Campaign;

public interface CampaignService {

	public List<Campaign> findAll();

	public Campaign getCampaign(Long id);

	public Campaign save(Campaign campaign);

	public String updateCampaign(Campaign campaign);

	public String deleteCampaign(Long id);

}
