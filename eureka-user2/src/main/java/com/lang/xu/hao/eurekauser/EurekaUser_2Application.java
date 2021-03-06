package com.lang.xu.hao.eurekauser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "EUREKA-CLIENT", configuration = TestConfiguration.class)
//@EnableCircuitBreaker
@EnableRedisHttpSession
public class EurekaUser_2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaUser_2Application.class, args);
	}
}
