package com.lang.xu.hao.eurekauser;

import com.lang.xu.hao.itmuch.TestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "EUREKA-CLIENT", configuration = TestConfiguration.class)
public class EurekaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaUserApplication.class, args);
	}
}
