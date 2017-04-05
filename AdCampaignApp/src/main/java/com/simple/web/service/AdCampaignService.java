package com.simple.web.service;



import java.util.List;

import com.simple.web.model.AdCampaign;

public interface AdCampaignService {
	
	AdCampaign findActiveCampaignExist(String id);
	
	boolean isActiveStatus(String id);
	
	void saveAdCampaign(AdCampaign adCampaign);
	
	List<AdCampaign> findAllAdCampaign();
	
	
}
