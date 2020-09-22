package com.trend.trendyol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trend.trendyol.model.Campaign;

public interface CampaignRepository  extends JpaRepository<Campaign, Long> {

}
