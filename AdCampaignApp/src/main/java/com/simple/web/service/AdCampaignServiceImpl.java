package com.simple.web.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.simple.web.model.AdCampaign;



@Service("adCampaignService")
public class AdCampaignServiceImpl implements AdCampaignService{
	
	
	private static List<AdCampaign> adCampaigns;
	
	static{
		adCampaigns= adCampaignRecords();
	}

	
	public AdCampaign findActiveCampaignExist(String id) {
		for(AdCampaign adCampaign : adCampaigns){
			if(adCampaign.getPartnerId().equals(id)){
				Calendar currentTime = Calendar.getInstance();
				adCampaign.getTime().add(Calendar.MILLISECOND, adCampaign.getDuration());
				if(currentTime.compareTo(adCampaign.getTime()) > 0 ){
					adCampaign.setExpired(true);
				}
				return adCampaign;
			}
		}
		return null;
	}
	
	
	
	public void saveAdCampaign(AdCampaign adCampaign) {
		adCampaigns.add(adCampaign);
	}


	

	private static List<AdCampaign> adCampaignRecords(){
		List<AdCampaign> adCampaigns = new ArrayList<AdCampaign>();
		return adCampaigns;
	}



	@Override
	public boolean isActiveStatus(String partnerId) {
		if(findActiveCampaignExist(partnerId) != null){
			return findActiveCampaignExist(partnerId).isExpired();
		}
		return false;
	}
	
	public List<AdCampaign> findAllAdCampaign() {
		return adCampaigns;
	}

}
