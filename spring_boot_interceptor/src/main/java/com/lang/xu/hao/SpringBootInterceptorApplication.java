package com.lang.xu.hao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootInterceptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInterceptorApplication.class, args);
	}
}
