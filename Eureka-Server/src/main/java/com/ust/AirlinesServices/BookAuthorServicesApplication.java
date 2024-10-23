package com.ust.AirlinesServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookAuthorServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAuthorServicesApplication.class, args);
	}

}
