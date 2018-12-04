package com.lang.xu.hao.eurekauser;

import com.lang.xu.hao.eurekauser.eurekaserver.annotation.ExcludeFormComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "EUREKA-CLIENT", configuration = TestConfiguration.class)
//自定义标签@ExcludeFormComponent ComponentScan 不自动装配
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFormComponent.class)})
public class EurekaUserTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaUserTwoApplication.class, args);
	}
}
 