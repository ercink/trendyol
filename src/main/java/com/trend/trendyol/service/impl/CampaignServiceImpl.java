package com.trend.trendyol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trend.trendyol.model.Campaign;
import com.trend.trendyol.repository.CampaignRepository;
import com.trend.trendyol.service.CampaignService;

@Service
public class CampaignServiceImpl implements CampaignService {
	@Autowired
	private CampaignRepository campaignRepository;
	
	public void campaingServiceImpl() {
		
	}
	
	@Override
	public List<Campaign> findAll() {
		return campaignRepository.findAll();
	}

	@Override
	public Campaign getCampaign(Long id) {
		return campaignRepository.findById(id).orElse(null);
	}

	@Override
	public Campaign save(Campaign campaign) {
		// TODO Auto-generated method stub
		return campaignRepository.save(campaign);
	}

	@Override
	public String updateCampaign(Campaign campaign) {
		Campaign campaignOld = campaignRepository.findById(campaign.getId()).orElse(null);
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
	public String deleteCampaign(Long id) {
		// TODO Auto-generated method stub
		Campaign campaign = campaignRepository.findById(id).orElse(null);
		if (campaign != null) {
			campaignRepository.delete(campaign);
			return "OK";

		} else {
			return "ERROR! ID NOT FOUND.";
		}
	}
}
