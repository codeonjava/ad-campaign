package com.simple.web.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.simple.web.model.AdCampaign;

public class AdCampaignServiceImplTest {
	
	@Mock
	private AdCampaignService adCampaignService;
	
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFindActiveCampaignExist(){
		adCampaignService.findActiveCampaignExist("Ruby");
	}
	
	@Test
	public void testSaveAdCampaign(){
		verify(adCampaignService, atLeast(0)).saveAdCampaign(getAdCampaign());
		
	}
	
	@Test
	public void testActiveStatus(){
		assertNotNull(getAdCampaign().getPartnerId());
		assertFalse(adCampaignService.isActiveStatus(getAdCampaign().getPartnerId()));
		assertFalse(adCampaignService.isActiveStatus(""));
		
		
	}
	
	private AdCampaign getAdCampaign(){
		AdCampaign adCampaign = new AdCampaign();
		adCampaign.setDuration(6000);
		adCampaign.setPartnerId("Ruby");
		adCampaign.setAdDisplayContents("Ad Content");
		return adCampaign;
		
	}

}
