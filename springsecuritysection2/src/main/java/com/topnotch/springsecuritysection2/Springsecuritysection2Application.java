package com.topnotch.springsecuritysection2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.topnotch.springsecuritysection2.repository")
public class Springsecuritysection2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springsecuritysection2Application.class, args);
	}

}
