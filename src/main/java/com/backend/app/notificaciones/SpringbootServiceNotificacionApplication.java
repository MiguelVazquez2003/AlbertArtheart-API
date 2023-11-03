package com.backend.app.notificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceNotificacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceNotificacionApplication.class, args);
	}

}
