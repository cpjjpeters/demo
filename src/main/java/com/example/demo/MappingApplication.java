package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MappingApplication {

	private static final Logger log = LoggerFactory.getLogger(MappingApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}

}
