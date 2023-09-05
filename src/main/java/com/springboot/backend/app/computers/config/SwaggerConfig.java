package com.springboot.backend.app.computers.config;

import java.util.Collections;

import javax.swing.JOptionPane;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.springboot.backend.app.computers.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());

	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				
				getTitle(),
				getDescription(),
				getVersion(),
				getTermsOfServiceUrl(),
				getContact(),
				"LICENSE",
				"LICENSEURL",
				Collections.emptyList()
					
				);
		
		
	}
	public void Test() {
		getApiInfo();
		System.out.println(getApiInfo());
		JOptionPane.showMessageDialog(null, getApiInfo());
	}
	
	public String getTitle() {
		
		return "API de Dibujos";
		
	}
	
	public String getDescription() {
		
		return "Servicio de dibujos y esculturas de distinta indole de mi primo Luis Alberto Diaz Juarez "+
                 "que tiene como nombre representativo Albert ArtHeart";
		
	}
	
	public String getVersion() {
		
		return "1.1";
		
	}
	
	public String getTermsOfServiceUrl(){
		
	return "Terminos de Servicio";
	
	}
	
	public Contact getContact() {
		
		return new Contact(getName(),getUrl(),getEmail());
		
	}
	public String getName() {
		
		return "Miguel Angel Vazquez Diaz";
		
	}
	
	public String getEmail() {
		
		return "polliyo67@gmail.com";
		
	}
	
	public String getUrl() {
		return "https://miguelvazquez.streamlit.app/";
	}

	
	

}
