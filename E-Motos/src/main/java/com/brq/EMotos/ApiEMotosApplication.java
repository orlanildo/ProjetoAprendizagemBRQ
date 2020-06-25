package com.brq.EMotos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages={"com.brq.EMotos.services"})
//@Component({"com.brq.EMotos.services"})
//@ComponentScan({"com.brq.EMotos.controllers"})
//@EntityScan(basePackages = {"com.brq.EMotos.models"})
@SpringBootApplication
public class ApiEMotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEMotosApplication.class, args);
	}

}
