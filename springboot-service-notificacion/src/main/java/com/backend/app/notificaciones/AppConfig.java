package com.backend.app.notificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	
	@Bean("clientRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}