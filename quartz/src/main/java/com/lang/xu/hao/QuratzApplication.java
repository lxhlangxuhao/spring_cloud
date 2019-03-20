package com.lang.xu.hao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
class QuratzApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuratzApplication.class, args);
	}
}
