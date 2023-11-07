package com.backend.app.tienda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	
	@Bean("clientRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
