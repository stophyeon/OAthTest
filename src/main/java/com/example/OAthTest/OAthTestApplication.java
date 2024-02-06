package com.example.OAthTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OAthTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAthTestApplication.class, args);
	}

}
