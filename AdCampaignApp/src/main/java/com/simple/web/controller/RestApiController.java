package com.simple.web.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simple.web.model.AdCampaign;
import com.simple.web.service.AdCampaignService;
import com.simple.web.util.CustomFaultType;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	AdCampaignService campaignService; 


	@RequestMapping(value = "/ad/{partnerId}", method = RequestMethod.GET)
	public ResponseEntity<?> fetchAdCampaign(@PathVariable("partnerId") String partnerId) {
		logger.info("Fetching ad with Partner Id {}", partnerId);
		AdCampaign adCampaign = campaignService.findActiveCampaignExist(partnerId);
		if (adCampaign == null || adCampaign.isExpired()) {
			logger.error("Ad Campaign with id {} is not found.", partnerId);
			return new ResponseEntity<>(new CustomFaultType("User with id " + partnerId 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AdCampaign>(adCampaign, HttpStatus.OK);
	}


	@RequestMapping(value = "/ad/", method = RequestMethod.POST)
	public ResponseEntity<?> createAdCampaign(@RequestBody AdCampaign adCampaign) {
		logger.info("Creating AD Campaign : {}", adCampaign);

		if (campaignService.isActiveStatus(adCampaign.getPartnerId())) {
			logger.error("Unable to create. Only one active campaign {} can exist", adCampaign.getPartnerId());
			return new ResponseEntity<>(new CustomFaultType("Unable to create. A Campaign with partner id " + 
					adCampaign.getPartnerId() + " already exist."), HttpStatus.CONFLICT);
		}
		campaignService.saveAdCampaign(adCampaign);

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/adAll/", method = RequestMethod.GET)
	public ResponseEntity<List<AdCampaign>> fetchAllAdCampaign() {
		List<AdCampaign> adCampaigns = campaignService.findAllAdCampaign();
		if (adCampaigns.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AdCampaign>>(adCampaigns, HttpStatus.OK);
	}


}