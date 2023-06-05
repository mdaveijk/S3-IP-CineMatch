package com.cinematch.userdataservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import com.cinematch.userdataservice.config.H2JpaConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { UserDataServiceApplication.class, H2JpaConfig.class })
@ActiveProfiles("test")
class UserDataServiceApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void contextLoads() {
		assertNotNull(context);
	}

}
