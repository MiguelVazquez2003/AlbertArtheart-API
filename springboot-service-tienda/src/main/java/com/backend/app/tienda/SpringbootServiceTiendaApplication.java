package com.backend.app.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients

public class SpringbootServiceTiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceTiendaApplication.class, args);
	}

}
