package com.lang.xu.hao.eurekauser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaUser_3Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaUser_3Application.class, args);
	}
}
 