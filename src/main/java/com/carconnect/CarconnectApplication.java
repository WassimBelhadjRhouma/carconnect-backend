package com.carconnect;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CarconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarconnectApplication.class, args);
	}

}
