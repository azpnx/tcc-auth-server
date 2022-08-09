package com.tcc.psiauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PsiAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsiAuthApplication.class, args);
	}

}
