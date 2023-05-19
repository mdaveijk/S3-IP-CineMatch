package com.cinematch.usermatchingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info (
	title = "User-Matching API", version = "1.0", description = "Documentation User-Matching API v1.0"	
))
public class UserMatchingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMatchingServiceApplication.class, args);
	}
  
}

