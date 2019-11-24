package com.lang.xu.hao.eurekaserver.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Xuhao
 * @Description:
 * @Date: Created in 17:40 2018/12/2
 */
@Configuration
public class InitParam {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
