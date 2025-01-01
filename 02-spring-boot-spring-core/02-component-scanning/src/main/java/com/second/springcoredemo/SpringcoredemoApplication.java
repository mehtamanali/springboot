package com.second.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// explict component scanning
/*@SpringBootApplication(
	scanBasePackages ={"com.second.springcoredemo",
	                   "com.second.util"}
)*/

@SpringBootApplication //default component scanning
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
