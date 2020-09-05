package com.api.challenge.pdcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class PdCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdCaseApplication.class, args);
	}
	
	@Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
