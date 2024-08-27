package com.example.configreg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ConfigRegApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigRegApplication.class, args);
	}

}
