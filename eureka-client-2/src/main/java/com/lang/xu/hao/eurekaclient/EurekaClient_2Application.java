package com.lang.xu.hao.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient_2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient_2Application.class, args);
	}
}
