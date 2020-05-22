package com.brq.EMotos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.brq.EMotos.controllers"})
@EntityScan(basePackages = {"com.brq.EMotos.models"})
@SpringBootApplication
public class ApiEMotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEMotosApplication.class, args);
	}

}
