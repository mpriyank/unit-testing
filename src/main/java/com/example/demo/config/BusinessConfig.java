package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.business.ItemBusinessService;

@Configuration
public class BusinessConfig {
	
	@Bean
	ItemBusinessService businessService() {
		return new ItemBusinessService();
	}

}
