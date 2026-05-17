
package com.example.SpringMVCNoSQL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringMvcNoSqlApplication {

	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcNoSqlApplication.class, args);
	}


	@PostConstruct
	public void printMongoUri() {
		System.out.println("MONGO URI = " + mongoUri);
	}
}