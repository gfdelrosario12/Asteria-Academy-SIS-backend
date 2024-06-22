package com.asteria_academy.sis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.asteria_academy.sis.repository")
public class SisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisApplication.class, args);
	}

}
