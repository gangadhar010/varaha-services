package com.varaha.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.varaha")
public class VarahaServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VarahaServicesApplication.class, args);
	}

}
