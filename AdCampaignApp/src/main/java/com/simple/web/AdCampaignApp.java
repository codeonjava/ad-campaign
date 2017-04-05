package com.simple.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author puru
 *
 */
@SpringBootApplication(scanBasePackages={"com.simple.web"})
public class AdCampaignApp {

        public static void main(String[] args) {
                SpringApplication.run(AdCampaignApp.class, args);
        }
}

