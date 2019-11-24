package com.lang.xu.hao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EurekaClient_feign_hystirx_factoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient_feign_hystirx_factoryApplication.class, args);
	}
}
