package com.lang.xu.hao.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableEurekaServer
@SpringBootApplication
@EnableRedisHttpSession
public class EurekaServerApplication {

	public static void main(String[] args) {
		// 禁用重新启动支持
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
