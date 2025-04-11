package com.banco.banco_digital.repositories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.banco.banco_digital")
@EntityScan(basePackages = "com.banco.banco_digital.entities")
@EnableJpaRepositories(basePackages = "com.banco.banco_digital.repositories")
public class BancoDigitalApplication {
	public static void main(String[] args) {
		SpringApplication.run(BancoDigitalApplication.class, args);
	}
}
