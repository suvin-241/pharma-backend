package com.pharma.itsmypharma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ItsmypharmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsmypharmaApplication.class, args);
	}

}
