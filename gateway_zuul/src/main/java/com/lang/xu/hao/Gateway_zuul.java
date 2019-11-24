package com.lang.xu.hao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
class Gateway_zuul {

	public static void main(String[] args) {
		SpringApplication.run(Gateway_zuul.class, args);
	}
}
