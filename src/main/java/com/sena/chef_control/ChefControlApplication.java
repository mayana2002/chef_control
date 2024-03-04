package com.sena.chef_control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ChefControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChefControlApplication.class, args);
	}

}