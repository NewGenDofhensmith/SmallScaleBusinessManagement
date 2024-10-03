package com.retail.retailManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.kie.api.KieServices;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class RetailManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailManagementApplication.class, args);

	}

}
