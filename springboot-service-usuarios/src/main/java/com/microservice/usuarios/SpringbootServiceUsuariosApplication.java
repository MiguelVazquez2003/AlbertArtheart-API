package com.microservice.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceUsuariosApplication.class, args);
	}

}
