package com.github.diegogomesaraujo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ViacepMiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViacepMiddlewareApplication.class, args);
	}

}
