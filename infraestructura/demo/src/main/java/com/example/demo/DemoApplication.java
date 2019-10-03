package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// import org.springframework.context.annotation.FilterType;
// import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;/*  */

@SpringBootApplication/*(exclude = {SecurityAutoConfiguration.class,
		UserDetailsServiceAutoConfiguration.class})*/
@ComponentScan(basePackages = { "com.example.demo" })
@EnableEurekaClient
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
