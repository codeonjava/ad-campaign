package com.simple.web;
 
import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.simple.web.model.AdCampaign;
 

public class AdCampaignTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8080/AdCampaign/api";
     
    /**
     * Fetch Ad Campaign using GET 
     */
    private static void getAdCampaign(){
        System.out.println("Getting Ad Campaign");
        RestTemplate restTemplate = new RestTemplate();
        AdCampaign adCampaign = restTemplate.getForObject(REST_SERVICE_URI+"/ad/Ruby", AdCampaign.class);
        System.out.println(adCampaign);
    }
     
    /**
     * Create Ad Campaign using POST
     */
    private static void createUser() {
        System.out.println("Creating Ad Campaign");
        RestTemplate restTemplate = new RestTemplate();
        AdCampaign adCampaign = new AdCampaign("Ruby",6000, "Content of Ad Campaign");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/ad/", adCampaign, AdCampaign.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
 
    public static void main(String args[]){
    	getAdCampaign();
        createUser();
    }
}