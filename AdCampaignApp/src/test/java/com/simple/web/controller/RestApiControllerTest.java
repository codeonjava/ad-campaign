package com.simple.web.controller;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.simple.web.model.AdCampaign;
import com.simple.web.service.AdCampaignService;

public class RestApiControllerTest {
	
	
	@Mock
	private AdCampaignService adCampaignService;
	
	@InjectMocks
	private RestApiController restApiController;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetUser(){
		when(adCampaignService.findActiveCampaignExist("Ruby")).thenReturn(getAdCampaign());
		restApiController.fetchAdCampaign(getAdCampaign().getPartnerId());
	}
	
	@Test
	public void testCreateAdCampaign(){
		when(adCampaignService.isActiveStatus(getAdCampaign().getPartnerId())).thenReturn(anyBoolean());
		assertFalse(adCampaignService.isActiveStatus(getAdCampaign().getPartnerId()));
		restApiController.createAdCampaign(getAdCampaign());
		
	}
	
	
	
	private AdCampaign getAdCampaign(){
		AdCampaign adCampaign = new AdCampaign();
		adCampaign.setDuration(6000);
		adCampaign.setPartnerId("Ruby");
		adCampaign.setAdDisplayContents("Ad Content");
		return adCampaign;
		
	}
	
	

}
