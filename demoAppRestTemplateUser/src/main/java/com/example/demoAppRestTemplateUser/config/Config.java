package com.example.demoAppRestTemplateUser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class Config {
	private static final String URI_User = "http://localhost:8080/api/user";
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory(URI_User);
		restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);
		return restTemplate;
	}

}
