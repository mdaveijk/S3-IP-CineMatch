package com.cinematch.userpreferencesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info (
	title = "User Preferences API", version = "1.0", description = "Documentation User Preferences API v1.0"	
))
public class UserPreferencesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserPreferencesServiceApplication.class, args);
	}

}
