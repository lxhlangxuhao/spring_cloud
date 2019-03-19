package com.lang.xu.hao.eurekaserver;

import com.lang.xu.hao.eurekaserver.SpringBean.User;
import javax.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {


	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
