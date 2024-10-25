package com.Library.AuthentictaionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AuthentictaionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthentictaionServiceApplication.class, args);
	}

}
