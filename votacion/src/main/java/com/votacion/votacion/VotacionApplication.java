package com.votacion.votacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @ComponentScan(basePackages = { "com.votacion.votacion" })
public class VotacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotacionApplication.class, args);
	}

}
