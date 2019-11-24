package com.lang.xu.hao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 郎栩浩
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringBootQuartz_2 {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootQuartz_2.class, args);
	}
}
