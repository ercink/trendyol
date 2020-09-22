package com.trend.trendyol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trend.trendyol.model.Campaign;
import com.trend.trendyol.service.CampaignService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class CampaignController {

	@Autowired
	private CampaignService campaingService;
//
//	@GetMapping("/campaings")
//	List<Campaign> all() {
//		return campaingService.findAll();
//	}
	
	// Get ALL Campaign
	@ApiOperation(value = "Get ALL Campaign")
	@RequestMapping(method = RequestMethod.GET, value = "/campaigns")
	public List<Campaign> all() {
		return campaingService.findAll();
	}

	// Get SINGLE Campaign
	@ApiOperation(value = "Get SINGLE Campaign")
	@RequestMapping(method = RequestMethod.GET, value = "/campaign/{id}")
	public Campaign getCampaign(@ApiParam(value = "Id of Campaign", required = true,example = "123") @PathVariable Long id) {
		return campaingService.getCampaign(id);
	}

	// POST for JSON ARRAY of Campaign
	@ApiOperation(value = "POST for JSON ARRAY of Campaign")
	@RequestMapping(method = RequestMethod.POST, value = "/campaign/bulk")
	public Campaign newCampaign(@RequestBody Campaign campaign) {
		return campaingService.save(campaign);
	}

	// UPDATE Campaign
	@ApiOperation(value = "UPDATE Campaign")
	@RequestMapping(method = RequestMethod.PUT, value = "/campaign")
	public String updateCampaign(@ApiParam(value = "Two rules apply here:\n\n1.) You have to enter Campaign id\n2.) Enter the title property with its updated value", required = true,example = "123") 
	@RequestBody Campaign campaign) {
		return campaingService.updateCampaign(campaign);
	}

	// DELETE Campaign
	@ApiOperation(value = "DELETE Campaign")
	@RequestMapping(method = RequestMethod.DELETE, value = "/campaign/{id}")
	public String deleteCampaign(@ApiParam(value = "Enter Campaign id to delete", required = true,example = "123") @PathVariable Long id) {
		return campaingService.deleteCampaign(id);
	}
}
