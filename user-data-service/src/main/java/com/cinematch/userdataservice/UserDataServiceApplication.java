package com.cinematch.userdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info (
	title = "User-Data API", version = "1.0", description = "Documentation User-Data API v1.0"	
))
public class UserDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDataServiceApplication.class, args);
	}

}
